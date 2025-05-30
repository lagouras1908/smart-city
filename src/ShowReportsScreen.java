import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowReportsScreen extends JFrame {
    public ShowReportsScreen() {
        setTitle("Submitted Reports");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        List<DamageReport> reports = DataBase.getAllReports();
        for (DamageReport r : reports) {
            area.append(r.toString() + "\n");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
    }
}
