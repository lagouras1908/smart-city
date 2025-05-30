import javax.swing.*;

public class ParkingSuccessScreen extends JFrame {
    public ParkingSuccessScreen(String message) {
        setTitle("Επιτυχία");
        setSize(300, 150);
        add(new JLabel(message));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void displaySuccessMessage() {
        setVisible(true);
    }
}


