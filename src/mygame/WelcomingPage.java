package src.mygame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.lang.String;

import src.mygame.Models.TheFighter.FighterCaracter;
import src.mygame.Views.*;


public  class WelcomingPage {

    public JFrame charactersWindow;
    public JLabel labelOfWitchButton;
    public JLabel labelOfKnightButton;
    public JLabel labelOfHumanFighterButton;

    public  String theLevel ;
    public  String  theCharacter ;

    public int WhichCharacter = 0;
    public int WhichLevel = 0;
    public int choix = 0;



    LevelsOfGame niveau = new LevelsOfGame();


    public  void WelcomingPage(){
        theLevel = this.theLevel;
        theCharacter = this.theCharacter;
    }

   public  String getTheLevel(){
        return theLevel;
    }

   public  String getTheCharacter(){
        return theCharacter;
    }

    public void showCaracterButton() {

        charactersWindow = new JFrame("Choisir le Fighter");
        charactersWindow.setLocation(0,0);

        labelOfWitchButton = new JLabel("Sorciere");
        labelOfKnightButton = new JLabel("Chevalier");
        labelOfHumanFighterButton = new JLabel("Civil");

        Font font = new Font("Georgia", Font.BOLD, 16);
        labelOfKnightButton.setFont(font);
        labelOfWitchButton.setFont(font);
        labelOfHumanFighterButton.setFont(font);
 
        ImageIcon background = new ImageIcon("../Project/src/mygame/resource//Background.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1100, 635);
        charactersWindow.add(backgroundLabel);

        JPanel buttonsPanel = new JPanel(null);
        buttonsPanel.setBounds(250, 200, 600, 200); 

        CustomButton knightButton = new CustomButton(labelOfKnightButton);
        CustomButton witchButton = new CustomButton(labelOfWitchButton);
        CustomButton humanFighter = new CustomButton(labelOfHumanFighterButton);
        
        knightButton.setBounds(400, 300, 100, 100);
        witchButton.setBounds(520, 300, 100, 100);
        humanFighter.setBounds(640, 300, 100, 100);


        setButtonStyles(knightButton);
        setButtonStyles(witchButton);
        setButtonStyles(humanFighter);

        buttonsPanel.add(knightButton);
        buttonsPanel.add(witchButton);
        buttonsPanel.add(humanFighter);

        charactersWindow.add(buttonsPanel);

        knightButton.addActionListener(createButtonListener(1));
        witchButton.addActionListener(createButtonListener(2));
        humanFighter.addActionListener(createButtonListener(3));

        charactersWindow.setSize(new Dimension(1100, 635));
        charactersWindow.setResizable(false);
        charactersWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        charactersWindow.setVisible(true);
        charactersWindow.setLocationRelativeTo(null);  
    }

    public void setButtonStyles(JButton button) {

        int arc = 20;
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#45458a"));
        button.setFocusPainted(false);
        button.setBorder(new RoundBtn(arc));
    }

    public void showLabyrinthWindow() {    
        charactersWindow.dispose(); //Close the window
        new labyrinth(this);  //Open the labyrinth window
       
      }
   
    public JButton createLevelButton(String label) {

 
        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(200, 50));
        WelcomingPage caractereButtonInterface = this;
    
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                       if(label == "Facile"){
            caractereButtonInterface.theLevel = "Easy";
            WhichLevel = 1;
        }
                       else if(label == "Moyenne"){
            caractereButtonInterface.theLevel = "Medium";
            WhichLevel = 2;
        }
                       else if(label == "Difficile"){
            caractereButtonInterface.theLevel = "Hard";
            WhichLevel = 3;
                }
        System.out.println(theLevel);
                caractereButtonInterface.showLabyrinthWindow();
            }
        });

    
        return button;
    }

    public void UpdateLevel(){
            if(WhichLevel == 1){
                theLevel = "Easy";
            }
            else if(WhichLevel == 2){
                theLevel = "Medium";
            }
            else if(WhichLevel == 3){
                theLevel = "Hard";
            }
        }

    public void UpdateCharacter(){
            if(WhichCharacter == 1){
                theCharacter = "Witch";
            }
            else if(WhichCharacter == 2){
                theCharacter = "Knight";
            }
            else if(WhichCharacter == 3){
                theCharacter = "HumanFighter";
            }
        }

    public ActionListener createButtonListener(int choice) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = switch (choice) {
                    case 1 -> "Voulez-vous vraiment choisir la chevalier ?";
                    case 2 -> "Voulez-vous vraiment choisir la sorciere ?";
                    case 3 -> "Voulez-vous vraiment choisir le combatant humain?";
                    default -> "";
                };
                WelcomingPage caractereButtonInterface = WelcomingPage.this;
                if(choice == 1){
                    caractereButtonInterface.theCharacter = "Knight";
                    WhichCharacter = 1;
                }
               else if(choice == 2){
                    caractereButtonInterface.theCharacter = "Witch";
                    WhichCharacter = 2;
                }
                else if(choice == 3){
                    caractereButtonInterface.theCharacter = "HumanFighter";
                    WhichCharacter = 3;
                }
          System.out.println(theCharacter);


                UIManager.put("OptionPane.background", new java.awt.Color(0xb3b3df));
                UIManager.put("Panel.background", new java.awt.Color(0xb3b3df));

                UIManager.put("Button.background", new java.awt.Color(0x9c9cc2));
                UIManager.put("Button.foreground", new java.awt.Color(0xffffff));
                UIManager.put("Button.border", BorderFactory.createLineBorder(new java.awt.Color(0xe0ceb1), 9));

                UIDefaults defaults = UIManager.getDefaults();
                defaults.put("Button.size", new Dimension(150, 50)); // Ajustez les dimensions selon vos besoins

                JOptionPane optionPane = new JOptionPane(
                        message,
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.YES_NO_OPTION,
                        null,
                        new Object[]{"Oui", "Non"},
                        "Non"
                );

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

    public JFrame fenetreLevels;

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


                app.UpdateLevel();
                app.UpdateCharacter();
                app.showCaracterButton();
        

          
             
            }
        });
    }
}

