import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LibraryManagementPanel extends JPanel {
    private JTextField titleField, authorField;

    public LibraryManagementPanel() {
        setLayout(new GridLayout(3, 2));

        titleField = new JTextField();
        authorField = new JTextField();

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(this::addBook);

        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Author:"));
        add(authorField);
        add(addButton);
    }

    private void addBook(ActionEvent evt) {
        String title = titleField.getText();
        String author = authorField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:school_management.db");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO books (title, author, available) VALUES (?, ?, 1)")) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
