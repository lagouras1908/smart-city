import java.util.List;
import java.util.Scanner;

public class TrafficByRoadScreen {
    public void displayTrafficInSelectedRoad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Επέλεξε Δρόμο ===");

        List<Traffic> allTraffic = DataBase.getAllTraffic();
        int index = 1;
        for (Traffic t : allTraffic) {
            System.out.println(index + ". " + t.getRoadName());
            index++;
        }

        System.out.print("Επιλογή (αριθμός): ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice >= 1 && choice <= allTraffic.size()) {
            Traffic selected = allTraffic.get(choice - 1);
            System.out.println("=== Κίνηση στον δρόμο: " + selected.getRoadName() + " ===");
            System.out.println("Κατάσταση: " + selected.getFlowType());
        } else {
            System.out.println("Μη έγκυρη επιλογή.");
        }
    }
}
