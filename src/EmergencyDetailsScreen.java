import javax.swing.*;
import java.awt.*;

class EmergencyDetailsScreen extends JFrame {
    public EmergencyDetailsScreen(EmergencyService service) {
        setTitle("Πληροφορίες Δομής Υγείας");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel(" Όνομα: " + service.getName()));
        panel.add(new JLabel(" Τοποθεσία: " + service.getLocation()));
        panel.add(new JLabel(" Τύπος: " + service.getType()));
        panel.add(new JLabel(" Ώρες Εφημερίας: 08:00 - 08:00 επόμενης ημέρας")); // στατική ώρα, προαιρετικά να βάλεις δυναμικά

        add(panel);
    }
}
