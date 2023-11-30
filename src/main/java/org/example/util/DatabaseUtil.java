package org.example.util;

import org.example.models.User;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

public class DatabaseUtil {

    private static final String URI = "bolt://localhost:7687"; // Neo4j database URI
    private static final String USERNAME = "neo4j"; // Neo4j username
    private static final String PASSWORD = "password"; // Neo4j password
    private static Driver driver;

    public static void initializeDatabase() {
        try {
            driver = GraphDatabase.driver(URI, AuthTokens.basic(USERNAME, PASSWORD));
            System.out.println("Connected to Neo4j database.");
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public static Session getSession() {
        if (driver == null) {
            initializeDatabase();
        }
        return driver.session();
    }

    public static void closeDatabase() {
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
}
