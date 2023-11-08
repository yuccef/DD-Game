package DrawTheMap;


import TheDragon.Dragon;
import TheFighter.FighterCaracter;

public class DragonActionAI {

    FighterCaracter Fighter ;
    Dragon Dragon;

    String FighterMove;
    
    public void DragonActionAI() {

        switch (this.FighterMove) {

            case "Attack":
                System.out.println("The Fighter attacks you!");
                Dragon.DragonDefense(Fighter, Dragon);

                //wait 3 secondes
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Dragon.DamageDragonFighterCaracter(Fighter, Dragon);
                

                break;
            case "defend":
                System.out.println("The Fighter defends!");

                //2 attacks
                Dragon.DamageDragonFighterCaracter(Fighter, Dragon);
                Dragon.DamageDragonFighterCaracter(Fighter, Dragon);
                Dragon.DragonDefense(Fighter, Dragon);
                break;

            case "run":
                System.out.println("The Fighter runs away!");
                break;
                
        }
    }
    
}
