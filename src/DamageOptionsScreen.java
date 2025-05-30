
import javax.swing.*;
import java.awt.*;

public class DamageOptionsScreen extends JFrame {
    public DamageOptionsScreen() {
        setTitle("Damage Report Options");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addReportButton = new JButton("Submit New Report");
        JButton viewReportsButton = new JButton("View Submitted Reports");

        addReportButton.setFont(new Font("Arial", Font.PLAIN, 14));
        viewReportsButton.setFont(new Font("Arial", Font.PLAIN, 14));

        addReportButton.addActionListener(e -> {
            new DamageReportScreen().setVisible(true);
            //dispose();
        });

        viewReportsButton.addActionListener(e -> {
            new ShowReportsScreen().setVisible(true);
            dispose();
        });

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(addReportButton);
        panel.add(viewReportsButton);

        add(panel);
    }
}
