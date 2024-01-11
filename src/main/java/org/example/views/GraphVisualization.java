package org.example.views;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.example.controllers.Controller;
import org.example.models.*;
import org.example.util.DatabaseUtil;
import org.example.views.view_components.BetterScrollPane;
import org.example.views.view_components.BetterTable;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Relationship;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class GraphVisualization extends JPanel implements Controller {
    private int x = 20;
    private int y = 20;

    private BetterTable attributesTable;

    private Map<String, Model> stringToModelMap;


    public GraphVisualization(List<Record> records) {
        setLayout(new BorderLayout());

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        stringToModelMap = new HashMap<>();
        attributesTable = new BetterTable();
        attributesTable.setModel(new DefaultTableModel(new Object[]{"Attribute", "Value"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        graph.setEdgeLabelsMovable(false);
        graph.setAllowDanglingEdges(false);

        // Check if already inserted the node in graph
        HashSet<String> hashSetOfIds = new HashSet<>();

        // Save element ids of the vertex
        Map<String, Object> idToObjectMap = new HashMap<>();


        graph.getModel().beginUpdate();
        try {


            for (Record record : records)
            {

                // Extracting data from the record
                Node customerNode = record.get("c").asNode();
                Node transactionNode = record.get("t").asNode();
                Node productNode = record.get("p").asNode();
                Node purchaseNode = record.get("pr").asNode();
                Node supplierNode = record.get("s").asNode();
                Node userNode = record.get("u").asNode();

                // Creating objects using extracted data
                String customerID = customerNode.get("customerID").asString();
                String productID = productNode.get("productID").asString();
                String purchaseID = purchaseNode.get("purchaseId").asString();
                String supplierID = supplierNode.get("supplierID").asString();
                String transactionID = transactionNode.get("transactionId").asString();
                String userID = userNode.get("userId").asString();


                // Add vertices for each node with manual positions
                if (!hashSetOfIds.contains(customerNode.elementId()))
                {
                    Object customerVertex = graph.insertVertex(parent, null, customerID, x, y, 80, 30, "shape=ellipse;fillColor=#6636d2");
                    idToObjectMap.put(customerNode.elementId(), customerVertex);
                    stringToModelMap.put(customerID, new Customer(customerNode.get("customerID").asString(), customerNode.get("customerName").asString(), customerNode.get("contactInformation").asString()));
                    updatePosition();
                }

                if (!hashSetOfIds.contains(productNode.elementId()))
                {
                    Object productVertex = graph.insertVertex(parent, null, productID, x, y, 80, 30, "shape=ellipse;fillColor=#d617f3");
                    idToObjectMap.put(productNode.elementId(), productVertex);

                    stringToModelMap.put(productID, new Product(productNode.get("productName").asString(), productNode.get("category").asString(), productNode.get("description").asString(), productNode.get("unitOfMeasure").asString(), productNode.get("image").asString(), productNode.get("costPrice").asString(), productNode.get("sellingPrice").asString(), productNode.get("stockQuantity").asString(), productNode.get("minimumStockLevel").asString(), productNode.get("dateAdded").asString(), productNode.get("lastUpdated").asString(), productNode.get("productID").asString()));
                    updatePosition();
                }

                if (!hashSetOfIds.contains(purchaseNode.elementId()))
                {
                    Object purchaseVertex = graph.insertVertex(parent, null, purchaseID, x, y, 80, 30, "shape=ellipse;fillColor=#ff3a72");
                    idToObjectMap.put(purchaseNode.elementId(), purchaseVertex);
                    stringToModelMap.put(purchaseID, new Purchase(purchaseNode.get("purchaseId").asString(), purchaseNode.get("purchaseDate").asString(), purchaseNode.get("deliveryDate").asString(), purchaseNode.get("quantity").asString(), supplierNode.get("supplierID").asString(), productNode.get("productID").asString(), userNode.get("userId").asString()));
                    updatePosition();
                }

                if (!hashSetOfIds.contains(supplierNode.elementId()))
                {
                    Object supplierVertex = graph.insertVertex(parent, null, supplierID, x, y, 80, 30, "shape=ellipse;fillColor=#10fbff");
                    idToObjectMap.put(supplierNode.elementId(), supplierVertex);
                    stringToModelMap.put(supplierID, new Supplier(supplierNode.get("supplierID").asString(), supplierNode.get("supplierName").asString(), supplierNode.get("contactInformation").asString()));
                    updatePosition();
                }

                if (!hashSetOfIds.contains(transactionNode.elementId()))
                {
                    Object transactionVertex = graph.insertVertex(parent, null, transactionID, x, y, 80, 30, "shape=ellipse;fillColor=#0cbb64");
                    idToObjectMap.put(transactionNode.elementId(), transactionVertex);
                    stringToModelMap.put(transactionID, new Transaction(transactionNode.get("transactionId").asString(), transactionNode.get("date").asString(), transactionNode.get("totalCost").asString(), customerNode.get("customerID").asString(), productNode.get("productID").asString(), transactionNode.get("discountsApplied").asString()));
                    updatePosition();
                }

                if (!hashSetOfIds.contains(userNode.elementId()))
                {
                    Object userVertex = graph.insertVertex(parent, null, userID, x, y, 80, 30, "shape=ellipse;fillColor=#2a7736");
                    idToObjectMap.put(userNode.elementId(), userVertex);
                    stringToModelMap.put(userID, new User(userNode.get("username").asString(), userNode.get("role").asString(), userNode.get("password").asString(), userNode.get("userId").asString()));
                    updatePosition();
                }

                // To check if the node is already plotted
                hashSetOfIds.add(customerNode.elementId());
                hashSetOfIds.add(productNode.elementId());
                hashSetOfIds.add(purchaseNode.elementId());
                hashSetOfIds.add(supplierNode.elementId());
                hashSetOfIds.add(transactionNode.elementId());
                hashSetOfIds.add(userNode.elementId());


            }

            for (Record record : records)
            {

                Relationship MADE_PURCHASE = record.get("e1").asRelationship();
                Relationship OF_PRODUCT = record.get("e2").asRelationship();
                Relationship THE_PRODUCT = record.get("e3").asRelationship();
                Relationship FROM_SUPPLIER = record.get("e4").asRelationship();
                Relationship MADE_BY_USER = record.get("e5").asRelationship();

                // Add edges to connect the vertices
                graph.insertEdge(parent, null, FROM_SUPPLIER.type(), idToObjectMap.get(FROM_SUPPLIER.startNodeElementId()), idToObjectMap.get(FROM_SUPPLIER.endNodeElementId()));
                graph.insertEdge(parent, null, MADE_BY_USER.type(), idToObjectMap.get(MADE_BY_USER.startNodeElementId()), idToObjectMap.get(MADE_BY_USER.endNodeElementId()));
                graph.insertEdge(parent, null, THE_PRODUCT.type(), idToObjectMap.get(THE_PRODUCT.startNodeElementId()), idToObjectMap.get(THE_PRODUCT.endNodeElementId()));
                graph.insertEdge(parent, null, OF_PRODUCT.type(), idToObjectMap.get(OF_PRODUCT.startNodeElementId()), idToObjectMap.get(OF_PRODUCT.endNodeElementId()));
                graph.insertEdge(parent, null, MADE_PURCHASE.type(), idToObjectMap.get(MADE_PURCHASE.startNodeElementId()), idToObjectMap.get(MADE_PURCHASE.endNodeElementId()));



            }


        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell != null && graph.getModel().isVertex(cell)) {
                    String nodeId = (String) graph.getModel().getValue(cell);
                    displayAttributesFor(nodeId);
                }
            }
        });

        BetterScrollPane scrollPane = new BetterScrollPane(attributesTable);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        graphComponent.remove(graphComponent.getHorizontalScrollBar());
        graphComponent.remove(graphComponent.getVerticalScrollBar());

        JPanel attributesPanel = new JPanel(new BorderLayout());
        attributesPanel.add(scrollPane, BorderLayout.CENTER);

        BetterScrollPane betterScrollPane = new BetterScrollPane(graphComponent);


        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, betterScrollPane, attributesPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.7);

        add(splitPane, BorderLayout.CENTER);





    }

    private void displayAttributesFor(String nodeId)
    {
        // Parse string from nodeId
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (true)
        {
            char ch = nodeId.charAt(index);
            if (!Character.isLetter(ch)) break;
            if (index == 0)
            {
                sb.append(Character.toUpperCase(ch));
            }
            else
            {
                sb.append(ch);
            }
            index++;
        }




        switch (sb + "")
        {

            case "Customer":

                var customer = (Customer) stringToModelMap.get(nodeId);
                displayAttributes(new Object[][] { {"customerID", customer.getCustomerID()}, { "customerName", customer.getCustomerName()}, { "contactInformation", customer.getContactInformation() } });
                break;
            case "Product":
                var product = (Product) stringToModelMap.get(nodeId);
                displayAttributes(new Object[][] {
                        {"productName", product.getProductName()},
                        {"category", product.getCategory()},
                        {"sellingPrice", product.getSellingPrice()},
                        {"image", product.getImage()},
                        {"stockQuantity", product.getStockQuantity()},
                        {"description", product.getDescription()},
                        {"costPrice", product.getCostPrice()},
                        {"minimumStockLevel", product.getMinimumStockLevel()},
                        {"unitOfMeasure", product.getUnitOfMeasure()},
                        {"dateAdded", product.getDateAdded()},
                        {"lastUpdated", product.getLastUpdated()},
                        {"productID", product.getProductID()}
                });
                break;
            case "Purchase":
                var purchase = (Purchase) stringToModelMap.get(nodeId);
                displayAttributes(new Object[][] {
                        {"purchaseID", purchase.getPurchaseID()},
                        {"purchaseDate", purchase.getPurchaseDate()},
                        {"deliveryDate", purchase.getDeliveryDate()},
                        {"quantity", purchase.getQuantity()},
                        {"supplierID", purchase.getSupplierID()},
                        {"productID", purchase.getProductID()},
                        {"userID", purchase.getUserID()}
                });

                break;
            case "Supplier":
                var supplier = (Supplier) stringToModelMap.get(nodeId);
                displayAttributes(new Object[][] {
                        {"supplierID", supplier.getSupplierID()},
                        {"supplierName", supplier.getSupplierName()},
                        {"contactInformation", supplier.getContactInformation()}
                });
                break;
            case "Transaction":
                var transaction = (Transaction) stringToModelMap.get(nodeId);
                System.out.println(transaction);
                displayAttributes(new Object[][] {
                        {"transactionID", transaction.getTransactionID()},
                        {"date", transaction.getDate()},
                        {"totalCost", transaction.getTotalCost()},
                        {"customerID", transaction.getCustomerID()},
                        {"productID", transaction.getProductID()},
                        {"discountsApplied", transaction.getDiscountsApplied()}
                });
                break;
            case "User":
                var user = (User) stringToModelMap.get(nodeId);
                displayAttributes(new Object[][] {
                        {"username", user.getUsername()},
                        {"role", user.getRole()},
                        {"password", user.getPassword()},
                        {"userId", user.getUserId()}
                });
                break;
            default:
                System.out.println("ERROR: [GraphVisualization]");

        }





    }


    private void displayAttributes(Object[][] data) {
        DefaultTableModel model = (DefaultTableModel) attributesTable.getModel();
        model.setRowCount(0);

        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    private void updatePosition() {
        x += 300;  // Adjust x position for the next vertex
        if (x > 600) {
            x = 20;
            y += 300;  // Adjust y position for the next row of vertices
        }
    }


}
