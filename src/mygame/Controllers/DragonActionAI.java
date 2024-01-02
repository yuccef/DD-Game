package src.mygame.Controllers;


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

    String FighterMove;
    
    public void DragonActionAI(labyrinth labyrinth) {
        Fighter = labyrinth.getBnadem();
         CharactersMovesManage = new CharactersMovesManage(labyrinth);
        Dragon = labyrinth.getDragon();
        FighterMove = labyrinth.Fightermove;
        //fighterAttackChecker= labyrinth.FighterAttackChecker;
 
        MapMaths MapManage = new MapMaths();

        switch (FighterMove) {
        case "Attack":
            System.out.println("The Fighter attacks!");
            if (MapManage.generateRandomZeroOne(20) == 0) {
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
            if (MapManage.generateRandomZeroOne(20) == 0) {
       
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
                if (MapManage.generateRandomZeroOne(40) == 1) {
                    
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