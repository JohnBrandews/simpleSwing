import javax.swing.*;
import java.awt.*;
public class AdminPanel extends JFrame {
    public AdminPanel() {
        setTitle("Admin Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Student Management", new StudentManagementPanel());
        tabbedPane.addTab("Library Management", new LibraryManagementPanel());

        add(tabbedPane);
    }
}
