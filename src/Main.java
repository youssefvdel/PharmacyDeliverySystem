import ui.AdminPanel;
import util.DatabaseConnection;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { DatabaseConnection.shutdown(); } catch (Exception e) { }
        }));

        SwingUtilities.invokeLater(() -> new AdminPanel().setVisible(true));
    }
}
