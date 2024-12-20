import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import Lab05.AimProject.src.aims.media.CompactDisc;
import Lab05.AimProject.src.aims.media.DigitalVdDisc;
import Lab05.AimProject.src.aims.media.Media;
import Lab05.AimProject.src.aims.media.Playable;
import Lab05.AimProject.src.aims.media.Track;

public class MediaStore<Cart> extends JPanel {
     @SuppressWarnings("unused")
    private Media media;

    public MediaStore(Media media, Cart myCart) {
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
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Object) myCart).addMedia(media);
                JOptionPane.showMessageDialog(
                        null,
                        "Media \"" + media.get_Title() + "\" has been added to the cart successfully!",
                        "Add to Cart",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            playBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog playDialog = createPlayDialog(media);
                    playDialog.setVisible(true);
                    playDialog.setSize(300, 200);
                    playDialog.pack();
                }
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
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(Box.createRigidArea(new Dimension(10, 10)));

        if (media instanceof DigitalVdDisc) {
            DigitalVdDisc dvd = (DigitalVdDisc) media;
            container.add(new JLabel("Playing DVD: " + dvd.get_Title()));
            container.add(new JLabel("DVD length: " + dvd.get_Length() + " min"));
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            container.add(new JLabel("Title: " + cd.get_Title()));
            container.add(new JLabel("Artist: " + cd.getArtist()));
            for (Track track : cd.addTrack(track )) {
                container.add(new JLabel("Play: " + track.getTitle() + ". Length: " + track.getLength() + " min"));
            }
        }

        playDialog.setTitle("Play " + media.get_Title());
        return playDialog;
    }
}
