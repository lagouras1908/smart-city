import javax.swing.*;
import java.awt.*;

public class FailScreen extends JFrame {
    public FailScreen() {
        setTitle("Error Screen");
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Error: An error occured!", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
