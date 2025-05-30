import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SelectRoadScreen extends JFrame {

    public void displayTrafficInSelectedRoad() {
        setTitle("Κίνηση με Βάση τον Δρόμο");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Βήμα 3.β.3: Ανάκτηση ονομάτων δρόμων
        List<Traffic> trafficList = DataBase.getAllTraffic();

        String[] roadNames = trafficList.stream()
                .map(Traffic::getRoadName)
                .distinct()
                .toArray(String[]::new);

        JComboBox<String> roadComboBox = new JComboBox<>(roadNames);
        JButton viewTrafficButton = new JButton("Δες την Κίνηση");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Επέλεξε Δρόμο:"), BorderLayout.WEST);
        topPanel.add(roadComboBox, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(viewTrafficButton, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        // Βήμα 3.β.5 - 3.β.8: Εμφάνιση κίνησης με βάση τον επιλεγμένο δρόμο
        viewTrafficButton.addActionListener(e -> {
            String selectedRoad = (String) roadComboBox.getSelectedItem();
            if (selectedRoad != null && !selectedRoad.isEmpty()) {
                for (Traffic t : trafficList) {
                    if (t.getRoadName().equalsIgnoreCase(selectedRoad)) {
                        resultArea.setText("Κίνηση στον δρόμο \"" + selectedRoad + "\": " + t.getFlowType());
                        break;
                    }
                }
            } else {
                resultArea.setText("Παρακαλώ επίλεξε δρόμο.");
            }
        });

        setVisible(true);
    }
}
