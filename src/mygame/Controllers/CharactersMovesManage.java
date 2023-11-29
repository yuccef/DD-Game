package src.mygame.Controllers;

import javax.swing.*;
import java.lang.String;

import src.mygame.Views.*;
import src.mygame.Utils.PicturesPath;
import src.mygame.Controllers.Sound;


public class CharactersMovesManage{


    PicturesPath Paths = new PicturesPath();

    public labyrinth labyrinthImportant;
    Sound sound = new Sound();

    //I want a construcctor who initialize the labyrinth
    public CharactersMovesManage(labyrinth labyrinthInstance) {
         labyrinthImportant=labyrinthInstance ;
    }

public void moveFighter(int Choice, int dx, int dy , labyrinth labyrinthImportant) {
        labyrinth labyrinth = this.labyrinthImportant;

        int newX = labyrinth.xFighter + dx * 5;
        int newY = labyrinth.yFighter + dy * 5;
        int newXX=labyrinth.xDragon+dx*5;
        int newYY=labyrinth.yDragon+dy*5;
    if(dx>=0 ){
          if(Choice == 1){
        labyrinth.gameTimers.timerShieldFighter.stop();
        labyrinth.gameTimers.ShieldFighterCheker=0;
        labyrinth.FighterShield.setIcon(null);             
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { 
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xFighter = newX;
                labyrinth.yFighter = newY;
                ShowFighter(Paths.imagePathsFighterRun[labyrinth.currentImageIndexFighterAttack], Paths.imagePathsDragonRun[labyrinth.currentImageIndexDragonRun], labyrinth);
         
            }
        }
    }
          if(Choice==2){
        labyrinth.gameTimers.timerShieldDragon.stop();
        labyrinth.DragonShield.setIcon(null);
        if(newXX>=0 && newXX+40<labyrinth.MATRIX_SIZE && newYY>=0 && newYY+40<labyrinth.MATRIX_SIZE){
            boolean canMove=true;
            for(int i=newXX;i<newXX+40;i++){
            for(int j=newYY;j<newYY+40;j++){
                if(labyrinth.Bmatrix[i][j]==1){
                canMove=false;
                break;
                }
            }
            }
            if(canMove){
            labyrinth.xDragon=newXX;
            labyrinth.yDragon=newYY;
            ShowFighter(Paths.imagePathsFighterRun[labyrinth.currentImageIndexFighterRun], Paths.imagePathsDragonRun[labyrinth.currentImageIndexDragonRun], labyrinth);
     
            }
        }
    }

}

    if(dx<=0 ){
        if(Choice == 1){
        labyrinth.FighterShield.setIcon(null);             
        labyrinth.gameTimers.timerShieldFighter.stop();
        labyrinth.gameTimers.ShieldFighterCheker=0;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { 
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xFighter = newX;
                labyrinth.yFighter = newY;
                ShowFighter(Paths.imagePathsFighterRunInverse[labyrinth.currentImageIndexFighterRun], Paths.imagePathsDragonRun[labyrinth.currentImageIndexDragonRun], labyrinth);
      

            }
        }

    }
        if(Choice==2){
        labyrinth.gameTimers.timerShieldDragon.stop();
        labyrinth.DragonShield.setIcon(null);
        if(newXX>=0 && newXX+40<labyrinth.MATRIX_SIZE && newYY>=0 && newYY+40<labyrinth.MATRIX_SIZE){
            boolean canMove=true;
            for(int i=newXX;i<newXX+40;i++){
            for(int j=newYY;j<newYY+40;j++){
                if(labyrinth.Bmatrix[i][j]==1){
                canMove=false;
                break;
                }
            }
            }
            if(canMove){
            labyrinth.xDragon=newXX;
            labyrinth.yDragon=newYY;
            ShowFighter(Paths.imagePathsFighterRun[labyrinth.currentImageIndexFighterRun], Paths.imagePathsDragonRunInverse[labyrinth.currentImageIndexDragonRun], labyrinth);
            
            }
        }
    }

}
if(labyrinth.xFighter==labyrinth.xBonus1 && labyrinth.yFighter==labyrinth.yBonus1){
    labyrinth.BonusLabel.setIcon(null);
    labyrinth.BonusLabel.setVisible(false);
    labyrinth.BonusLabel.setBounds(0, 0, 0, 0);
    labyrinth.BonusLabel.repaint();
    labyrinth.BonusLabel.revalidate();
    labyrinth.BonusLabel=null;
    labyrinth.Bnadem.BonusLife(labyrinth.Bnadem);
    labyrinth.RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + labyrinth.Bnadem.score);
    sound.playSound(4);

    }
if(labyrinth.xFighter==labyrinth.xBonus2 && labyrinth.yFighter==labyrinth.yBonus2){
    labyrinth.BonusLabel2.setIcon(null);
    labyrinth.BonusLabel2.setVisible(false);
    labyrinth.BonusLabel2.setBounds(0, 0, 0, 0);
    labyrinth.BonusLabel2.repaint();
    labyrinth.BonusLabel2.revalidate();
    labyrinth.BonusLabel2=null;
    labyrinth.Bnadem.BonusLife(labyrinth.Bnadem);
    labyrinth.RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + labyrinth.Bnadem.score);
    sound.playSound(4);


    
    }

}

public void ShowFighter(String nomImage, String nomImage2, labyrinth labyrinthInstance) {
        labyrinth labyrinth=this.labyrinthImportant ;

        ImageIcon imageIcon = new ImageIcon(nomImage);
        ImageIcon imageIcon2 = new ImageIcon(nomImage2);

        labyrinth.characterLabel.setIcon(imageIcon);
        labyrinth.DragonLabel.setIcon(imageIcon2);

        labyrinth.characterLabel.setBounds(labyrinth.xFighter, labyrinth.yFighter, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        labyrinth.DragonLabel.setBounds(labyrinth.xDragon, labyrinth.yDragon, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        labyrinth.characterLabel.repaint();
    }
    
public void moveAttack( int Choice, labyrinth labyrinthInstance)  {
        labyrinth labyrinth=this.labyrinthImportant ;
    
    if(Choice==1){
        labyrinth.gameTimers.timerShieldFighter.stop();
        labyrinth.FighterShield.setIcon(null); 
         labyrinth.gameTimers.ShieldFighterCheker=0;   

        if(labyrinth.SideFighter=='R'){
                    if(labyrinth.SideDragon=='R'){
        int newX = labyrinth.xFighter +  7;
        int newY = labyrinth.yFighter ;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xFighter = newX;
                labyrinth.yFighter = newY;
                labyrinth.gameTimers.timerFireFighter.start();
                labyrinth.gameTimers.FirstTimeFighter=0;
                ShowFighter(Paths.imagePathsFighterAttack[labyrinth.currentImageIndexFighterAttack],Paths.imagePathsDragonRun[labyrinth.currentImageIndexDragonRun], labyrinth);

            }
        }
    }
                    if(labyrinth.SideDragon=='L'){
         int newX = labyrinth.xFighter +  7;
        int newY = labyrinth.yFighter ;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xFighter = newX;
                labyrinth.yFighter = newY;
                 labyrinth.gameTimers.timerFireFighter.start();
                labyrinth.gameTimers.FirstTimeFighter=0;
                ShowFighter(Paths.imagePathsFighterAttack[labyrinth.currentImageIndexFighterAttack],Paths.imagePathsDragonRunInverse[labyrinth.currentImageIndexDragonRun], labyrinth);

            }
        }

    }
}
        if(labyrinth.SideFighter=='L'){
                         if(labyrinth.SideDragon=='R'){
        int newX = labyrinth.xFighter -  7;
        int newY = labyrinth.yFighter ;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xFighter = newX;
                labyrinth.yFighter = newY;
                ShowFighter(Paths.imagePathsFighterAttackInverse[labyrinth.currentImageIndexFighterAttack],Paths.imagePathsDragonRun[labyrinth.currentImageIndexDragonRun], labyrinth);
                labyrinth.gameTimers.timerFireFighter.start();
                labyrinth.gameTimers.FirstTimeFighter=0;
            }
        }
    }
                         if(labyrinth.SideDragon=='L'){
        int newX = labyrinth.xFighter -  7;
        int newY = labyrinth.yFighter;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xFighter = newX;
                labyrinth.yFighter = newY;
                ShowFighter(Paths.imagePathsFighterAttackInverse[labyrinth.currentImageIndexFighterAttack],Paths.imagePathsDragonRunInverse[labyrinth.currentImageIndexDragonRun], labyrinth);
                labyrinth.gameTimers.timerFireFighter.start();
                labyrinth.gameTimers.FirstTimeFighter=0;
            }
        }
    }
}
}
    if(Choice==2){

        labyrinth.gameTimers.timerShieldDragon.stop();
        labyrinth.DragonShield.setIcon(null);
     if(labyrinth.SideDragon=='R'){
                          if(labyrinth.SideFighter=='R'){
        int newX = labyrinth.xDragon;
        int newY = labyrinth.yDragon ;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xDragon = newX;
                labyrinth.yDragon = newY;
                ShowFighter(Paths.imagePathsFighterRun[labyrinth.currentImageIndexFighterRun],Paths.imagePathsDragonAttack[labyrinth.currentImageIndexDragonAttack], labyrinth);
    
                labyrinth.gameTimers.timerFire.start();
                labyrinth.gameTimers.FirstTime=0;

            }
        }
    }
                          if(labyrinth.SideFighter=='L'){
         int newX = labyrinth.xDragon ;
        int newY = labyrinth.yDragon ;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xDragon = newX;
                labyrinth.yDragon = newY;
                ShowFighter(Paths.imagePathsFighterRunInverse[labyrinth.currentImageIndexFighterRun],Paths.imagePathsDragonAttack[labyrinth.currentImageIndexDragonAttack], labyrinth);
                labyrinth.gameTimers.timerFire.start();
                labyrinth.gameTimers.FirstTime=0;
            }
        }

    }
}
     if(labyrinth.SideDragon=='L'){
                       if(labyrinth.SideFighter=='R'){
        int newX = labyrinth.xDragon;
        int newY = labyrinth.yDragon;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xDragon = newX;
                labyrinth.yDragon = newY;
                        labyrinth.gameTimers.timerFire.start();
                        labyrinth.gameTimers.FirstTime=0;

                ShowFighter(Paths.imagePathsFighterRun[labyrinth.currentImageIndexFighterRun],Paths.imagPathsDragonAttackInverse[labyrinth.currentImageIndexDragonAttack], labyrinth);
            }
        }
    }
                       if(labyrinth.SideFighter=='L'){
      int newX = labyrinth.xDragon ;
        int newY = labyrinth.yDragon;
        if (newX >= 0 && newX + 40 < labyrinth.MATRIX_SIZE && newY >= 0 && newY + 40 < labyrinth.MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                labyrinth.xDragon = newX;
                labyrinth.yDragon = newY;
                        labyrinth.gameTimers.timerFire.start();
                        labyrinth.gameTimers.FirstTime=0;

                ShowFighter(Paths.imagePathsFighterRunInverse[labyrinth.currentImageIndexFighterRun],Paths.imagPathsDragonAttackInverse[labyrinth.currentImageIndexDragonAttack], labyrinth);
            }
        }                              
}
}
}

}
}       