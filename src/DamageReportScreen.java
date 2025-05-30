import javax.swing.*;
import java.awt.*;

public class DamageReportScreen extends JFrame {
    public DamageReportScreen() {
        setTitle("Damage Report");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel locLabel = new JLabel("Location:");
        JTextField locField = new JTextField(20);
        JLabel descLabel = new JLabel("Description:");
        JTextArea descArea = new JTextArea(4, 20);

        JButton submitBtn = new JButton("Submit Report");

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(locLabel);
        panel.add(locField);
        panel.add(descLabel);
        panel.add(new JScrollPane(descArea));
        panel.add(submitBtn);

        submitBtn.addActionListener(e -> {
            String location = locField.getText().trim();
            String description = descArea.getText().trim();
            DamageReport report = new DamageReport(location, description);
            int result = DataBase.registerReport(report);
            if (result != -1) {
                new SuccessScreen(result).setVisible(true);
            } else {
                new FailScreen().setVisible(true);
            }
            dispose();
        });

        add(panel);
    }
}
