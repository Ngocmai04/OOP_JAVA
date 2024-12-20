package src.aims.screen;
import src.aims.cart.Cart;
import src.aims.media.Media;    

import src.aims.media.DigitalVdDisc;
import src.aims.media.CompactDisc;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class MediaStore<C extends Cart> extends JPanel {
    // private static final src.aims.media.Track track = null;
        private Media media;
    
        public MediaStore(Media media, C myCart) {
            if (media == null || myCart == null) {
                throw new IllegalArgumentException("Media or Cart cannot be null");
            }
    
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
            JLabel title = new JLabel(media.get_Title());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);
    
            JLabel cost = new JLabel(String.format("%.2f$", media.get_Cost()));
            cost.setAlignmentX(CENTER_ALIGNMENT);
    
            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
    
            JButton btnAdd = new JButton("Add to cart");
            container.add(btnAdd);
            btnAdd.addActionListener(e -> {
                myCart.addMedia(media);
                JOptionPane.showMessageDialog(
                    null,
                    "Media \"" + media.get_Title() + "\" has been added to the cart successfully!",
                    "Add to Cart",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });
    
            if (media instanceof DigitalVdDisc || media instanceof CompactDisc) {
                JButton playBtn = new JButton("Play");
                playBtn.addActionListener(e -> {
                    JDialog playDialog = createPlayDialog(media);
                    playDialog.setVisible(true);
                });
                container.add(playBtn);
            }
    
            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    
        static JDialog createPlayDialog(Media media) {
            JDialog playDialog = new JDialog();
            Container container = playDialog.getContentPane();
            playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            container.setLayout(new GridLayout(0, 1));
    
            if (media instanceof DigitalVdDisc) {
                DigitalVdDisc dvd = (DigitalVdDisc) media;
                container.add(new JLabel("Playing DVD: " + dvd.get_Title()));
                container.add(new JLabel("DVD length: " + dvd.get_Length() + " min"));
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                container.add(new JLabel("Title: " + cd.get_Title()));
                container.add(new JLabel("Artist: " + cd.getArtist()));
                for (Track track : cd.addTrack()) {
                container.add(new JLabel("Track: " + track.getTitle() + " (" + track.getLength() + " min)"));
            }
        }

        playDialog.setTitle("Play " + media.get_Title());
        playDialog.pack();
        return playDialog;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
