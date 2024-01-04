/////////This File is Done with Factory Design Pattern///////////////



//reflichir a quoi sert deja 




package src.mygame.Views;

import javax.swing.*;
import java.lang.String;




 interface CharacterFactory {
    String getFireImage();
    String getShieldImage();
    String getInversedFireImage();
    String getInversedShieldImage();
}

class EasyLevelDragonFactory implements CharacterFactory {
    @Override
    public String getFireImage() {
        return "../Project/src/mygame/resource/GameCharacters/FirstDragon/FireInversed.png";
    }

    @Override
    public String getShieldImage() {
        return "../Project/src/mygame/resource/GameCharacters/FirstDragon/DragonShield.png";
    }

    @Override
    public String getInversedFireImage() {
        return "../Project/src/mygame/resource/GameCharacters/FirstDragon/Fire.png";
    }

    @Override
    public String getInversedShieldImage() {
        return "../Project/src/mygame/resource/GameCharacters/FirstDragon/DragonShieldInversed.png";
    }
}

class MediumLevelDragonFactory implements CharacterFactory {
    @Override
    public String getFireImage() {
        return "../Project/src/mygame/resource/GameCharacters/SecondDragon/Fire.png";
    }

    @Override
    public String getShieldImage() {
        return "../Project/src/mygame/resource/GameCharacters/SecondDragon/Shield.png";
    }

    @Override
    public String getInversedFireImage() {
        return "../Project/src/mygame/resource/GameCharacters/SecondDragon/Fire.png";
    }

    @Override
    public String getInversedShieldImage() {
        return "../Project/src/mygame/resource/GameCharacters/SecondDragon/ShieldInversed.png";
    }
}

class HardLevelDragonFactory implements CharacterFactory {
    @Override
    public String getFireImage() {
        return "../Project/src/mygame/resource/GameCharacters/ThirdDragon/fire.png";
    }

    @Override
    public String getShieldImage() {
        return "../Project/src/mygame/resource/GameCharacters/ThirdDragon/Shield.png";
    }

    @Override
    public String getInversedFireImage() {
        return "../Project/src/mygame/resource/GameCharacters/ThirdDragon/fire.png";
    }

    @Override
    public String getInversedShieldImage() {
        return "../Project/src/mygame/resource/GameCharacters/ThirdDragon/ShieldInversed.png";
    }
}

public class FireAndShieldManage {
    public ImageIcon fireIcon, fireIconInversed;
    public String fireImage, fireImageInversed;

    ImageIcon shieldIcon, shieldIconInversed;
    String shieldImage, shieldImageInversed;


   


    public void ShowFire(int x, int y, labyrinth labyrinth) {

        //  public ImageIcon fireIcon, fireIconInversed;
        //  public String fireImage, fireImageInversed;
         String theLevel = labyrinth.RightSidePanel.welcomingPage.theLevel;


        if(theLevel.equals("Easy")){

        EasyLevelDragonFactory easyLevelDragonFactory = new EasyLevelDragonFactory();
         fireImage = easyLevelDragonFactory.getFireImage();
         fireImageInversed =  easyLevelDragonFactory.getInversedFireImage();

                
         fireIcon = new ImageIcon(fireImage);
         fireIconInversed = new ImageIcon(fireImageInversed);
        


        }
        else if(theLevel.equals("Medium")){
            MediumLevelDragonFactory mediumLevelDragonFactory = new MediumLevelDragonFactory();
                    fireImage = mediumLevelDragonFactory.getFireImage();
                    fireImageInversed = mediumLevelDragonFactory.getInversedFireImage();

        
         fireIcon = new ImageIcon(fireImage);
         fireIconInversed = new ImageIcon(fireImageInversed);
        }
        else if(theLevel.equals("Hard")){

            HardLevelDragonFactory hardLevelDragonFactory = new HardLevelDragonFactory();
                    fireImage = hardLevelDragonFactory.getFireImage();
                   fireImageInversed =hardLevelDragonFactory.getInversedFireImage();

        
         fireIcon = new ImageIcon(fireImage);
         fireIconInversed = new ImageIcon(fireImageInversed);
        }
 




        labyrinth.FireDragonLabel.setIcon(fireIcon);
        labyrinth.FireDragonLabel.setBounds(x, y, fireIcon.getIconWidth(), fireIcon.getIconHeight());

    }

    
    public void ShowShieldDragon(int x, int y, labyrinth labyrinth) {

        // ImageIcon shieldIcon, shieldIconInversed;
        // String shieldImage, shieldImageInversed;
        String theLevel = labyrinth.RightSidePanel.welcomingPage.theLevel;


        if(theLevel.equals("Easy")){
            EasyLevelDragonFactory easyLevelDragonFactory = new EasyLevelDragonFactory();

         shieldImage = easyLevelDragonFactory.getShieldImage();
         shieldImageInversed = easyLevelDragonFactory.getInversedShieldImage();

                
         shieldIcon = new ImageIcon(shieldImage);
         shieldIconInversed = new ImageIcon(shieldImageInversed);

        }   

        else if(theLevel.equals("Medium")){

            MediumLevelDragonFactory mediumLevelDragonFactory = new MediumLevelDragonFactory();
                    shieldImage =mediumLevelDragonFactory.getShieldImage();
                    shieldImageInversed =mediumLevelDragonFactory.getInversedShieldImage();

        
         shieldIcon = new ImageIcon(shieldImage);
         shieldIconInversed = new ImageIcon(shieldImageInversed);
        }
        else if(theLevel.equals("Hard")){

            HardLevelDragonFactory hardLevelDragonFactory = new HardLevelDragonFactory();
                    shieldImage = hardLevelDragonFactory.getShieldImage();
                   shieldImageInversed = hardLevelDragonFactory.getInversedShieldImage();

        
         shieldIcon = new ImageIcon(shieldImage);
         shieldIconInversed = new ImageIcon(shieldImageInversed);
        }

        labyrinth.DragonShield.setIcon(shieldIcon);
        labyrinth.DragonShield.setBounds(x-40, y, shieldIcon.getIconWidth(), shieldIcon.getIconHeight());

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


   

    
    }  
