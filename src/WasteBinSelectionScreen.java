import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WasteBinSelectionScreen extends JFrame {

    public WasteBinSelectionScreen() {
        setTitle("Αναζήτηση Κάδων");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Παίρνουμε όλους τους κάδους από τη βάση
        List<WasteBin> allBins = DataBase.getAllWasteBins();

        // Βρίσκουμε μοναδικές κατηγορίες και περιοχές
        Set<String> categories = allBins.stream()
                .map(WasteBin::getCategory)
                .collect(Collectors.toSet());

        Set<String> areas = allBins.stream()
                .map(WasteBin::getArea)
                .collect(Collectors.toSet());

        JComboBox<String> categoryComboBox = new JComboBox<>(categories.toArray(new String[0]));
        JComboBox<String> areaComboBox = new JComboBox<>(areas.toArray(new String[0]));

        JButton searchButton = new JButton("Αναζήτηση");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Κατηγορία:"));
        inputPanel.add(categoryComboBox);
        inputPanel.add(new JLabel("Περιοχή:"));
        inputPanel.add(areaComboBox);
        inputPanel.add(searchButton);

        searchButton.addActionListener(e -> {
            String selectedCategory = (String) categoryComboBox.getSelectedItem();
            String selectedArea = (String) areaComboBox.getSelectedItem();

            if (selectedCategory == null || selectedArea == null) {
                resultArea.setText("Επιλέξτε κατηγορία και περιοχή.");
                return;
            }

            List<WasteBin> results = DataBase.getBins(selectedCategory, selectedArea);

            StringBuilder sb = new StringBuilder();
            if (results.isEmpty()) {
                sb.append("Δεν βρέθηκαν κάδοι για τα κριτήρια που δώσατε.");
            } else {
                for (WasteBin b : results) {
                    sb.append("• Κατηγορία: ").append(b.getCategory())
                      .append(" | Περιοχή: ").append(b.getArea())
                      .append(" | Πληροφορίες: ").append(b.getInfo())
                      .append("\n");
                }
            }

            resultArea.setText(sb.toString());
        });

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
