package org.example.util;

import com.github.javafaker.Faker;
import org.neo4j.driver.*;

import java.util.Random;


public class Neo4jDataPopulation {

    public static void main(String[] args) {
        // Neo4j connection details
        String uri = "bolt://localhost:7687";
        String usernameNeo4j = "neo4j";
        String passwordNeo4j = "neo4j";

        // Neo4j driver setup
        try (Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(usernameNeo4j, passwordNeo4j))) {
            // Generate fake data using Java Faker
            Faker faker = new Faker();

            // Number of items, users, storage facilities, and reports to generate
            int numItems = 5000;
            var random = new Random();


            try (Session session = driver.session()) {
                // Create items
                for (int i = 1; i <= numItems; i++) {
                    String itemId = "item" + i;
                    String itemName = faker.commerce().productName();
                    String description = faker.lorem().sentence();
                    double price = faker.number().randomDouble(2, 10, 500);
                    int quantity = random.nextInt(1000);

                    session.run("CREATE (i:Item {itemId: $itemId, itemName: $itemName, description: $description, price: $price, quantity: $quantity})",
                            Values.parameters("itemId", itemId, "itemName", itemName, "description", description, "price", price, "quantity", quantity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
