package src.mygame.Views;

import javax.swing.*;
import java.lang.String;




public class FireAndShieldManage {


    String theLevel;
     
    String TheShield, TheFire, TheFireInversed, TheShieldInversed;


    //hna nzid les string dial les fires w les shields
    String FireDragon1 = "../Project/src/mygame/resource/GameCharacters/FirstDragon/Fire.png";
    String FireDragon1Inversed = "../Project/src/mygame/resource/GameCharacters/FirstDragon/FireInversed.png";

    String FireDragon2 = "../Project/src/mygame/resource/GameCharacters/SecondDragon/Fire.png";

    String FireDragon3 = "../Project/src/mygame/resource/GameCharacters/ThirdDragon/fire.png";



    String ShieldDragon1 = "../Project/src/mygame/resource/GameCharacters/FirstDragon/DragonShield.png";
    String ShieldDragon1Inversed = "../Project/src/mygame/resource/GameCharacters/FirstDragon/DragonShieldInversed.png";

    String ShieldDragon2 = "../Project/src/mygame/resource/GameCharacters/SecondDragon/Shield.png";
    String ShieldDragon2Inversed = "../Project/src/mygame/resource/GameCharacters/SecondDragon/ShieldInversed.png";


    String ShieldDragon3 = "../Project/src/mygame/resource/GameCharacters/ThirdDragon/Shield.png";
    String ShieldDragon3Inversed = "../Project/src/mygame/resource/GameCharacters/ThirdDragon/ShieldInversed.png";




    // public void FireAndShieldManage(labyrinth labyrinth) {
    // }
    public void ShowFire( int x, int y , labyrinth labyrinth)  {
    String nomImage="";
    theLevel = labyrinth.RightSidePanel.welcomingPage.theLevel;
    if(theLevel.equals("Easy")){
        TheShield = ShieldDragon1;
        TheShieldInversed = ShieldDragon1Inversed;
        TheFire = FireDragon1;
        TheFireInversed = FireDragon1Inversed;
    }
    else if(theLevel.equals("Medium")){
        TheShield = ShieldDragon2;
        TheShieldInversed = ShieldDragon2Inversed;
        TheFire = FireDragon2;
        TheFireInversed = FireDragon2;
    }
    else if(theLevel.equals("Hard")){
        TheShield = ShieldDragon3;
        TheShieldInversed = ShieldDragon3Inversed;
        TheFire = FireDragon3;
        TheFireInversed = FireDragon3;
    }


    ImageIcon imageIcon = new ImageIcon(TheFire);
    labyrinth.FireDragonLabel.setIcon(imageIcon);
    labyrinth.FireDragonLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

}

    public void ShowFireFighter( String nomImage, int x, int y, labyrinth labyrinth) {
    ImageIcon imageIcon = new ImageIcon(nomImage);  
    labyrinth.FireFighterLabel.setIcon(imageIcon);
    labyrinth.FireFighterLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

    public void ShowShieldFighter( int x, int y, labyrinth labyrinth) {
    int xShield=0;
    String nomImage="";
    if(labyrinth.SideFighter=='R'){
        xShield=x+40;
        nomImage="../Project/src/mygame/resource/GameCharacters/FirstFighter/FighterShield.png";
    }
    if(labyrinth.SideFighter=='L'){
        xShield=x-40;
        nomImage="../Project/src/mygame/resource/GameCharacters/FirstFighter/FighterShieldInversed.png";
    }
    ImageIcon imageIcon = new ImageIcon(nomImage);
    labyrinth.FighterShield.setIcon(imageIcon);
    labyrinth.FighterShield.setBounds(xShield, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

    public void ShowShieldDragon(int x, int y, labyrinth labyrinth) {
        int xShield=0;
        String nomImage="";
          theLevel = labyrinth.RightSidePanel.welcomingPage.theLevel;

          if(theLevel.equals("Easy")){
            TheShield = ShieldDragon1;
            TheShieldInversed = ShieldDragon1Inversed;
            TheFire = FireDragon1;
            TheFireInversed = FireDragon1Inversed;
          }
          else if(theLevel.equals("Medium")){
            TheShield = ShieldDragon2;
            TheShieldInversed = ShieldDragon2Inversed;
            TheFire = FireDragon2;
            TheFireInversed = FireDragon2;
          }
          else if(theLevel.equals("Hard")){
            TheShield = ShieldDragon3;
            TheShieldInversed = ShieldDragon3Inversed;
            TheFire = FireDragon3;
            TheFireInversed = FireDragon3;
          }


    if(labyrinth.SideDragon=='R'){
        xShield=x+70;
       nomImage= TheShield;
    }
    if(labyrinth.SideDragon=='L'){
        xShield=x-40;
        nomImage= TheShieldInversed;
    }
    ImageIcon imageIcon = new ImageIcon(nomImage);
    labyrinth.DragonShield.setIcon(imageIcon);
    labyrinth.DragonShield.setBounds(xShield, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

    
    }  
