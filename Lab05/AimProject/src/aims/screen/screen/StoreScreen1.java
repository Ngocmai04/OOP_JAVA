package screen;
import javax.swing.*;
import java.awt.*;

public class StoreScreen1 extends JFrame {
    private Store store;

    public Store getStore() {
        return store;
    }

    public StoreScreen1(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);
        // Add other components as needed

        setTitle("Store Screen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Welcome to the Store");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        header.add(title);

        return header;
    }

        public static void main(String[] args) {
            Store store = new Store(); // Replace with actual Store object initialization
            new StoreScreen1(store);
        }
    }
    
    // Dummy Store class initialization to avoid compilation error
    class Store {
        public Store() {
            // Initialize store details
        }
}
