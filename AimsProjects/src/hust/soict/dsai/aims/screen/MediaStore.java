package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class MediaStore extends JPanel {

    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add to cart button
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new addToCartListener());
        container.add(addToCartButton);

        // Play button
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new playButtonListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class playButtonListener implements ActionListener {
        private final JDialog playing;

        public playButtonListener() {
            playing = new JDialog();
            playing.setLayout(new BorderLayout());
            playing.setSize(200, 100);
            JLabel label = new JLabel("");
            label.setHorizontalAlignment(JLabel.CENTER);
            playing.add(label, BorderLayout.CENTER);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel label = (JLabel) playing.getContentPane().getComponent(0);
            label.setText("Playing: " + media.getTitle());
            playing.setVisible(true);
        }
    }

    private class addToCartListener implements ActionListener {
        private final JDialog adding;

        public addToCartListener() {
            adding = new JDialog();
            adding.setLayout(new BorderLayout());
            adding.setSize(200, 100);
            JLabel label = new JLabel("");
            label.setHorizontalAlignment(JLabel.CENTER);
            adding.add(label, BorderLayout.CENTER);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel label = (JLabel) adding.getContentPane().getComponent(0);
            label.setText("Added " + adding.getTitle());
            adding.setVisible(true);
        }
    }

}
