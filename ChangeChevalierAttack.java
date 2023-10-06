import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeChevalierAttack {
    private int x = 0;
    private JFrame fenetre;
    private JLabel imageLabel;
    private String[] imagePaths = {
        "../project/KnightMvmnt/run1.png",
        "../project/KnightMvmnt/run2.png",
        "../project/KnightMvmnt/run3.png",
        "../project/KnightMvmnt/run4.png",
        "../project/KnightMvmnt/run5.png",
        "../project/KnightMvmnt/run7.png",
        "../project/KnightMvmnt/run8.png"
    };
    private int currentImageIndex = 0;

    public ChangeChevalierAttack() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        fenetre.add(imageLabel);

        // Create a Timer to switch images
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherImage(imagePaths[currentImageIndex]);
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length; // Loop through the images
            }
        });
        timer.start();

        // Déplacez cette ligne pour rendre la fenêtre visible après l'ajout des composants
        fenetre.setVisible(true);
    }

    private void afficherImage(String nomImage) {
        ImageIcon imageIcon = new ImageIcon(nomImage);
        imageLabel.setBounds(x, 220, 100, 100); // Position et taille de l'image
        imageLabel.setIcon(imageIcon);
        fenetre.repaint(); // Actualisez la fenêtre pour afficher l'image

        // Incrémentez x pour déplacer l'image horizontalement
        x += 5;
        if (x > 1000) {
            x = 0; // Réinitialisez x lorsque vous atteignez la fin
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangeChevalierAttack();
            }
        });
    }
}
