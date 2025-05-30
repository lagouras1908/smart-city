import javax.swing.*;
import java.awt.*;

public class SuccessScreen extends JFrame {
    public SuccessScreen(int reportId) {
        setTitle("Report Submitted");
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Success! Your report ID is: " + reportId, JLabel.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
