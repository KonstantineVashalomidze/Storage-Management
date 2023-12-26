package org.example.views.view_components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BetterTable extends JTable {

    public BetterTable(Object[][] data, String[] columnNames) {
        super(data, columnNames);
        // Create a DefaultTableModel and set data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        setModel(model);

        // Set table properties for better appearance
        setRowHeight(30); // Set row height
        getTableHeader().setFont(new Font("Sylfaen", Font.BOLD, 12)); // Set header font
        setFont(new Font("Sylfaen", Font.PLAIN, 14)); // Set cell font

        // Set custom cell renderer for alternating row colors
        setDefaultRenderer(Object.class, new AlternateRowColorRenderer());
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

}
