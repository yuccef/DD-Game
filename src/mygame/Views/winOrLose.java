package src.mygame.Views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Models.TheFighter.FighterCaracter;
import src.mygame.*;



public class winOrLose {



    public JFrame winOrLoseWindow;
    public FighterCaracter Bnadem;
    public Dragon Dragon;  

    public int FighterLife;
    public int DragonLife;

    public labyrinth labyrinthWinOrLose;

  public void winOrLose( labyrinth labyrinth) {


    labyrinthWinOrLose = labyrinth;
    

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

    }
if( FighterLife<=0 & DragonLife>0)   {
  winOrLoseWindow.add(backgroundLabelLose);

  
    winOrLoseWindow.setVisible(true);
    winOrLoseWindow.setLocationRelativeTo(null);
              labyrinthWinOrLose.Window.dispose();

    }



  }


  
    
}
