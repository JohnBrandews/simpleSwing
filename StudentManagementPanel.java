import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class StudentManagementPanel extends JPanel {
    private JTextField nameField, ageField, deptField;

    public StudentManagementPanel() {
        setLayout(new GridLayout(4, 2));

        nameField = new JTextField();
        ageField = new JTextField();
        deptField = new JTextField();

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(this::addStudent);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Department:"));
        add(deptField);
        add(addButton);
    }

    private void addStudent(ActionEvent evt) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String department = deptField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:school_management.db");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (name, age, department) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, department);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
