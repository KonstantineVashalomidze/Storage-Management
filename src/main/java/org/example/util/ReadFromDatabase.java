package org.example.util;

import org.example.models.*;
import org.example.models.Transaction;
import org.neo4j.driver.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadFromDatabase
{

    private static final String uri = "bolt://localhost:7687"; // Your Neo4j URI
    private static final String username = "neo4j";
    private static final String password = "password";


    public static void main(String[] args) {
        File customersFile = new File("customers.txt");
        File productDataFile = new File("ProductData.txt");
        File purchaseFile = new File("purchase.txt");
        File salesTransactionFile = new File("transactions.txt");
        File suppliersFile = new File("suppliers.txt");
        File userDataFile = new File("user_data.txt");

        ReadFromDatabase read = new ReadFromDatabase();

        List<Customer> customers = read.readCustomersFromFiles(customersFile);
        List<Product> products = read.readProductsFromFiles(productDataFile);
        List<Purchase> purchases = read.readPurchasesFromFiles(purchaseFile);
        List<Transaction> transactions = read.readTransactionsFromFiles(salesTransactionFile);
        List<Supplier> suppliers = read.readSuppliersFromFiles(suppliersFile);
        List<User> users = read.readUsersFromFiles(userDataFile);





        // Create Neo4j driver instance
        try (Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password))) {
            // Create Neo4j session
            try (Session session = driver.session()) {

                // Create nodes for customers
                for (Customer customer : customers) {
                    session.run("CREATE (:Customer {customerID: $customerID, customerName: $customerName, contactInformation: $contactInformation})",
                            Values.parameters("customerID", customer.getCustomerID(),
                                    "customerName", customer.getCustomerName(),
                                    "contactInformation", customer.getContactInformation()));
                }
                // Create nodes for products
                for (Product product : products) {
                    session.run("CREATE (:Product {productName: $productName, category: $category, sellingPrice: $sellingPrice, image: $image, stockQuantity: $stockQuantity, description: $description, costPrice: $costPrice, minimumStockLevel: $minimumStockLevel, unitOfMeasure: $unitOfMeasure, dateAdded: $dateAdded, lastUpdated: $lastUpdated, productID: $productID})",
                            Values.parameters(
                                    "productName", product.getProductName(),
                                    "category", product.getCategory(),
                                    "sellingPrice", product.getSellingPrice(),
                                    "image", product.getImage(),
                                    "stockQuantity", product.getStockQuantity(),
                                    "description", product.getDescription(),
                                    "costPrice", product.getCostPrice(),
                                    "minimumStockLevel", product.getMinimumStockLevel(),
                                    "unitOfMeasure", product.getUnitOfMeasure(),
                                    "dateAdded", product.getDateAdded(),
                                    "lastUpdated", product.getLastUpdated(),
                                    "productID", product.getProductID()));
                }

                // Create nodes for purchases
                for (Purchase purchase : purchases)
                {
                    session.run("CREATE (:Purchase {purchaseId: $purchaseId, purchaseDate: $purchaseDate, deliveryDate: $deliveryDate, quantity: $quantity})",
                            Values.parameters(
                                    "purchaseId", purchase.getPurchaseID(),
                                    "purchaseDate", purchase.getPurchaseDate(),
                                    "deliveryDate", purchase.getDeliveryDate(),
                                    "quantity", purchase.getQuantity()
                            ));


                }
                // Create nodes for transactions
                for (Transaction transaction : transactions)
                {
                    session.run("CREATE (:Transaction {transactionId: $transactionId, date: $date, totalCost: $totalCost, discountsApplied: $discountsApplied})",
                            Values.parameters(
                                "transactionId", transaction.getTransactionID(),
                                "date", transaction.getDate(),
                                "totalCost", transaction.getTotalCost(),
                                "discountsApplied", transaction.getDiscountsApplied()
                            ));
                }

                // Create nodes for users
                for (User user : users) {
                    session.run("CREATE (:User {username: $username, role: $role, password: $password, userId: $userId})",
                            Values.parameters("username", user.getUsername(),
                                    "role", user.getRole(),
                                    "password", user.getPassword(),
                                    "userId", user.getUserId()));
                }

                // Create nodes for suppliers
                for (Supplier supplier : suppliers) {
                    session.run("CREATE (:Supplier {supplierID: $supplierID, supplierName: $supplierName, contactInformation: $contactInformation})",
                            Values.parameters("supplierID", supplier.getSupplierID(),
                                    "supplierName", supplier.getSupplierName(),
                                    "contactInformation", supplier.getContactInformation()));
                }



                for (Transaction transaction : transactions) {
                    session.run("MATCH (na:Transaction {transactionId: $transactionId}), (nb:Customer {customerID: $customerID}) " +
                                    "CREATE (na)-[:MADE_PURCHASE]->(nb)",
                            Values.parameters(
                                    "transactionId", transaction.getTransactionID(),
                                    "customerID", transaction.getCustomerID()
                            ));

                    session.run("MATCH (na:Transaction {transactionId: $transactionId}), (nb:Product {productID: $productID}) " +
                                    "CREATE (na)-[:OF_PRODUCT]->(nb)",
                            Values.parameters(
                                    "transactionId", transaction.getTransactionID(),
                                    "productID", transaction.getProductID()
                            ));
                }

                for (Purchase purchase : purchases) {
                    session.run("MATCH (na:Purchase {purchaseId: $purchaseId}), (nb:Supplier {supplierID: $supplierID}) " +
                                    "CREATE (na)-[:FROM_SUPPLIER]->(nb)",
                            Values.parameters(
                                    "purchaseId", purchase.getPurchaseID(),
                                    "supplierID", purchase.getSupplierID()
                            ));

                    session.run("MATCH (na:Purchase {purchaseId: $purchaseId}), (nb:Product {productID: $productID}) " +
                                    "CREATE (na)-[:THE_PRODUCT]->(nb)",
                            Values.parameters(
                                    "purchaseId", purchase.getPurchaseID(),
                                    "productID", purchase.getProductID()
                            ));

                    session.run("MATCH (na:Purchase {purchaseId: $purchaseId}), (nb:User {userId: $userId}) " +
                                    "CREATE (na)-[:MADE_BY_USER {purchaseDate: $purchaseDate}]->(nb)",
                            Values.parameters(
                                    "purchaseId", purchase.getPurchaseID(),
                                    "userId", purchase.getUserID(),
                                    "purchaseDate", purchase.getPurchaseDate()
                            ));
                }



            }
        }


    }

    private List<Purchase> readPurchasesFromFiles(File customersFile) {
        List<Purchase> result = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(customersFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean firstLineIndicator = true;
        while (scanner.hasNextLine())
        {
            if (firstLineIndicator)
            {
                scanner.nextLine();
                firstLineIndicator = false;
            }
            else
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");
                var purchId = data[0].trim();
                var purchDate = data[1].trim();
                var deliveryDate = data[2].trim();
                var quantity = data[3].trim();
                var supplierId = data[4].trim();
                var productId = data[5].trim();
                var userId = data[6].trim();



                var purchase = new Purchase(purchId, purchDate, deliveryDate, quantity, supplierId, productId, userId);
                result.add(purchase);
            }
        }
        return result;
    }

    private List<User> readUsersFromFiles(File customersFile) {
        List<User> result = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(customersFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean firstLineIndicator = true;
        while (scanner.hasNextLine())
        {
            if (firstLineIndicator)
            {
                scanner.nextLine();
                firstLineIndicator = false;
            }
            else
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");

                var username = data[0].trim();
                var role = data[1].trim();
                var password = data[2].trim();
                var userId = data[3].trim();


                var user = new User(username, role, password, userId);

                result.add(user);
            }
        }
        return result;
    }

    private List<Supplier> readSuppliersFromFiles(File customersFile) {
        List<Supplier> result = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(customersFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean firstLineIndicator = true;
        while (scanner.hasNextLine())
        {
            if (firstLineIndicator)
            {
                scanner.nextLine();
                firstLineIndicator = false;
            }
            else
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");

                String supplierId = data[0].trim();
                String supplierName = data[1].trim();
                String contactInfo = data[2].trim();


                var supplier = new Supplier(supplierId, supplierName, contactInfo);

                result.add(supplier);
            }
        }
        return result;
    }

    private List<Transaction> readTransactionsFromFiles(File customersFile) {
        List<Transaction> result = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(customersFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean firstLineIndicator = true;
        while (scanner.hasNextLine())
        {
            if (firstLineIndicator)
            {
                scanner.nextLine();
                firstLineIndicator = false;
            }
            else
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");


                var transaction = new Transaction(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim());
                result.add(transaction);
            }
        }
        return result;
    }

    private List<Product> readProductsFromFiles(File customersFile) {
        List<Product> result = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(customersFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean firstLineIndicator = true;
        while (scanner.hasNextLine())
        {
            if (firstLineIndicator)
            {
                scanner.nextLine();
                firstLineIndicator = false;
            }
            else
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");


                var product = new Product(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(), data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim(), data[9].trim(), data[10].trim(), data[11].trim());
                result.add(product);
            }
        }
        return result;
    }


    public List<Customer> readCustomersFromFiles(File file)
    {
        List<Customer> result = new ArrayList<>();

        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean firstLineIndicator = true;
        while (scanner.hasNextLine())
        {
            if (firstLineIndicator)
            {
                scanner.nextLine();
                firstLineIndicator = false;
            }
            else
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\|");
                var id = data[0].trim();
                var name = data[1].trim();
                var contact = data[2].trim();

                var customer = new Customer(id, name, contact);
                result.add(customer);


            }
        }
        return result;
    }


}
