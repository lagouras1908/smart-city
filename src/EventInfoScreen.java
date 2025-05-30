import javax.swing.*;

public class EventInfoScreen extends JFrame {

    public EventInfoScreen() {
        setTitle("Λεπτομέρειες Εκδήλωσης");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void displayEventInfo(String title, String link) {
        JLabel titleLabel = new JLabel("Εκδήλωση: " + title);
        JLabel linkLabel = new JLabel("Πληροφορίες & Κράτηση: " + link);

        add(titleLabel);
        add(linkLabel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);
    }
}
