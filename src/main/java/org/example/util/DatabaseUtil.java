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
            Record record = session.run("MATCH (u:User {username: $username}) RETURN u",
                    Values.parameters("username", username)).single();

            if (record != null) {
                Node userNode = record.get("u").asNode();
                return new User(
                        userNode.get("username").asString(),
                        userNode.get("role").asString(),
                        userNode.get("password").asString(),
                        userNode.get("email").asString()
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
            session.run("CREATE (i:Item {itemId: $itemId, itemName: $itemName, quantity: $quantity, description: $description, price: $price})",
                    Values.parameters(
                            "itemId", item.getItemId(),
                            "itemName", item.getItemName(),
                            "quantity", item.getQuantity(),
                            "description", item.getDescription(),
                            "price", item.getPrice()
                    ));
            System.out.println("Item added to the database: " + item.getItemName());
        } catch (Exception e) {
            System.out.println("Error adding item: " + e.getMessage());
        }
    }


    // Remove item from the database
    public void removeItemFromDatabase(Item item) {
        try (Session session = getSession()) {
            session.run("MATCH (i:Item {itemId: $itemId}) DETACH DELETE i",
                    Values.parameters("itemId", item.getItemId()));
            System.out.println("Item removed from the database: " + item.getItemId());
        } catch (Exception e) {
            System.out.println("Error removing item: " + e.getMessage());
        }
    }

    public List<Item> getAllItemsFromDatabase() {
        List<Item> itemList = new ArrayList<>();
        try (Session session = getSession()) {
            Result result = session.run("MATCH (i:Item) RETURN i");
            while (result.hasNext()) {
                Record record = result.next();
                Node itemNode = record.get("i").asNode();

                String itemId = itemNode.get("itemId").asString();
                String itemName = itemNode.get("itemName").asString();
                int quantity = itemNode.get("quantity").isNull() ? 0 : itemNode.get("quantity").asInt();
                String description = itemNode.get("description").asString();
                double price = itemNode.get("price").isNull() ? 0.0 : itemNode.get("price").asDouble();

                itemList.add(new Item(itemId, itemName, quantity, description, price));
            }
        } catch (Exception e) {
            System.out.println("Error retrieving items: " + e.getMessage());
        }
        return itemList;
    }


    public boolean addUser(User newUser) {
        try (Session session = getSession()) {
            session.run("CREATE (u:User {userId: $userId, username: $username, role: $role, password: $password, email: $email, name: $name})",
                    Values.parameters(
                            "userId", newUser.getUserId(),
                            "username", newUser.getUsername(),
                            "role", newUser.getRole(),
                            "password", newUser.getPassword(),
                            "email", newUser.getUserEmail()
                    ));
            System.out.println("User added to the database: " + newUser.getUsername());
            return true;
        } catch (Exception e) {
            System.out.println("Error adding user: " + e.getMessage());
            return false;
        }
    }







}
