package DrawTheMap;

import javax.swing.*;
import java.lang.String;




class FireAndShieldManage {

    // public void FireAndShieldManage(labyrinth labyrinth) {
    // }
    public void ShowFire( String nomImage, int x, int y , labyrinth labyrinth)  {

    ImageIcon imageIcon = new ImageIcon(nomImage);
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
        nomImage="../Project/resource/GameCharacters/FirstFighter/FighterShield.png";
    }
    if(labyrinth.SideFighter=='L'){
        xShield=x-40;
        nomImage="../Project/resource/GameCharacters/FirstFighter/FighterShieldInversed.png";
    }
    ImageIcon imageIcon = new ImageIcon(nomImage);
    labyrinth.FighterShield.setIcon(imageIcon);
    labyrinth.FighterShield.setBounds(xShield, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

    public void ShowShieldDragon(int x, int y, labyrinth labyrinth) {
        int xShield=0;
        String nomImage="";

    if(labyrinth.SideDragon=='R'){
        xShield=x+70;
       nomImage="../Project/resource/GameCharacters/FirstDragon/DragonShieldInversed.png";
    }
    if(labyrinth.SideDragon=='L'){
        xShield=x-40;
        nomImage="../Project/resource/GameCharacters/FirstDragon/DragonShield.png";
    }
    ImageIcon imageIcon = new ImageIcon(nomImage);
    labyrinth.DragonShield.setIcon(imageIcon);
    labyrinth.DragonShield.setBounds(xShield, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
}

    
    }  
