import javax.swing.*; // Pour les composants graphiques
import java.awt.*;
import java.awt.event.ActionEvent; // Pour les événements
import java.awt.event.ActionListener;




public class premiertest {
    public static void main(String[] args) { 

        // Création des fenetres swing
         JFrame fenetre = new JFrame("D&D");
        


        // Crée un panneau pour contenir les composants
         JPanel panneau = new JPanel() { 

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Charge l'image depuis le fichier garcon.png (assurez-vous que le fichier existe)
                ImageIcon imageIcon = new ImageIcon("DragonWelcomePage.png");
                Image image = imageIcon.getImage();

                // Dessine l'image
                g.drawImage(image, 3, 50, this);

                // Définit la police et la couleur du texte
                g.setFont(new Font("Sans-serif", Font.BOLD, 24));
                g.setColor(Color.BLACK);
                g.drawString("Jeu de Dragon", 700, 100);
            }
        };
 

        // Les boutons utilisés dans la première page de jeu
      
        JButton boutonPerso = new JButton("Commencer le jeu");
        JButton Rulesbouton = new JButton("Regles de jeux");
        // JButton Levelsbouton = new JButton("Niveau");

        // JButton boutonCommencer = new JButton("Commencer le jeu");



        // Définir la taille des boutons

        boutonPerso.setPreferredSize(new Dimension(200, 50));
        Rulesbouton.setPreferredSize(new Dimension(200, 50));
        // Levelsbouton.setPreferredSize(new Dimension(200, 50));


        // Utilise un gestionnaire de mise en page pour positionner les boutons
        JPanel boutonPanel = new JPanel();

        boutonPanel.add(Rulesbouton);
        boutonPanel.add(boutonPerso);
        // boutonPanel.add(Levelsbouton);
        // boutonPanel.add(boutonCommencer);

        // BeginTheGame beginTheGame = new BeginTheGame();
        // boutonCommencer.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         fenetre.setVisible(false);
        //         beginTheGame.MapOfTheGame();
        //     }
        // });

        // Ajoute un écouteur d'événements au bouton "Règles de jeux"
        Rulesbouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Regles de jeux");
            }
        });

        // Ajoute un écouteur d'événements au bouton "Choisir le Personnage"
        // Create an instance of CharacterButtonInterface
        CaractereButtonInterface characterInterface = new CaractereButtonInterface( );

        // Add an action listener to the "Choisir le Personnage" button
        boutonPerso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterInterface.ShowCaracterButton(); // Show the character selection window
            }
        });

        // LevelsOfGame niveauDeJeu = new LevelsOfGame() ;

        // Levelsbouton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         niveauDeJeu.showLevelsButton(); // Show the character selection window
        //     }
        // });

        

    






        // Ajoute le panneau à la fenêtre
        fenetre.add(panneau);

        // Ajoute le panneau de boutons en bas de la fenêtre
        fenetre.add(boutonPanel, BorderLayout.SOUTH);

        // Définit la taille de la fenêtre
        fenetre.setSize(900, 400);


        // Définit l'opération par défaut lorsque vous fermez la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rend la fenêtre visible
        fenetre.setVisible(true);
    }
}
