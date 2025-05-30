import javax.swing.*;

public class ParkingSpotScreen extends JFrame {
    private ParkingSpot[] spots;

    public ParkingSpotScreen(ParkingSpot[] spots) {
        this.spots = spots;

        setTitle("Επιλογή Θέσης Στάθμευσης");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (ParkingSpot p : spots)
            model.addElement(p.getId() + (p.isDisabled() ? " (ΑμεΑ)" : ""));

        JList<String> list = new JList<>(model);
        JButton select = new JButton("Κράτηση");

        select.addActionListener(e -> {
            int index = list.getSelectedIndex();
            if (index >= 0) {
                ParkingSpot selected = spots[index];
                if (selected.checkSelection()) {
                    Booking booking = new Booking(selected);
                    String link = booking.directToPayment();

                    JOptionPane.showMessageDialog(this, "Πληρώστε εδώ: " + link);
                    if (booking.askForPaymentStatus()) {
                        booking.storeInDatabase();
                        new ParkingSuccessScreen("Κράτηση επιτυχής. Κωδικός: " + booking.getId()).setVisible(true);
                    } else {
                        new FailScreen().setVisible(true);
                    }
                    dispose();
                }
            }
        });

        add(new JScrollPane(list));
        add(select);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
}
