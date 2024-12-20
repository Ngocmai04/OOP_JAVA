import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MediaStore<C extends Cart> extends JPanel {
    private Media media;

    public MediaStore(Media media, C myCart) {
        if (media == null || myCart == null) {
            throw new IllegalArgumentException("Media or Cart cannot be null");
        }

        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
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
                "Media \"" + media.getTitle() + "\" has been added to the cart successfully!",
                "Add to Cart",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        if (media instanceof Playable) {
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
            container.add(new JLabel("Playing DVD: " + dvd.getTitle()));
            container.add(new JLabel("DVD length: " + dvd.get_Length() + " min"));
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            container.add(new JLabel("Title: " + cd.getTitle()));
            container.add(new JLabel("Artist: " + cd.getArtist()));
            for (Track track : cd.addTrack(track)) {
                container.add(new JLabel("Track: " + track.getTitle() + " (" + track.getLength() + " min)"));
            }
        }

        playDialog.setTitle("Play " + media.getTitle());
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
