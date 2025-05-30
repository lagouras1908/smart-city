import javax.swing.*;
import java.awt.*;

public class TrainSearchScreen extends JFrame {

    public TrainSearchScreen() {
        setTitle("Αναζήτηση Δρομολογίων Τρένου");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField fromField = new JTextField("Κέντρο");
        JTextField toField = new JTextField("Άγιος Βασίλης");
        JButton searchBtn = new JButton("Αναζήτηση");

        panel.add(new JLabel("Αφετηρία:"));
        panel.add(fromField);
        panel.add(new JLabel("Προορισμός:"));
        panel.add(toField);
        panel.add(new JLabel());
        panel.add(searchBtn);

        add(panel);

        searchBtn.addActionListener(e -> {
            String from = fromField.getText().trim();
            String to = toField.getText().trim();

            if (from.isEmpty() || to.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Συμπληρώστε όλα τα υποχρεωτικά πεδία", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new TrainResultsScreen(from, to).setVisible(true);
        });

        setVisible(true);
    }
}