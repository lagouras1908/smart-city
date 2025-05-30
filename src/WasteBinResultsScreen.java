import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.List;
import java.awt.BorderLayout;

public class WasteBinResultsScreen extends JFrame {

    public WasteBinResultsScreen(String category, String area, String info) {
        setTitle("Αποτελέσματα Κάδων");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        List<WasteBin> bins = DataBase.getBins(category, area);
        if (bins.isEmpty()) {
            resultArea.setText("Δεν βρέθηκαν κάδοι με αυτά τα κριτήρια.");
        } else {
            StringBuilder sb = new StringBuilder("Βρέθηκαν κάδοι:\n\n");
            for (WasteBin bin : bins) {
                sb.append("• ").append(bin.toString()).append("\n");
            }
            resultArea.setText(sb.toString());
        }

        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
}
