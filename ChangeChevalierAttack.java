 import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeChevalierAttack {
    private JFrame fenetre;
    private JLabel imageLabel;
    int res=0;

    public ChangeChevalierAttack() {
         fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        fenetre.add(imageLabel);

        // Créer un Timer pour afficher la première image pendant 1 seconde
        Timer timer1 = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherImage("../project/caracteresIcone/positionTwoChevalier.png");
            }
        });
        timer1.setRepeats(true); // Arrête le timer après une seule exécution
        timer1.start();

        // Créer un Timer pour afficher la deuxième image pendant 2 secondes
        Timer timer2 = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherImage("../project/caracteresIcone/positionOneChevalier.png");
            }
        });
        timer2.setRepeats(true); // Arrête le timer après une seule exécution
        timer2.setInitialDelay(1000); // Démarrer après la fin du premier timer
       timer2.start();
    
        fenetre.setVisible(true);
        res++;
    
    }
    

    private void afficherImage(String nomImage) {
        ImageIcon imageIcon = new ImageIcon(nomImage);
        imageLabel.setIcon(imageIcon);
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