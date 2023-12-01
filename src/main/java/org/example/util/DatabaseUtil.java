package org.example.util;

import org.example.models.Item;
import org.example.models.User;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

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

    public User getUserByUsername(String username) {
        try (Session session = getSession()) {
            String query = "MATCH (u:User {username: $username}) RETURN u";
            Result result = session.run(query, Values.parameters("username", username));
            if (result.hasNext()) {
                Record record = result.next();
                Node userNode = record.get("u").asNode();
                // Extract user properties and create User object

                return new User(
                        userNode.get("username").asString(),
                        userNode.get("role").asString(),
                        userNode.get("password").asString(),
                        String.valueOf(userNode.get("userId").asLong()),
                        userNode.get("email").asString(),
                        userNode.get("name").asString()
                );
            }
        } catch (Exception e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }
        return null;
    }

    // Add item to the database
    public void addItemToDatabase(Item item) {
        try (Session session = getSession()) {
            String query = "CREATE (item:Item {name: $name, quantity: $quantity})";
            session.run(query, Values.parameters("name", item.getItemName(), "quantity", item.getQuantity()));
            System.out.println("Item added to the database: " + item.getItemName());
        } catch (Exception e) {
            System.out.println("Error adding item to the database: " + e.getMessage());
        }
    }

    // Remove item from the database
    public void removeItemFromDatabase(Item item) {
        try (Session session = getSession()) {
            String query = "MATCH (item:Item {name: $name}) DELETE item";
            session.run(query, Values.parameters("name", item.getItemName()));
            System.out.println("Item removed from the database: " + item.getItemName());
        } catch (Exception e) {
            System.out.println("Error removing item from the database: " + e.getMessage());
        }
    }

    public List<Item> getAllItemsFromDatabase()
    {
        List<Item> items = new ArrayList<>();
        try (Session session = getSession()) {
            String query = "MATCH (i:Item) RETURN i";
            Result result = session.run(query);
            while (result.hasNext()) {
                Record record = result.next();
                Node itemNode = record.get("i").asNode();

                // Extract item properties and create Item object
                Item item = new Item(
                        String.valueOf(itemNode.get("itemId").asLong()), // Assuming itemId is stored as a Long in the database
                        itemNode.get("itemName").asString(),
                        itemNode.get("quantity").asInt(),
                        itemNode.get("description").asString(),
                        itemNode.get("unitPrice").asDouble() // Assuming the property in the database is 'unitPrice'
                );

                items.add(item);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving items from the database: " + e.getMessage());
        }
        return items;
    }

    public boolean addUser(User newUser) {
        try (Session session = getSession()) {
            String query = "CREATE (u:User {username: $username, password: $password, role: $role, userId: $userId, email: $email, name: $name})";
            session.run(query, Values.parameters(
                    "username", newUser.getUsername(),
                    "password", newUser.getPassword(),
                    "role", newUser.getRole(),
                    "userId", Long.parseLong(newUser.getUserId()), // Assuming userId is stored as a String in the User object
                    "email", newUser.getUserEmail(),
                    "name", newUser.getName()
            ));
            System.out.println("User added to the database: " + newUser.getUsername());
            return true;
        } catch (Exception e) {
            System.out.println("Error adding user to the database: " + e.getMessage());
            return false;
        }
    }
}
