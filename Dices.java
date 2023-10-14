import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

class Dices {
    // Vos méthodes et variables liées aux dés ici...
}

public class AllCharactersMvmnt {
    // Vos méthodes et variables liées aux personnages ici...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dices dices = new Dices();
            dices.frame = new JFrame("Lancer de dés");
            dices.frame.setSize(new Dimension(650, 150));
            dices.frame.setResizable(false);
            dices.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dices.frame.setLayout(new FlowLayout());
            dices.frame.add(dices.panelDice);
            dices.frame.setVisible(true);

            AllCharactersMvmnt charactersMvmnt = new AllCharactersMvmnt();
            charactersMvmnt.fenetre = new JFrame("Affichage de photos");
            charactersMvmnt.fenetre.setSize(800, 700);
            charactersMvmnt.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            charactersMvmnt.fenetre.setSize(new Dimension(650, 750));
            charactersMvmnt.fenetre.setResizable(false);

            JPanel characterPanel = new JPanel() {
                // Votre code de dessin des personnages ici...
            };

            charactersMvmnt.fenetre.add(characterPanel);
            characterPanel.setLayout(null);
            charactersMvmnt.fenetre.setFocusable(true);
            charactersMvmnt.fenetre.requestFocus();
            charactersMvmnt.fenetre.setVisible(true);
        });
    }
}
