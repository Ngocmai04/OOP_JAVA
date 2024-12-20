// package screen;

// import java.awt.BorderLayout;
// import java.awt.Color;
// import java.awt.Container;
// import java.awt.Dimension;
// import java.awt.FlowLayout;
// import java.awt.Font;
// import java.awt.GridLayout;
// import java.awt.TextField;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.ArrayList;
// import java.util.List;

// import javax.swing.Box;
// import javax.swing.BoxLayout;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JMenuItem;
// import javax.swing.JPanel;

// import Lab05.AimProject.src.aims.media.Book;
// import Lab05.AimProject.src.aims.media.CompactDisc;
// import Lab05.AimProject.src.aims.media.DigitalVdDisc;
// import Lab05.AimProject.src.aims.media.Media;
// import Lab05.AimProject.src.aims.media.Track;

// public class StoreScreen extends JFrame {

//     private StoreScreen store;
//     private Container cp;
//     private cart cart;

//     public StoreScreen getStore() {
//         return store;
//     }
//     public cart getCart() {
//         return cart;
//     }

//     public Container getCp() {
//         return cp;
//     }
//     JPanel createNorth() {
//         JPanel north = new JPanel();
//         north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
//         north.add(createMenuBar());
//         north.add(createHeader());
//         return north;
//     }

//     JMenuBar createMenuBar() {
//         JMenu menu = new JMenu("Options");
//         JMenu smUpdateStore = new JMenu("Update Store");
//         JMenuItem addBook = new JMenuItem("Add Book");
//         smUpdateStore.add(addBook);
//         addBook.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 AddBookStoreScreen popUp = new AddBookStoreScreen(store);
//             }
//         });


//         JMenuItem addCD = new JMenuItem("Add CD");
//         smUpdateStore.add(addCD);
//         addCD.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 AddCDStoreScreen popUp = new AddCDStoreScreen(store);
//             }
//         });

//         JMenuItem addDVD = new JMenuItem("Add DVD");
//         smUpdateStore.add(addDVD);
//         addDVD.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 AddDVDStoreScreen popUp = new AddDVDStoreScreen(store);
//             }
//         });
//         menu.add(smUpdateStore);
//         menu.add(new JMenuItem("View store"));
//         menu.add(new JMenuItem("View cart"));

//         JMenuBar menuBar = new JMenuBar();
//         menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
//         menuBar.add(menu);
//         return menuBar;
//     }

//     JPanel createHeader() {
//         JPanel header = new JPanel();
//         header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

//         JLabel title = new JLabel("AIMS");
//         title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
//         title.setForeground(Color.CYAN);

//         JButton cart1 = new JButton("View cart");
//         cart1.setPreferredSize(new Dimension(100, 50));
//         cart1.setMaximumSize(new Dimension(100, 50));
//         cart1.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 new CartScreen(cart).setVisible(true);
//             }
//         });
//         header.add(Box.createRigidArea(new Dimension(10, 10)));
//         header.add(title);
//         header.add(Box.createHorizontalGlue());
//         header.add(cart1);
//         header.add(Box.createRigidArea(new Dimension(10, 10)));
//         return header;
//     }

//     JPanel createCenter() {
//         JPanel center = new JPanel();
//         center.setLayout(new GridLayout(3, 3, 2, 2));
//         List<Media> mediaStore = store.getItemsInStore();
//         for (Media media : mediaStore) {
//             MediaStore cell = new MediaStore(media, cart);
//             center.add(cell);
//         }
//         return center;
//     }

//     public StoreScreen(Store store, Cart myCart) {
//         this.store = store;
//         this.cart = myCart;
//         cp = getContentPane();
//         cp.setLayout(new BorderLayout());
//         cp.add(createNorth(), BorderLayout.NORTH);
//         cp.add(createCenter(), BorderLayout.CENTER);
//         setVisible(true);
//         setTitle("Store");
//         setSize(1024, 768);
//     }

//     private class AddDVDStoreScreen extends JFrame {
//         public AddDVDStoreScreen(Store store) {
//             this.setLayout(new GridLayout(4, 2, 5, 5));
//             this.add(new JLabel("Enter title: "));
//             TextField title = new TextField(10);
//             this.add(title);
//             this.add(new JLabel("Enter category: "));
//             TextField category = new TextField(10);
//             this.add(category);
//             this.add(new JLabel("Enter cost: "));
//             TextField cost = new TextField(10);
//             this.add(cost);

//             this.setTitle("Add DVD");
//             this.setSize(300, 100);
//             JButton turnInBtn = new JButton("Add");
//             this.add(turnInBtn);
//             turnInBtn.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     DigitalVdDisc dvd = new DigitalVdDisc( title.getText(), category.getText(), Float.parseFloat(cost.getText()));
//                     store.addMedia(dvd);
//                     cp.add(createCenter(), BorderLayout.CENTER);
//                     cp.revalidate();
//                     title.setText("");
//                     category.setText("");
//                     cost.setText("");
//                 }
//             });
//             this.setVisible(true);
//         }
//     }

//     private class AddCDStoreScreen extends JFrame {
//         public AddCDStoreScreen(Store store) {
//             this.setLayout(new GridLayout(7, 2, 5, 5));
//             this.add(new JLabel("Enter title: "));
//             TextField title = new TextField(10);
//             this.add(title);
//             this.add(new JLabel("Enter category: "));
//             TextField category = new TextField(10);
//             this.add(category);
//             this.add(new JLabel("Enter cost: "));
//             TextField cost = new TextField(10);
//             this.add(cost);
//             this.add(new JLabel("Enter artist: "));
//             TextField artist = new TextField(10);
//             this.add(artist);
//             this.setTitle("Add CD");
//             this.add(new JLabel("Number of tracks: "));
//             TextField numberOfTracks = new TextField(10);
//             this.add(numberOfTracks);
//             this.pack();
//             JButton turnInBtn = new JButton("Add");
//             this.add(turnInBtn);
//             turnInBtn.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {

//                     CompactDisc dvd = new CompactDisc(2, title.getText(), category.getText(),
//                             Float.parseFloat(cost.getText()), artist.getText(), new ArrayList<Track>());
//                     store.addMedia(dvd);
//                     cp.add(createCenter(), BorderLayout.CENTER);
//                     cp.revalidate();
//                     title.setText("");
//                     category.setText("");
//                     cost.setText("");
//                 }
//             });
//             this.setVisible(true);
//         }
//     }

//     private class AddBookStoreScreen extends JFrame {
//         public AddBookStoreScreen(Store store) {
//             this.setLayout(new GridLayout(4, 2, 5, 5));
//             this.add(new JLabel("Enter title: "));
//             TextField title = new TextField(10);
//             this.add(title);
//             this.add(new JLabel("Enter category: "));
//             TextField category = new TextField(10);
//             this.add(category);
//             this.add(new JLabel("Enter cost: "));
//             TextField cost = new TextField(10);
//             this.add(cost);
//             this.setTitle("Add Book");
//             this.setSize(300, 150);
//             JButton addButton = new JButton("Add");
//             this.add(addButton);
//             addButton.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     Book book = new Book(2, title.getText(), category.getText(), Float.parseFloat(cost.getText()));
//                     store.addMedia(book);
//                     cp.add(createCenter(), BorderLayout.CENTER);
//                     cp.revalidate();
//                     title.setText("");
//                     category.setText("");
//                     cost.setText("");
//                 }
//             });

//             this.setVisible(true);
//         }
//     }


//     public static void main(String[] args) {
//         DigitalVdDisc dvd = new DigitalVdDisc( "OOP", "Curious",20.5f);
       

//         ArrayList<Track> tracks = new ArrayList<Track>();
//         tracks.add(new Track("Thien Ly oi", 7));
//         tracks.add(new Track("Thien An", 4));
//         tracks.add(new Track("5Milion", 5));
//         CompactDisc cd = new CompactDisc(2, "J97", "V-POP", 26.5f, "Various artist", tracks);

//         ArrayList<Track> tracks2 = new ArrayList<Track>();
//         String[][] trackData = {
//                 {"Animals", "5"},
//                 {"Clarity", "4"},
//                 {"Wake Me Up", "4"},
//                 {"Don't You Worry Child", "5"},
//                 {"Lean On", "3"},
//                 {"Strobe", "10"},
//                 {"Titanium", "4"},
//                 {"Faded", "3"},
//                 {"Summer", "3"},
//                 {"The Middle", "3"}
//         };

//         for (String[] track : trackData) {
//             tracks2.add(new Track(track[0], Integer.parseInt(track[1])));
//         }
//         CompactDisc cd2 = new CompactDisc(5, "EDM", "REMIX", 32.25f, "Various artist", tracks2);

//         List<String> authors = new ArrayList<String>();
//         authors.add("Bengo4");
//         Book book1 = new Book(3, "Conan", "detective", 18.5f);
//         List<String> authors2 = new ArrayList<String>();
//         authors2.add("Alan Walker");
//         Book book2 = new Book(4, "Harry Potter", "Novel", 35.45f);
//         Store store = new Store();

//         store.addMedia(cd);
//         store.addMedia(cd2);
//         store.addMedia(dvd);
//         // store.addMedia(dvd2);
//         store.addMedia(book1);
//         store.addMedia(book2);

//         Book[] books = new Book[15];
//         Cart myCart = new Cart();
//         new StoreScreen(store, myCart);

//     }

// }
