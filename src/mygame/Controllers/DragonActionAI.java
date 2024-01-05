package src.mygame.Controllers;


import src.mygame.WelcomingPage;
import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Models.TheFighter.FighterCaracter;
import src.mygame.Views.labyrinth;
import src.mygame.Utils.MapMaths;

public class  DragonActionAI {

    private boolean AllowOtherFires = true;   
    FighterCaracter Fighter ;
    Dragon Dragon;
    int FighterAttackChecker=0;
    CharactersMovesManage CharactersMovesManage;

    WelcomingPage welcomingPageAI  ;

    String theLevelAI;


    String FighterMove;
    
    public void DragonActionAI(labyrinth labyrinth) {

        welcomingPageAI=labyrinth.welcomingPageLabyrinth;
        theLevelAI = welcomingPageAI.theLevel;

        Fighter = labyrinth.getBnadem();
         CharactersMovesManage = new CharactersMovesManage(labyrinth);
        Dragon = labyrinth.getDragon();
        FighterMove = labyrinth.Fightermove;
 
        MapMaths MapManage = new MapMaths();


        if(theLevelAI=="Easy"){
            System.out.println("we are on the easy level");

 switch (FighterMove) {
        case "Attack":
            System.out.println("The Fighter attacks!");
            if (MapManage.generateRandomZeroOne(20) == 1) {
                                CharactersMovesManage.moveAttack(2,labyrinth);

                
            }
            if (MapManage.generateRandomZeroOne(35) == 1) {
                labyrinth.gameTimers.timerShieldDragon.start();
            }
            break;

        case "Defend":
            System.out.println("The Fighter defends!");
            if (MapManage.generateRandomZeroOne(40) == 1) {
               
                CharactersMovesManage.moveAttack(2,labyrinth);
            }
            if (MapManage.generateRandomZeroOne(60) == 1) {
                labyrinth.gameTimers.timerShieldDragon.start();
            }
            break;

            case "run":
            System.out.println("The Fighter on Pause!");

            if(labyrinth.yFighter==labyrinth.yDragon){

                if(!AllowOtherFires){
                    return;
                }
                AllowOtherFires = false;
                System.err.println("pause Y");
                if (MapManage.generateRandomZeroOne(30) == 1) {
                    
                    CharactersMovesManage.moveAttack(2,labyrinth);
                }
                if(MapManage.generateRandomZeroOne(13) == 1){
                    for(int i=0;i<2;i++){
                        if(labyrinth.xFighter<labyrinth.xDragon) CharactersMovesManage.moveFighter(2, -1,0,labyrinth);
                        else return;
                        // nzid chi thkrbi9a dial side dragon
                    }
                }

                AllowOtherFires = true;
          

                
            }
            break;
    }

        }

        else if(theLevelAI=="Medium"){

         System.err.println("we are on the Medium level");
         switch (FighterMove) {
        case "Attack":
            System.out.println("The Fighter attacks!");
            if (MapManage.generateRandomZeroOne(50) == 1) {
                    CharactersMovesManage.moveAttack(2,labyrinth);

                
            }
            if (MapManage.generateRandomZeroOne(50) == 1) {
                labyrinth.gameTimers.timerShieldDragon.start();
            }
            break;

        case "Defend":
            System.out.println("The Fighter defends!");
      
            if (MapManage.generateRandomZeroOne(50) == 0) {
       
                 CharactersMovesManage.moveAttack(2,labyrinth);
            }
            if (MapManage.generateRandomZeroOne(80) == 1) {
                labyrinth.gameTimers.timerShieldDragon.start();
            }
            break;

    

                case "run":
            System.out.println("The Fighter on Pause!");

            if(labyrinth.yFighter==labyrinth.yDragon){

                if(!AllowOtherFires){
                    return;
                }
                AllowOtherFires = false;
                System.err.println("pause Y");
                if (MapManage.generateRandomZeroOne(60) == 1) {
                    
                    CharactersMovesManage.moveAttack(2,labyrinth);
                }
                if(MapManage.generateRandomZeroOne(13) == 1){
                    for(int i=0;i<2;i++){
                        if(labyrinth.xFighter<labyrinth.xDragon) CharactersMovesManage.moveFighter(2, -1,0,labyrinth);
                        else return;
                        // nzid chi thkrbi9a dial side dragon
                    }
                }

                AllowOtherFires = true;
          

                
            }
            break;
    }
        }

        else if(theLevelAI=="Hard"){ 
            switch (FighterMove) {
        case "Attack":
            System.out.println("The Fighter attacks!");
            if (MapManage.generateRandomZeroOne(80) == 1) {
                                CharactersMovesManage.moveAttack(2,labyrinth);

                
            }
            if (MapManage.generateRandomZeroOne(80) == 1) {
                labyrinth.gameTimers.timerShieldDragon.start();
            }
            break;

        case "Defend":
            System.out.println("The Fighter defends!");
            if (MapManage.generateRandomZeroOne(80) == 1) {
               
                CharactersMovesManage.moveAttack(2,labyrinth);
            }
      
            if (MapManage.generateRandomZeroOne(80) == 1) {
                labyrinth.gameTimers.timerShieldDragon.start();
            }
            break;

    

                case "run":
            System.out.println("The Fighter on Pause!");

            if(labyrinth.yFighter==labyrinth.yDragon){

                if(!AllowOtherFires){
                    return;
                }
                AllowOtherFires = false;
                System.err.println("pause Y");
                if (MapManage.generateRandomZeroOne(70) == 1) {
                    
                    CharactersMovesManage.moveAttack(2,labyrinth);
                }
                if(MapManage.generateRandomZeroOne(13) == 1){
                    for(int i=0;i<2;i++){
                        if(labyrinth.xFighter<labyrinth.xDragon) CharactersMovesManage.moveFighter(2, -1,0,labyrinth);
                        else return;
                        // nzid chi thkrbi9a dial side dragon
                    }
                }

                AllowOtherFires = true;
          

                
            }
            break;
    }

}

            
    }
    
}