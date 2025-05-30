import javax.swing.*;
import java.awt.Dimension;

public class ParkingLocationScreen extends JFrame {
    private String selectedLocation;

    public ParkingLocationScreen() {
        setTitle("Επιλογή περιοχής πάρκινγκ");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] locations = DataBase.locationSearch();
        JComboBox<String> locationBox = new JComboBox<>(locations);
        locationBox.setMaximumSize(new Dimension(200, 25));
        JCheckBox disabledCheck = new JCheckBox("ΑμεΑ Θέσεις");
        JButton nextButton = new JButton("Αναζήτηση");

        nextButton.addActionListener(e -> {
            selectedLocation = (String) locationBox.getSelectedItem();
            if (disabledCheck.isSelected()) {
                new ParkingSpotScreen(DataBase.searchParkingSpotsDisabled(selectedLocation)).setVisible(true);
            } else {
                ParkingSpot[] spots = DataBase.searchParkingSpots(selectedLocation);
                if (spots.length > 0) {
                    new ParkingSpotScreen(spots).setVisible(true);
                } else {
                    new FailScreen().setVisible(true);
                }
            }
            dispose();
        });

        add(locationBox);
        add(disabledCheck);
        add(nextButton);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public void displayLocations() {
        setVisible(true);
    }
}
