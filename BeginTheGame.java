import javax.swing.*;
import java.awt.*;

public class BeginTheGame {

    public void MapOfTheGame() {

        // Création de la fenêtre Swing
        JFrame MapPicture = new JFrame("D&D");

        // Crée un panneau pour contenir les composants
        JPanel panneau = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Charge l'image depuis le fichier MapDD2.jpg (assurez-vous que le fichier existe)
                ImageIcon imageIcon = new ImageIcon("MapDD2.jpg");
                Image image = imageIcon.getImage();

                // Dimensions de l'image
                g.drawImage(image, 50, 50, this);
            }
        };

        // Ajoute le panneau à la fenêtre
        MapPicture.add(panneau);

        // Définit la taille de la fenêtre
        MapPicture.setSize(900, 400);

        // Définit l'opération par défaut lorsque vous fermez la fenêtre
        MapPicture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rend la fenêtre visible en fonction de la condition
    
            MapPicture.setVisible(true);
            //premiertest::fenetre.setVisible(false);
       
    }
}
