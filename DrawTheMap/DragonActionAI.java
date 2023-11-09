package DrawTheMap;


import TheDragon.Dragon;
import TheFighter.FighterCaracter;

class  DragonActionAI {

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
            System.out.println("The Fighter runs away!");
            if (FighterAttackChecker == 1) {
                FighterAttackChecker = 0;
                if (MapManage.generateRandomZeroOne(80) == 1) {
                    CharactersMovesManage.moveAttack(2,labyrinth);
                }
            }
            break;
    }


            
    }
    
}