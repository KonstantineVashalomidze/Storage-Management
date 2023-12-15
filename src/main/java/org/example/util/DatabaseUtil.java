package org.example.util;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.models.Supplier;
import org.example.models.User;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private static final String URI = "bolt://localhost:7687"; // Neo4j database URI
    private static final String USERNAME = "neo4j"; // Neo4j username
    private static final String PASSWORD = "password"; // Neo4j password
    private static Driver driver;
    private static DatabaseUtil instance;

    // Private constructor to prevent external instantiation
    private DatabaseUtil() {
        // Initialize the database connection
        initializeDatabase();
    }

    // Method to get the singleton instance
    public static synchronized DatabaseUtil getInstance() {
        if (instance == null) {
            instance = new DatabaseUtil();
        }
        return instance;
    }

    private void initializeDatabase() {
        try {
            driver = GraphDatabase.driver(URI, AuthTokens.basic(USERNAME, PASSWORD));
            System.out.println("Connected to Neo4j database.");
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public Session getSession() {
        if (driver == null) {
            initializeDatabase();
        }
        return driver.session();
    }

    public void closeDatabase() {
        if (driver != null) {
            driver.close();
            System.out.println("Database connection closed.");
        }
    }

    public List<Product> getAllTheProduct()
    {
        List<Product> productList = new ArrayList<>();

        try (Session session = getSession()) {
            Result result = session.run("MATCH (p:Product) RETURN p");

            while (result.hasNext()) {
                Record record = result.next();
                Node userNode = record.get("p").asNode();

                // Retrieve user properties from the node
                String productName = userNode.get("productName").asString();
                String category = userNode.get("category").asString();
                String sellingPrice = userNode.get("sellingPrice").asString();
                String image = userNode.get("image").asString();
                String stockQuantity = userNode.get("stockQuantity").asString();
                String description = userNode.get("description").asString();
                String costPrice = userNode.get("costPrice").asString();
                String minimumStockLevel = userNode.get("minimumStockLevel").asString();
                String unitOfMeasure = userNode.get("unitOfMeasure").asString();
                String dateAdded = userNode.get("dateAdded").asString();
                String lastUpdated = userNode.get("lastUpdated").asString();
                String productID = userNode.get("productID").asString();

                // Create and return a Product object
                var product = new Product(productName, category, sellingPrice, image, stockQuantity, description, costPrice, minimumStockLevel, unitOfMeasure, dateAdded, lastUpdated, productID);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;


    }


    public List<User> getAllTheUsers()
    {
        List<User> userList = new ArrayList<>();

        try (Session session = getSession()) {
            Result result = session.run("MATCH (u:User) RETURN u");

            while (result.hasNext()) {
                Record record = result.next();
                Node userNode = record.get("u").asNode();

                // Retrieve user properties from the node
                String username = userNode.get("username").asString();
                String role = userNode.get("role").asString();
                String password = userNode.get("password").asString();
                String userId = userNode.get("userId").asString();

                // Create and return a User object
                var user = new User(username, role, password, userId);
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;



    }


    public User getUserByUsername(String uName) {
        try (var session = getSession())
        {
            var result = session.run("MATCH (u:User {username: $username}) return (u)", Values.parameters("username", uName));
            if (result.hasNext()) {
                Record record = result.next();
                Node userNode = record.get("u").asNode();

                // Retrieve user properties from the node
                String username = userNode.get("username").asString();
                String role = userNode.get("role").asString();
                String password = userNode.get("password").asString();
                String userId = userNode.get("userId").asString();

                // Create and return a User object
                return new User(username, role, password, userId);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addUser(User newUser)
    {
        try (var session = getSession())
        {
            session.run("CREATE (:User {username: $username, role: $role, password: $password, userId: $userId})",
                    Values.parameters("username", newUser.getUsername(),
                            "role", newUser.getRole(),
                            "password", newUser.getPassword(),
                            "userId", newUser.getUserId()));
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public List<Customer> getAllTheCustomers() {
        List<Customer> customerList = new ArrayList<>();

        try (Session session = getSession()) {
            Result result = session.run("MATCH (c:Customer) RETURN c");

            while (result.hasNext()) {
                Record record = result.next();
                Node customerNode = record.get("c").asNode();

                String customerID = customerNode.get("customerID").asString();
                String customerName = customerNode.get("customerName").asString();
                String contactInformation = customerNode.get("contactInformation").asString();

                var customer = new Customer(customerID, customerName, contactInformation);
                customerList.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;

    }

    public List<Supplier> getAllTheSuppliers() {
        List<Supplier> supplierList = new ArrayList<>();

        try (Session session = getSession()) {
            Result result = session.run("MATCH (c:Supplier) RETURN c");

            while (result.hasNext()) {
                Record record = result.next();
                Node supplierNode = record.get("c").asNode();

                String supplierID = supplierNode.get("supplierID").asString();
                String supplierName = supplierNode.get("supplierName").asString();
                String contactInformation = supplierNode.get("contactInformation").asString();

                var supplier = new Supplier(supplierID, supplierName, contactInformation);
                supplierList.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierList;
    }
}
