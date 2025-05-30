import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.util.List;

class EmergencyServiceFrame extends JFrame {
    public EmergencyServiceFrame() {
        setTitle("Εφημερεύοντα Νοσοκομεία & Φαρμακεία");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JTextField typeField = new JTextField(10);
        JButton searchButton = new JButton("Αναζήτηση");
        JTextArea result = new JTextArea();
        result.setEditable(false);

        JPanel top = new JPanel();
        top.add(new JLabel("Τύπος (Hospital ή Pharmacy):"));
        top.add(typeField);
        top.add(searchButton);

        searchButton.addActionListener(e -> {
            List<EmergencyService> services = DataBase.getEmergencyServices(typeField.getText());
            StringBuilder sb = new StringBuilder();
            if (services.isEmpty()) {
                sb.append("Δεν βρέθηκαν αποτελέσματα.");
            } else {
                for (EmergencyService s : services) {
                    sb.append(s.toString()).append("\n");
                }
            }
            result.setText(sb.toString());
        });

        panel.add(top, BorderLayout.NORTH);
        panel.add(new JScrollPane(result), BorderLayout.CENTER);
        add(panel);
    }
}
