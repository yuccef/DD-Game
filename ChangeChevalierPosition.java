import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChangeChevalierPosition {
    private int x = 0;
    private int c=0;
    private JFrame fenetre;
    public JLabel imageLabel;
    public String[] imagePaths = {
        "../project/KnightMvmnt/run1.png",
        "../project/KnightMvmnt/run2.png",
        "../project/KnightMvmnt/run3.png",
        "../project/KnightMvmnt/run4.png",
        "../project/KnightMvmnt/run5.png",
        "../project/KnightMvmnt/run6.png",
        "../project/KnightMvmnt/run7.png",
        "../project/KnightMvmnt/run8.png"
    };
      public String[] imagePathsInverse = {
        "../project/KnightMvmnt/run11.png",
        "../project/KnightMvmnt/run22.png",
        "../project/KnightMvmnt/run33.png",
        "../project/KnightMvmnt/run44.png",
        "../project/KnightMvmnt/run55.png",
        "../project/KnightMvmnt/run66.png",
        "../project/KnightMvmnt/run77.png",
        "../project/KnightMvmnt/run88.png"
    };
      public String[] imagePathsAttack = {
        "../project/KnightMvmnt/KnightAttack1.png",
        "../project/KnightMvmnt/KnightAttack2.png",
         "../project/KnightMvmnt/KnightAttack3.png",
       // "../project/KnightMvmnt/KnightAttack4.png",
    };
          public String[] imagePathsDefense = {
        "../project/KnightMvmnt/KnightDefense.png",
        "../project/KnightMvmnt/KnightDefense2.png",
         "../project/KnightMvmnt/KnightDefense3.png",
       // "../project/KnightMvmnt/KnightAttack4.png",
    };

    private int currentImageIndexX = 0;
    private int currentImageIndexAttack = 0;
    private int currentImageIndexDefense = 0;



    private int y = 220;


    public ChangeChevalierPosition() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        imageLabel = new JLabel();
        fenetre.add(imageLabel);

        // Create a Timer to switch images
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 while(c<1){
                afficherImage(imagePaths[currentImageIndexX]);
                //afficherImage(imagePathsInverse[currentImageIndexX]);
                //afficherImage(imagePathsAttackDefence[currentImageIndexX]);

                c=c+1;
                 }
                currentImageIndexX = (currentImageIndexX + 1) % imagePaths.length; // Loop through the images
            }
        });
        timer.start();

          Timer timer1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 while(c<1){
               // afficherImage(imagePaths[currentImageIndexX]);
                //afficherImage(imagePathsInverse[currentImageIndexX]);
                //afficherImage(imagePathsAttackDefence[currentImageIndexX]);

                c=c+1;
                 }
                currentImageIndexAttack = (currentImageIndexAttack + 1) % imagePaths.length; // Loop through the images
            }
        });
        timer1.start();

                  Timer timer2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 while(c<1){
               // afficherImage(imagePaths[currentImageIndexX]);
                //afficherImage(imagePathsInverse[currentImageIndexX]);
                //afficherImage(imagePathsAttackDefence[currentImageIndexX]);

                c=c+1;
                 }
                currentImageIndexDefense = (currentImageIndexDefense + 1) % imagePaths.length; // Loop through the images
            }
        });
        timer2.start();

        fenetre.setVisible(true);
        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Ne rien faire ici, car nous n'utilisons pas keyTyped
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    // Code à exécuter lorsque la touche droite est enfoncée
                    x += 5; // Avancez l'animation
                    if (x > 1000) {
                        x = 0; // Réinitialisez x lorsque vous atteignez la fin
                    }
                    afficherImage(imagePaths[currentImageIndexX]); // Affichez l'image mise à jour
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    // Code à exécuter lorsque la touche droite est enfoncée
                    x -= 5; // Avancez l'animation
                    if (x <= 0) {
                        x = 0; // Réinitialisez x lorsque vous atteignez la fin
                    }
                    afficherImage(imagePaths[currentImageIndexX]); // Affichez l'image mise à jour
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    // Code à exécuter lorsque la touche droite est enfoncée
                    y -= 5; // Avancez l'animation
                    if (y <= 0) {
                        y = 0; // Réinitialisez x lorsque vous atteignez la fin
                    }
                    afficherImage(imagePaths[currentImageIndexX]); // Affichez l'image mise à jour
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    // Code à exécuter lorsque la touche droite est enfoncée
                    y += 5; // Avancez l'animation
                    if (y > 1000) {
                        y = 0; // Réinitialisez x lorsque vous atteignez la fin
                    }
                    afficherImage(imagePaths[currentImageIndexX]); // Affichez l'image mise à jour
                }
                if (e.getKeyChar() == 'y') {
                afficherImage(imagePathsAttack[currentImageIndexAttack]); // Affichez l'image mise à jour

                    }
                 if (e.getKeyChar() == 'd') {
                afficherImage(imagePathsDefense[currentImageIndexDefense]); // Affichez l'image mise à jour

                    }
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Ne rien faire ici, car nous n'utilisons pas keyReleased
            }
        });

        fenetre.setFocusable(true); // Assurez-vous que la fenêtre est focusable
        fenetre.requestFocus(); // Donnez le focus à la fenêtre pour détecter les touches
    }

    private void afficherImage(String nomImage) {
        ImageIcon imageIcon = new ImageIcon(nomImage);
        imageLabel.setIcon(imageIcon);
        imageLabel.setBounds(x,y, imageIcon.getIconWidth(), imageIcon.getIconHeight()); // Définissez la position de l'image
        fenetre.repaint(); // Actualisez la fenêtre pour afficher l'image
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
