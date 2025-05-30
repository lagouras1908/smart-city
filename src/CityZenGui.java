import javax.swing.*;

public class CityZenGui {
    private String appTitle = "CityZen Smart City System";

    public void runApp() {
        SwingUtilities.invokeLater(() -> {
            initGui();
        });
    }

    public void initGui() {
        showMainMenu();
    }

    public void showMainMenu() {
        String[] menuOptions = {
            "Κίνηση στους δρόμους", "Ενημέρωση & Επικαιρότητα", "Κράτηση θέσης στάθμευσης",
            "Αξιοθέατα", "Δρομολόγια τρένου", "Πολιτιστικές εκδηλώσεις",
            "Εφημερεύοντα", "Δήλωση Βλαβών", "Αγγελίες",
            "Εύρεση κάδου απορριμμάτων"
        };

        new MainMenuScreen(menuOptions, "Κεντρικό Μενού").display();
    }

    public static void exitApp() {
        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Είστε σίγουροι ότι θέλετε να τερματίσετε την εφαρμογή;",
            "Έξοδος",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CityZenGui().runApp();
    }
}
