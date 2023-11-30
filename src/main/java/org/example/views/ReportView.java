package org.example.views;

import javax.swing.*;
import java.awt.*;

public class ReportView extends JFrame {
    private JPanel headerPanel;
    private JPanel contentPanel;

    public ReportView() {
        setTitle("Report View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600); // Default size, can be adjusted

        createHeaderPanel();
        createContentPanel();

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void createHeaderPanel() {
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE); // Adjust colors as needed
        headerPanel.setPreferredSize(new Dimension(getWidth(), 50)); // Height can be adjusted

        JLabel titleLabel = new JLabel("Report View");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        headerPanel.add(titleLabel);
    }

    private void createContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        JTextArea reportTextArea = new JTextArea();
        reportTextArea.setEditable(false); // To prevent user edits
        JScrollPane scrollPane = new JScrollPane(reportTextArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        contentPanel.add(scrollPane, BorderLayout.CENTER);
    }


}
