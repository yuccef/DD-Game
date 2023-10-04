import javax.swing.*; // Pour les composants graphiques
import java.awt.*;
// import java.awt.event.ActionEvent; // Pour les événements
// import java.awt.event.ActionListener;






public class BeginTheGame {

    public  void MapOfTheGame() { 

        // Création des fenetres swing
        JFrame MapPicture = new JFrame("D&D");
        


        // Crée un panneau pour contenir les composants
         JPanel panneau = new JPanel() { 

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Charge l'image depuis le fichier garcon.png (assurez-vous que le fichier existe)
                ImageIcon imageIcon = new ImageIcon("MapDD2.jpg.");
                Image image = imageIcon.getImage();
                //dimension de l'image
                g.drawImage(image, 50, 50, this);



                // Dessine l'image
               
            }
        };
 




        

    






        // Ajoute le panneau à la fenêtre
        MapPicture.add(panneau);

        // Ajoute le panneau de boutons en bas de la fenê
        // Définit la taille de la fenêtre
        MapPicture.setSize(900, 400);


        // Définit l'opération par défaut lorsque vous fermez la fenêtre
        MapPicture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        // Rend la fenêtre visible
        MapPicture.setVisible(true);
    }
    
}
