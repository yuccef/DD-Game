package src.mygame.Controllers;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import src.mygame.Views.RightSidePanel;
import src.mygame.Views.FireAndShieldManage;
import src.mygame.Views.labyrinth;
import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Models.TheFighter.FighterCaracter;
import  src.mygame.Views.winOrLose;


public class GameTimers {

    public Timer timerFireFighter;
    public int xFireFighter=0;
    public int yFireFighter=0;
    public int FirstTimeFighter=0;
    public int SetFireFighter=0;
    public int ShieldFighterCheker=0;
      
    public Timer timerFire; 
    public int xFire=0; 
    public int yFire=0; 
    public int FirstTime=0;
    public int SetFire=0;
    public int ShieldDragonCheker=0;
    
    public Timer timerFighterRun;
    public   Timer timerDragonRun;
    public    Timer timerFighterAttack;
    public    Timer timerDragonAttack;

    public Timer timerShieldFighter;
    public Timer timerShieldDragon;


    public FighterCaracter Bnadem;
    public Dragon Dragon;

    public  FighterCaracter  getBnademTimer() {
    return this.Bnadem;
    }
    public Dragon getDragonTimer() {
    return this.Dragon;
    }


   
    public GameTimers(labyrinth labyrinthInstance ,RightSidePanel RightSidePanelTest) {
        Bnadem = labyrinthInstance.getBnadem();
        Dragon = labyrinthInstance.getDragon();
        labyrinth labyrinth = labyrinthInstance;
        RightSidePanel RightSidePanel =RightSidePanelTest;
        FireAndShieldManage FireAndShieldManage = new FireAndShieldManage( );

                   winOrLose winOrLose = new winOrLose();

   
        //Timer for the fighter and the dragon
         timerFighterRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexFighterRun = ( labyrinth.currentImageIndexFighterRun + 1) % 7; // Loop through the images
            }
        });
        timerFighterRun.start();

          timerDragonRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexDragonRun = (labyrinth.currentImageIndexDragonRun + 1) % 6; // Loop through the images
            }
        });
        timerDragonRun.start();

         timerFighterAttack = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexFighterAttack = (labyrinth.currentImageIndexFighterAttack + 1) % 4; // Loop through the images
            }
        });
        timerFighterAttack.start();

         timerDragonAttack = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labyrinth.currentImageIndexDragonAttack = (labyrinth.currentImageIndexDragonAttack + 1) %4; // Loop through the images
            }
        });
        timerDragonAttack.start();

         timerFire = new Timer(30, new ActionListener() {
            
          @Override

            public void actionPerformed(ActionEvent e) {
          
                

                if(FirstTime==0){
                 xFire = labyrinth.xDragon;
                 yFire = labyrinth.yDragon;
                 FirstTime=1;
           
             }
           
           
           
             if(labyrinth.SideDragon=='L'){

                 
            
       if (xFire <= labyrinth.xFighter  || xFire==40 || xFire==760) {
                            labyrinth.FireDragonLabel.setIcon(null);

                    if (labyrinth.yDragon==labyrinth.yFighter){
                    labyrinth.FireDragonLabel.setIcon(null);
                    timerFire.stop();
                    labyrinth.FireDragonLabel.setIcon(null);
                    Dragon.DamageDragonFighterCaracter(Bnadem, Dragon);
                    Bnadem.FighterCaracterUpdateDealth(Bnadem);
                    Bnadem.lose(Bnadem);
                    winOrLose.winOrLose(labyrinth);
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();
                    
                    
                }
                    timerFire.stop();
                    labyrinth.FireDragonLabel.setIcon(null);
                
           
                    
                }
               
                
         if(ShieldFighterCheker==1  && xFire <= labyrinth.xFighter +40 ){
            if(labyrinth.yDragon==labyrinth.yFighter){
                    timerFire.stop();
                    labyrinth.FireDragonLabel.setIcon(null);
                    Bnadem.FighterDefense(Bnadem, Dragon);
                    Bnadem.lose(Bnadem);
                    winOrLose.winOrLose(labyrinth);

                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();  
                    ShieldFighterCheker=0;
                    timerShieldFighter.stop();
                    labyrinth.FighterShield.setIcon(null);
                 }
                 timerFire.stop();  
                labyrinth.FireDragonLabel.setIcon(null);
                }
               else{
                    FireAndShieldManage.ShowFire( xFire, yFire, labyrinth);
                    xFire -= 5;

                }
            

            }
            if(labyrinth.SideDragon=='R'){
             
             if (xFire == labyrinth.xFighter   ||xFire==760) {
                    timerFire.stop();
                    labyrinth.FireDragonLabel.setIcon(null);
                    FirstTime=0;    

                }else{
                     FireAndShieldManage.ShowFire(xFire, yFire, labyrinth);
                   xFire += 5;


                }   

            }
  
        }
        });
        timerFire.setInitialDelay(0);

        timerFireFighter = new Timer(30, new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {

                if(FirstTimeFighter==0){
                xFireFighter = labyrinth.xFighter;
                yFireFighter = labyrinth.yFighter;
                FirstTimeFighter=1;
                }

             if(labyrinth.SideFighter=='R'){
      
       if (xFireFighter >= labyrinth.xDragon   || xFireFighter==40 || xFireFighter==760) {
                 
                   labyrinth.FireFighterLabel.setIcon(null);
                   timerFireFighter.stop();

                    if(xFireFighter >= labyrinth.xDragon && labyrinth.yDragon==labyrinth.yFighter){
                    labyrinth.FireFighterLabel.setIcon(null);
                    timerFireFighter.stop();
                    Bnadem.DamageFighterCaracterTheDragon(Bnadem, Dragon);
                    Dragon.DragonUpdateDealth(Dragon);
                    Dragon.lose(Dragon);
                    winOrLose.winOrLose(labyrinth);

                    RightSidePanel.DragonLabelRightSideLife.setText(" Vie : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();
                    
                }
                timerFireFighter.stop();  
                labyrinth.FireFighterLabel.setIcon(null);
           
                    
                }
               
                
         if(ShieldDragonCheker==1  && xFireFighter+40 >= labyrinth.xDragon ){
            if(labyrinth.yDragon==labyrinth.yFighter){
                    timerFireFighter.stop();
                    labyrinth.FireFighterLabel.setIcon(null);
                    Dragon.DragonDefense(Bnadem, Dragon);
                    Dragon.lose(Dragon);
                    winOrLose.winOrLose(labyrinth);

                    RightSidePanel.DragonLabelRightSideLife.setText(" Vie : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();  
                    ShieldDragonCheker=0;
                    timerShieldDragon.stop();
                    labyrinth.DragonShield.setIcon(null);
                 }
                 timerFireFighter.stop();  
                labyrinth.FireFighterLabel.setIcon(null);
                }
               else{
                     FireAndShieldManage.ShowFireFighter("../Project/src/mygame/resource/GameCharacters/FirstFighter/FireFighter.png", xFireFighter, yFireFighter, labyrinth);
                    xFireFighter += 5;

                }

            }
            if(labyrinth.SideFighter=='L'){
             
             if (xFireFighter == labyrinth.xDragon   ||xFireFighter==40) {
                   timerFireFighter.stop();
                    labyrinth.FireFighterLabel.setIcon(null);
                    FirstTimeFighter=0;    

                }else{
                     FireAndShieldManage.ShowFireFighter("../Project/src/mygame/resource/GameCharacters/FirstFighter/FireFighterInversed.png", xFireFighter, yFireFighter, labyrinth);
                   xFireFighter -= 5;

                }   
            }
            }
        });
        timerFireFighter.setInitialDelay(0);

        timerShieldFighter = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if(labyrinth.yDragon==labyrinth.yFighter){
                if(labyrinth.xDragon<= labyrinth.xFighter+40 ){
                    labyrinth.FighterShield.setIcon(null);
                    timerShieldFighter.stop();
                    ShieldFighterCheker=0;
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();
                    }
                else{
                     FireAndShieldManage.ShowShieldFighter(labyrinth.xFighter, labyrinth.yFighter, labyrinth);
                    RightSidePanel.FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    RightSidePanel.FighterLifePanel.repaint();
                    ShieldFighterCheker=1;

                }

            }else{
                    FireAndShieldManage.ShowShieldFighter(labyrinth.xFighter, labyrinth.yFighter, labyrinth);
                    RightSidePanel.FighterLifePanel.repaint();
            } 
            }
        });
        timerShieldFighter.setInitialDelay(0);        

        timerShieldDragon = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


            if(labyrinth.yDragon==labyrinth.yFighter){
                                        System.out.println(" Hi I'm timerShieldDragon");
                     
              
                
                if(labyrinth.xDragon<= labyrinth.xFighter+40 ){
                    labyrinth.DragonShield.setIcon(null);
                    timerShieldDragon.stop();
                    ShieldDragonCheker=0;
                    RightSidePanel.DragonLabelRightSideLife.setText(" Vie : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();
                    }
                else{
                     FireAndShieldManage.ShowShieldDragon(labyrinth.xDragon, labyrinth.yDragon, labyrinth);
                    RightSidePanel.DragonLabelRightSideLife.setText(" Vie : " + Dragon.score);
                    RightSidePanel.DragonLifePanel.repaint();
                    ShieldDragonCheker=1;

                }

            }
            if(labyrinth.yDragon!=labyrinth.yFighter) {
                                        System.out.println(" Hi I'm timerShieldDragon");
            
                                        System.out.println(" Hi I'm timerShieldDragon");
          
                     FireAndShieldManage.ShowShieldDragon(labyrinth.xDragon, labyrinth.yDragon, labyrinth);
                    RightSidePanel.DragonLifePanel.repaint();
            } 
            }
        }); 
        timerShieldDragon.setInitialDelay(0);

        
    }
}