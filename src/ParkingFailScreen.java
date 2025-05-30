import javax.swing.*;

public class ParkingFailScreen extends JFrame {
    public ParkingFailScreen(String message) {
        setTitle("Αποτυχία");
        setSize(300, 150);
        add(new JLabel(message));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void displayFailMessage() {
        setVisible(true);
    }
}