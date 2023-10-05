import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeChevalierPosition {
    private JFrame fenetre;
    private JLabel imageLabel1;
    private JLabel imageLabel2;
    private Timer timer;
    private Timer timer2;
    private Timer timer3;
    private int x1 = 0; // Position en x de la première image
    private int x2 = 0; // Position en x de la deuxième image
    public int res=1;

    public ChangeChevalierPosition() {
        fenetre = new JFrame("Animation de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);

        imageLabel1 = new JLabel(new ImageIcon("../project/caracteresIcone/positionTwoChevalier.png"));
        // imageLabel2 = new JLabel(new ImageIcon("../project/caracteresIcone/positionOneChevalier.png"));

        fenetre.add(imageLabel1);
        // fenetre.add(imageLabel2);

        imageLabel1.setBounds(x1, 220, 100, 100); // Position et taille de la première image
        // imageLabel2.setBounds(x2, 220, 100, 100); // Position et taille de la deuxième image

 
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


        // timer2 = new Timer(200, new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         x2 += 5; // Augmenter la position de la deuxième image

        //         if (x2 > fenetre.getWidth()) {
        //             x2 = -100; // Repositionner la deuxième image à gauche
        //         }
        //         imageLabel2.setLocation(x2, 220);
        //     }
        // });
        // timer2.setRepeats(true); // Arrête le timer après une seule exécution
        // timer2.start();
       
   
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
