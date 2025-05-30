import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrainResultsScreen extends JFrame {

    public TrainResultsScreen(String from, String to) {
        setTitle("Διαθέσιμα Δρομολόγια");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List<TrainRoute> routes = DataBase.getRoutes(from, to);

        if (routes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Δεν βρέθηκαν δρομολόγια.", "Αποτυχία", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            return;
        }

        DefaultListModel<TrainRoute> model = new DefaultListModel<>();
        for (TrainRoute r : routes) {
            model.addElement(r);
        }

        JList<TrainRoute> routeList = new JList<>(model);
        routeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        routeList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
            JLabel label = new JLabel("Γραμμή " + value.getLineNumber() + ": " + value.getStart() + " ➝ " + value.getEnd());
            if (isSelected) {
                label.setOpaque(true);
                label.setBackground(Color.LIGHT_GRAY);
            }
            return label;
        });

        JButton viewDetails = new JButton("Προβολή Πληροφοριών");

        viewDetails.addActionListener(e -> {
            TrainRoute selected = routeList.getSelectedValue();
            if (selected == null) {
                JOptionPane.showMessageDialog(this, "Παρακαλώ επιλέξτε δρομολόγιο", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
                return;
            }

            new RouteDetailsScreen(selected).setVisible(true);
        });

        add(new JScrollPane(routeList), BorderLayout.CENTER);
        add(viewDetails, BorderLayout.SOUTH);
    }

 {
    

}

}