import javax.swing.*;

public class RouteDetailsScreen extends JFrame {

    public RouteDetailsScreen(TrainRoute route) {
        setTitle("Λεπτομέρειες Δρομολογίου");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("Γραμμή: ").append(route.getLineNumber()).append("\n");
        sb.append("Από: ").append(route.getStart()).append("\n");
        sb.append("Προς: ").append(route.getEnd()).append("\n");
        sb.append("Ώρα Αναχώρησης: ").append(route.getDepartureTime()).append("\n");
        sb.append("Διάρκεια: ").append(route.getDuration()).append("\n\n");
        sb.append("Στάσεις:\n");

        for (Station s : route.getStops()) {
            sb.append("- ").append(s.getName()).append(" στις ").append(s.getTime()).append("\n");
        }

        area.setText(sb.toString());

        add(new JScrollPane(area));
    }

 {
    
} 

}