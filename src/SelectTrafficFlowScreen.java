import javax.swing.*;
import java.awt.*;

public class SelectTrafficFlowScreen extends JFrame {

    public SelectTrafficFlowScreen() {
        setTitle("Είδη Κίνησης");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Επέλεξε Είδος Κίνησης:", SwingConstants.CENTER);
        add(label);

        JButton normalButton = new JButton("Κανονική");
        JButton increasedButton = new JButton("Αυξημένη");
        JButton congestionButton = new JButton("Συμφόρηση");

        add(normalButton);
        add(increasedButton);
        add(congestionButton);

        normalButton.addActionListener(e -> showRoadsForFlow("Κανονική"));
        increasedButton.addActionListener(e -> showRoadsForFlow("Αυξημένη"));
        congestionButton.addActionListener(e -> showRoadsForFlow("Συμφόρηση"));

        setVisible(true);
    }

   private void showRoadsForFlow(String flowType) {
    java.util.List<String> roads = DataBase.getRoadsByTrafficFlow(flowType);

    JFrame resultFrame = new JFrame("Κίνηση με βάση το είδος: " + flowType);
    resultFrame.setSize(300, 200);
    resultFrame.setLocationRelativeTo(null);
    resultFrame.setLayout(new BorderLayout());

    JTextArea area = new JTextArea();
    area.setEditable(false);

    if (roads.isEmpty()) {
        area.setText("Δεν βρέθηκαν δρόμοι με " + flowType + " κίνηση.");
    } else {
        area.setText("Δρόμοι με κίνηση: " + flowType + "\n");
        for (String road : roads) {
            area.append("- " + road + "\n");
        }
    }

    System.out.println("Επιλέχθηκε είδος: " + flowType);
    resultFrame.add(new JScrollPane(area), BorderLayout.CENTER);
    resultFrame.setVisible(true);
}

}
