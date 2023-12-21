package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BetterTableExample extends JFrame {
    private JTable table;

    public BetterTableExample() {
        setTitle("Better Looking Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        // Create sample data for the table
        String[] columnNames = {"Name", "Age", "Country"};
        Object[][] data = {
                {"Alice", 25, "USA"},
                {"Bob", 30, "Canada"},
                {"Charlie", 22, "UK"},
                {"Diana", 28, "Australia"}
        };

        // Create a DefaultTableModel and set data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create the table using the model
        table = new JTable(model);

        // Set table properties for better appearance
        table.setRowHeight(30); // Set row height
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14)); // Set header font
        table.setFont(new Font("Arial", Font.PLAIN, 12)); // Set cell font

        // Set custom cell renderer for alternating row colors
        table.setDefaultRenderer(Object.class, new AlternateRowColorRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Custom cell renderer to set alternating row colors
    static class AlternateRowColorRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (row % 2 == 0) {
                cell.setBackground(Color.LIGHT_GRAY);
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BetterTableExample::new);
    }
}
