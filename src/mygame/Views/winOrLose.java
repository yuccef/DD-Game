package src.mygame.Views;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;


import src.mygame.WelcomingPage;
import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Models.TheFighter.FighterCaracter;



public class winOrLose {



   public  WelcomingPage welcomingPageWinOrLose  ;

    public JFrame winOrLoseWindow;
    public FighterCaracter Bnadem;
    public Dragon Dragon;  

    String theLevelWinOrLose;
    String NextLevelWinOrLose;

    public int FighterLife;
    public int DragonLife;

    public labyrinth labyrinthWinOrLose;

  public void winOrLose( labyrinth labyrinth) {


    labyrinthWinOrLose = labyrinth;
    welcomingPageWinOrLose = labyrinth.welcomingPageLabyrinth;
    theLevelWinOrLose = labyrinth.welcomingPageLabyrinth.theLevel;


    

    winOrLoseWindow = new JFrame("Finale !!");
    winOrLoseWindow.setLocation(0,0);
    winOrLoseWindow.setSize(1100, 635);
    winOrLoseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    winOrLoseWindow.setResizable(false);
    winOrLoseWindow.setLayout(null);

    ImageIcon backgroundWin = new ImageIcon("../Project/src/mygame/resource/win.jpg");
    JLabel backgroundLabelWin = new JLabel(backgroundWin);
    backgroundLabelWin.setBounds(0, 0, 1100, 635);


    ImageIcon backgroundLose = new ImageIcon("../Project/src/mygame/resource/lose.jpg");
    JLabel backgroundLabelLose = new JLabel(backgroundLose);
    backgroundLabelLose.setBounds(0, 0, 1100, 635);

   FighterLife = labyrinth.getLifeFighter();
   DragonLife = labyrinth.getLifeDragon();

   if(FighterLife>0 & DragonLife<=0){
    winOrLoseWindow.add(backgroundLabelWin);
    winOrLoseWindow.setVisible(true);
    winOrLoseWindow.setLocationRelativeTo(null);
              labyrinthWinOrLose.Window.dispose();
              actionPerformed(null);




    }
if( FighterLife<=0 & DragonLife>0)   {
  winOrLoseWindow.add(backgroundLabelLose);

  
    winOrLoseWindow.setVisible(true);
    winOrLoseWindow.setLocationRelativeTo(null);
              labyrinthWinOrLose.Window.dispose();

    }





  }

 public void actionPerformed(ActionEvent e) {
        String message = "Voulez-vous continuer de jouer";

        JOptionPane optionPane = new JOptionPane(
                message,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                new Object[]{"Oui", "Non"},
                "Non"
        );

        optionPane.setBackground(new java.awt.Color(0xb3b3df));

        JDialog dialog = optionPane.createDialog("Next Level");

        dialog.setVisible(true);

        Object selectedValue = optionPane.getValue();

        if ("Oui".equals(selectedValue)) {
            String theLevelWinOrLose = labyrinthWinOrLose.welcomingPageLabyrinth.theLevel;

            if ("Easy".equals(theLevelWinOrLose)) {

              Dragon.instanceDragon=null;
              labyrinthWinOrLose.Dragon=Dragon.getDragonMediumLevel();
              labyrinthWinOrLose.welcomingPageLabyrinth.theLevel="Medium";
              new labyrinth(labyrinthWinOrLose.welcomingPageLabyrinth);
              
            } else if ("Medium".equals(theLevelWinOrLose)) {

              Dragon.instanceDragon=null;
              labyrinthWinOrLose.Dragon=Dragon.getDragonHardLevel();
              labyrinthWinOrLose.welcomingPageLabyrinth.theLevel="Hard";
              new labyrinth(labyrinthWinOrLose.welcomingPageLabyrinth);

              
            } else if ("Hard".equals(theLevelWinOrLose)) {

              Dragon.instanceDragon=null;
              labyrinthWinOrLose.Dragon=Dragon.getDragonHardLevel();
              labyrinthWinOrLose.welcomingPageLabyrinth.theLevel="Hard";
              new labyrinth(labyrinthWinOrLose.welcomingPageLabyrinth);
            }
        }
    }




}





