import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaractereButtonInterface {

    
    private JFrame fenetrePersonnages;

    int choix = 0;  // 0 = rien, 1 = sorcière, 2 = chevalier, 3 = maitre du jeu
    BeginTheGame beginTheGame = new BeginTheGame();
    public void ShowCaracterButton() {
        fenetrePersonnages = new JFrame("Choisir un personnage");
        fenetrePersonnages.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new GridLayout(1, 3)); // 1 ligne, 3 colonnes

        // Créez les boutons personnalisés avec image au-dessus
        CustomButton sorciereButton = new CustomButton("Sorcière", "SorciereIcone.png");
        CustomButton chevalierButton = new CustomButton("Chevalier", "ChevalierIcone.png");
        CustomButton maitreButton = new CustomButton("Maitre du jeu", "SageIcone.png");

        // Ajoutez les boutons personnalisés au panneau principal
        mainPanel.add(sorciereButton);
        mainPanel.add(chevalierButton);
        mainPanel.add(maitreButton);

        fenetrePersonnages.add(mainPanel);

        fenetrePersonnages.pack(); // Redimensionne la fenêtre en fonction du contenu
        fenetrePersonnages.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetrePersonnages.setVisible(true);

        // ActionListener pour les boutons (le code ici reste le même)

        sorciereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment choisir la sorcière ?") == JOptionPane.YES_OPTION) {
                    fenetrePersonnages.setVisible(false);
                    beginTheGame.MapOfTheGame();
                    choix = 1;
                }
            }
        });

        chevalierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment choisir le Chevalier ?") == JOptionPane.YES_OPTION) {
                    fenetrePersonnages.setVisible(false);
                    beginTheGame.MapOfTheGame();
                    choix = 2;
                }
            }
        });

        maitreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment choisir le Maitre du jeu ?") == JOptionPane.YES_OPTION) {
                    fenetrePersonnages.setVisible(false);
                    beginTheGame.MapOfTheGame();
                    choix = 3;
                }
            }
        });

        fenetrePersonnages.setSize(600, 200);
        fenetrePersonnages.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetrePersonnages.setVisible(true);
    }

    // Classe de bouton personnalisé avec image au-dessus
    class CustomButton extends JButton {
        public CustomButton(String text, String iconName) {
            setLayout(new BorderLayout());
            setMargin(new Insets(10, 10, 10, 10)); // Marge autour du texte
            setVerticalTextPosition(SwingConstants.BOTTOM);
            setHorizontalTextPosition(SwingConstants.CENTER);
            setText(text);
            ImageIcon icon = new ImageIcon(iconName);
            setIcon(icon);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CaractereButtonInterface app = new CaractereButtonInterface();
                app.ShowCaracterButton();
            }
        });
    }
}
