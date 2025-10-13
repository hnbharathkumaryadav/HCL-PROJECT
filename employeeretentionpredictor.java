// employeeretentionpredictor.java
// Single-file Java app demonstrating CRUD with MongoDB (sync driver) and a simple retention predictor.

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Scanner;

public class employeeretentionpredictor {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // change if needed
    private static final String DB_NAME = "employeeDB";
    private static final String COLL_NAME = "employees";

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public employeeretentionpredictor() {
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DB_NAME);
        collection = database.getCollection(COLL_NAME);
    }

    // Create
    public String createEmployee(String name, int age, int yearsAtCompany, double satisfaction, int performanceRating) {
        Document doc = new Document("name", name)
                .append("age", age)
                .append("yearsAtCompany", yearsAtCompany)
                .append("satisfaction", satisfaction)        // 0.0 - 1.0
                .append("performanceRating", performanceRating); // e.g., 1..5
        collection.insertOne(doc);
        ObjectId id = doc.getObjectId("_id");
        return id.toHexString();
    }

    // Read (by id)
    public Document readEmployee(String idHex) {
        ObjectId id = new ObjectId(idHex);
        Document doc = collection.find(Filters.eq("_id", id)).first();
        return doc;
    }

    // Update (by id) - partial update using provided values (null means ignore)
    public boolean updateEmployee(String idHex, String name, Integer age, Integer yearsAtCompany, Double satisfaction, Integer performanceRating) {
        ObjectId id = new ObjectId(idHex);
        Document setDoc = new Document();
        if (name != null) setDoc.append("name", name);
        if (age != null) setDoc.append("age", age);
        if (yearsAtCompany != null) setDoc.append("yearsAtCompany", yearsAtCompany);
        if (satisfaction != null) setDoc.append("satisfaction", satisfaction);
        if (performanceRating != null) setDoc.append("performanceRating", performanceRating);

        if (setDoc.isEmpty()) return false;
        Document update = new Document("$set", setDoc);
        return collection.updateOne(Filters.eq("_id", id), update).getModifiedCount() > 0;
    }

    // Delete (by id)
    public boolean deleteEmployee(String idHex) {
        ObjectId id = new ObjectId(idHex);
        return collection.deleteOne(Filters.eq("_id", id)).getDeletedCount() > 0;
    }

    // List all
    public void listEmployees() {
        System.out.println("=== Employees in DB ===");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    // Very simple retention predictor (heuristic)
    // outputs "Likely to stay" / "At risk of leaving" with a score 0..1
    public double predictRetentionScore(Document emp) {
        // features
        double satisfaction = emp.getDouble("satisfaction");       // 0..1
        int years = emp.getInteger("yearsAtCompany");
        int perf = emp.getInteger("performanceRating");            // 1..5

        // simple scoring:
        // base 0.5, add satisfaction*0.3, add normalized perf*0.15, add years factor*0.05
        double score = 0.5;
        score += satisfaction * 0.3;
        score += ((perf - 1) / 4.0) * 0.15; // normalize perf to 0..1
        score += Math.min(years, 10) / 10.0 * 0.05; // years 0..10 scaled

        // clamp to 0..1
        if (score < 0) score = 0;
        if (score > 1) score = 1;
        return score;
    }

    public String predictRetentionLabel(Document emp) {
        double score = predictRetentionScore(emp);
        if (score >= 0.7) return "Likely to stay (" + String.format("%.2f", score) + ")";
        if (score >= 0.45) return "Neutral / monitor (" + String.format("%.2f", score) + ")";
        return "At risk of leaving (" + String.format("%.2f", score) + ")";
    }

    public void close() {
        mongoClient.close();
    }

    // Simple interactive demo CLI
    public static void main(String[] args) {
        employeeretentionpredictor app = new employeeretentionpredictor();
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Employee Retention Predictor ===");
        System.out.println("Connected to MongoDB at " + CONNECTION_STRING + ", Database: " + DB_NAME);

        while (true) {
            System.out.println("\nChoose: 1=create 2=read 3=update 4=delete 5=list 6=predict 7=exit");
            String cmd = sc.nextLine().trim();
            try {
                if (cmd.equals("1")) {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Years at company: "); int years = Integer.parseInt(sc.nextLine());
                    System.out.print("Satisfaction (0.0 - 1.0): "); double sat = Double.parseDouble(sc.nextLine());
                    System.out.print("Performance rating (1-5): "); int perf = Integer.parseInt(sc.nextLine());
                    String id = app.createEmployee(name, age, years, sat, perf);
                    System.out.println("Inserted with id: " + id);
                } else if (cmd.equals("2")) {
                    System.out.print("Employee id: "); String id = sc.nextLine();
                    Document d = app.readEmployee(id);
                    System.out.println(d == null ? "Not found" : d.toJson());
                } else if (cmd.equals("3")) {
                    System.out.print("Employee id: "); String id = sc.nextLine();
                    System.out.print("Name (or leave blank): "); String name = sc.nextLine(); if (name.isEmpty()) name = null;
                    System.out.print("Age (or leave blank): "); String ageS = sc.nextLine(); Integer age = ageS.isEmpty()?null:Integer.parseInt(ageS);
                    System.out.print("Years at company (or leave blank): "); String yrsS = sc.nextLine(); Integer yrs = yrsS.isEmpty()?null:Integer.parseInt(yrsS);
                    System.out.print("Satisfaction (0-1) (or leave blank): "); String satS = sc.nextLine(); Double sat = satS.isEmpty()?null:Double.parseDouble(satS);
                    System.out.print("Performance rating (1-5) (or leave blank): "); String pS = sc.nextLine(); Integer p = pS.isEmpty()?null:Integer.parseInt(pS);
                    boolean ok = app.updateEmployee(id, name, age, yrs, sat, p);
                    System.out.println(ok ? "Updated" : "No changes / not found");
                } else if (cmd.equals("4")) {
                    System.out.print("Employee id: "); String id = sc.nextLine();
                    boolean ok = app.deleteEmployee(id);
                    System.out.println(ok ? "Deleted" : "Not found");
                } else if (cmd.equals("5")) {
                    app.listEmployees();
                } else if (cmd.equals("6")) {
                    System.out.print("Employee id: "); String id = sc.nextLine();
                    Document d = app.readEmployee(id);
                    if (d == null) System.out.println("Not found");
                    else System.out.println(app.predictRetentionLabel(d));
                } else if (cmd.equals("7")) {
                    break;
                } else {
                    System.out.println("Unknown option");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace(System.out);
            }
        }

        app.close();
        System.out.println("Bye.");
    }
}
