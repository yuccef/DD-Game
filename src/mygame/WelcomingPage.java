package src.mygame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

import src.mygame.Views.*;


public class WelcomingPage {

    private JFrame charactersWindow;
    public JLabel labelOfWitchButton;
    public JLabel labelOfKnightButton;
    public JLabel labelOfHumanFighterButton;

    
  
    int choix = 0;
    LevelsOfGame niveau = new LevelsOfGame();


    public void showCaracterButton() {
        charactersWindow = new JFrame("Choisir le Fighter");
        charactersWindow.setLocation(0,0);




        labelOfWitchButton = new JLabel("Sorciere");
        labelOfKnightButton = new JLabel("Chevalier");
        labelOfHumanFighterButton = new JLabel("Bnadem");

        Font font = new Font("Georgia", Font.BOLD, 16);

        labelOfKnightButton.setFont(font);
        labelOfWitchButton.setFont(font);
        labelOfHumanFighterButton.setFont(font);


        ImageIcon background = new ImageIcon("../Project/src/mygame/resource//Background.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1100, 635);
        charactersWindow.add(backgroundLabel);



        charactersWindow.setLocationRelativeTo(null);

        JPanel buttonsPanel = new JPanel(null);
        buttonsPanel.setBounds(250, 200, 600, 200);


        CustomButton witchButton = new CustomButton(labelOfKnightButton);
        CustomButton knightButton = new CustomButton(labelOfWitchButton);
        CustomButton humanFighter = new CustomButton(labelOfHumanFighterButton);

        witchButton.setBounds(400, 300, 100, 100);
        knightButton.setBounds(520, 300, 100, 100);
        humanFighter.setBounds(640, 300, 100, 100);

        // Set custom button styles with rounded borders
        setButtonStyles(witchButton);
        setButtonStyles(knightButton);
        setButtonStyles(humanFighter);

        buttonsPanel.add(witchButton);
        buttonsPanel.add(knightButton);
        buttonsPanel.add(humanFighter);

        charactersWindow.add(buttonsPanel);

        witchButton.addActionListener(createButtonListener(1));
        knightButton.addActionListener(createButtonListener(2));
         humanFighter.addActionListener(createButtonListener(3));

        charactersWindow.setSize(new Dimension(1100, 635));
        charactersWindow.setResizable(false);
        charactersWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        charactersWindow.setVisible(true);
        charactersWindow.setLocationRelativeTo(null);  // Ajoutez cette ligne pour centrer la fenêtre sur l'écran
    }
    public void setButtonStyles(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#45458a"));
        button.setFocusPainted(false);
        int arc = 10;
        button.setBorder(new RoundBtn(arc));
    }

     public void showLabyrinthWindow() {
        charactersWindow.dispose();  // Ferme la fenêtre actuelle
        new labyrinth();  // Crée une nouvelle instance de la classe labyrinth
    }

       
    public JButton createLevelButton(String label) {
        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(200, 50));
        WelcomingPage caractereButtonInterface = this;
    
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caractereButtonInterface.showLabyrinthWindow();
            }
        });
    
        return button;
    }

    public ActionListener createButtonListener(int choice) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = switch (choice) {
                    case 1 -> "Voulez-vous vraiment choisir la sorcière ?";
                    case 2 -> "Voulez-vous vraiment choisir le Chevalier ?";
                    case 3 -> "Voulez-vous vraiment choisir le Maitre du jeu ?";
                    default -> "";
                };

                // Personnalisation des couleurs de fond
                UIManager.put("OptionPane.background", new java.awt.Color(0xb3b3df));
                UIManager.put("Panel.background", new java.awt.Color(0xb3b3df));

                // Personnalisation des boutons
                UIManager.put("Button.background", new java.awt.Color(0x9c9cc2));
                UIManager.put("Button.foreground", new java.awt.Color(0xffffff));
                UIManager.put("Button.border", BorderFactory.createLineBorder(new java.awt.Color(0xe0ceb1), 9));

                // Agrandir la taille des boutons
                UIDefaults defaults = UIManager.getDefaults();
                defaults.put("Button.size", new Dimension(150, 50)); // Ajustez les dimensions selon vos besoins

                // Création d'une instance de JOptionPane personnalisée
                JOptionPane optionPane = new JOptionPane(
                        message,
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.YES_NO_OPTION,
                        null,
                        new Object[]{"Oui", "Non"},
                        "Non"
                );

                // Personnalisation de la couleur de fond de l'instance de JOptionPane
                optionPane.setBackground(new java.awt.Color(0xb3b3df));

                JDialog dialog = optionPane.createDialog("Confirmation de Personnage");

                dialog.setVisible(true);

                Object selectedValue = optionPane.getValue();

                if ("Oui".equals(selectedValue)) {
                     charactersWindow.setVisible(true);
                    niveau.showLevelsButton();
                    choix = choice;
                }
            }
        };








    }




class CustomButton extends JButton {
    public CustomButton(JLabel label) {
        setLayout(new BorderLayout());
        setMargin(new Insets(10, 10, 10, 10));
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setText(label.getText());

        Icon icon = label.getIcon();
        if (icon != null) {
            setIcon(new ImageIcon(icon.toString()));
        }
    }
}
    
class RoundBtn implements Border {
        private int r;

        RoundBtn(int r) {
            this.r = r;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.r + 1, this.r + 1, this.r + 2, this.r);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, r, r);
        }
    }

class LevelsOfGame {

    private JFrame fenetreLevels;

    public void showLevelsButton() {


        fenetreLevels = new JFrame("Choisir le niveau souhaite");
        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        JButton easyButton = createLevelButton("Facile");
        JButton midButton = createLevelButton("Moyenne");
        JButton diffButton = createLevelButton("Difficile");

        mainPanel.add(easyButton);
        mainPanel.add(midButton);
        mainPanel.add(diffButton);

        fenetreLevels.add(mainPanel);

        fenetreLevels.setSize(400, 100);
        fenetreLevels.setVisible(true);
        fenetreLevels.setLocationRelativeTo(null);
    }


}




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WelcomingPage app = new WelcomingPage();
                app.showCaracterButton();
            }
        });
    }
}

