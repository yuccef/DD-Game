import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeChevalierPosition {
    private JFrame fenetre;
    private JLabel imageLabel1;
    private Timer timer;
    private int x1 = 0; // Position en x de la première image

    public ChangeChevalierPosition() {
        fenetre = new JFrame("Animation de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);
        ChangeChevalierAttack Attack  = new ChangeChevalierAttack();

        imageLabel1 = new JLabel(Attack.ChangeChevalierAttack());

        fenetre.add(imageLabel1);

        imageLabel1.setBounds(x1, 220, 100, 100); // Position et taille de la première image

 
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mettre à jour les positions des images
                x1 += 5; // Augmenter la position de la première image
                if (x1 > fenetre.getWidth()) {
                    x1 = -100; // Repositionner la première image à gauche
                }
                imageLabel1.setLocation(x1, 220);
            }
        });
        timer.setRepeats(true); // Arrête le timer après une seule exécution
        timer.start();


       
   
        fenetre.setVisible(true);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChangeChevalierPosition();
            }
        });
    }
}
