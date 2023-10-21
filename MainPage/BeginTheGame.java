import javax.swing.*;
import java.awt.*;

public class BeginTheGame {

    public void MapOfTheGame() {

        // Création de la fenêtre Swing
        JFrame MapPicture = new JFrame("D&D");
        MapPicture.setSize(550, 550);
        MapPicture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Crée un panneau pour contenir les composants
        JPanel panneau = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Charge l'image depuis le fichier MapDD2.jpg (assurez-vous que le fichier existe)
                ImageIcon imageIcon = new ImageIcon("MapDD1.png");
                Image image = imageIcon.getImage();

                // Dimensions de l'image
                g.drawImage(image, 0, 0, this);
            }
        };

        // Ajoute le panneau à la fenêtre
        MapPicture.add(panneau);


        // Définit l'opération par défaut lorsque vous fermez la fenêtre
        MapPicture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rend la fenêtre visible en fonction de la condition
    
            MapPicture.setVisible(true);
       
    }
}
