import javax.swing.*;
import java.util.List;

public class TrafficInAllRoadsScreen extends JFrame {
    public void displayAllRoadsTraffic() {
        setTitle("Κίνηση σε Όλους τους Δρόμους");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        List<Traffic> trafficList = DataBase.getAllTraffic();
        for (Traffic t : trafficList) {
            area.append(t.toString() + "\n");
        }

        JScrollPane scroll = new JScrollPane(area);
        add(scroll);

        setVisible(true);
    }
}
