import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

class EmergencySelectionScreen extends JFrame {
    public EmergencySelectionScreen() {
        setTitle("Επιλογή Κατηγορίας Εφημερευόντων");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Επιλέξτε Κατηγορία:");
        JButton hospitalBtn = new JButton("Νοσοκομεία");    
        JButton pharmacyBtn = new JButton("Φαρμακεία");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        DefaultListModel<EmergencyService> model = new DefaultListModel<>();
        JList<EmergencyService> serviceList = new JList<>(model);
        JScrollPane scroll = new JScrollPane(serviceList);

        JPanel topPanel = new JPanel();
        topPanel.add(label);
        topPanel.add(hospitalBtn);
        topPanel.add(pharmacyBtn);

        // Ενέργεια όταν επιλέγει ο χρήστης κατηγορία
        ActionListener categoryListener = e -> {
            String type = e.getActionCommand().equals("Νοσοκομεία") ? "Hospital" : "Pharmacy";
            List<EmergencyService> services = DataBase.getEmergencyServices(type);
            model.clear();
            if (services.isEmpty()) {
                JOptionPane.showMessageDialog(this, "❌ Δεν βρέθηκαν εφημερεύοντα για την κατηγορία: " + type);
            } else {
                for (EmergencyService s : services) {
                    model.addElement(s);
                }
            }
        };

        hospitalBtn.addActionListener(categoryListener);
        pharmacyBtn.addActionListener(categoryListener);

        // Διπλό κλικ σε λίστα => εμφάνιση λεπτομερειών
        serviceList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    EmergencyService selected = serviceList.getSelectedValue();
                    if (selected != null) {
                        new EmergencyDetailsScreen(selected).setVisible(true);
                    }
                }
            }
        });

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }
}
