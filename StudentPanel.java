import javax.swing.*;
import java.awt.*;
public class StudentPanel extends JFrame {
    public StudentPanel() {
        setTitle("Student Library Access");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new LibraryManagementPanel());
    }
}
