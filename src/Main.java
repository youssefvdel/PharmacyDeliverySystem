import ui.LoginFrame;
import util.DatabaseConnection;
import util.DatabaseInitializer;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        DatabaseInitializer.initialize();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { DatabaseConnection.shutdown(); } catch (Exception e) { }
        }));

        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
