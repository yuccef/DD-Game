package src.mygame.Models.TheDragon;

import src.mygame.Models.TheFighter.FighterCaracter;
import src.mygame.Views.winOrLose;

public class Dragon {


    public  static  Dragon instanceDragon = null;


    // Liste des attributs
    public int xDragon, yDragon;
    public String name;
    public int score;
    public int damage;
    public int defense;
    public int death;

    

    public int VarDefenseDragon = 0;
    public int VarBlessedDragon = 0;
    public int VarDamageDragon = 0;


    // Liste des méthodes
    private Dragon(String nom, int initialScore, int initialDamage, int initialDefense, int xDragon1, int yDragon1) {
        xDragon = xDragon1;
        yDragon = yDragon1;
        name =nom;
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
    }

    public static Dragon getDragonEasyLevel() {
              int xDragon = 720;
         int yDragon = 520;
       if (instanceDragon == null) {
           instanceDragon = new Dragon("Emberclaw", 400, 20, 20, xDragon, yDragon);
       }
       return instanceDragon;

   }

    public static Dragon getDragonMediumLevel() {
               int xDragon = 720;
         int yDragon = 520;
       if (instanceDragon == null) {
           instanceDragon =new Dragon("Stormwing", 500, 40, 20, xDragon, yDragon);
       }
       return instanceDragon;

    }

    public static Dragon getDragonHardLevel() {
         int xDragon = 720;
         int yDragon = 520;
       if (instanceDragon == null) {
           instanceDragon =new Dragon("Obsidianheart", 600, 60, 20, xDragon, yDragon);
       }
       return instanceDragon;

    }









    public void DamageDragonFighterCaracter(FighterCaracter Fighter, Dragon Dragon) {
        if(Fighter.score > 0){
        Fighter.score -= Dragon.damage;
        VarDamageDragon = 1;
        }else{
            Fighter.score = 0;
            System.out.println("You lose");

        }
    }

    public void DragonDefense(FighterCaracter Fighter, Dragon Dragon) {
        Dragon.score -= Fighter.damage - Dragon.defense;
        VarDefenseDragon = 1;
    }

    public void DragonUpdateDealth(Dragon Dragon) {
        if (Dragon.score <= 0) Dragon.death= 1;
            Dragon.death= 0; 
    }

    public void lose(Dragon Dragon) {
        if (Dragon.death == 1) {
            System.out.println("You win");
                        new winOrLose();

        }
    }

    public int ActionCanWorksDragon(FighterCaracter Fighter, Dragon Dragon) {
        
        if (Fighter.xFighter == Dragon.xDragon && Fighter.yFighter == Dragon.yDragon) {
            return 1;
        }
        else return 0;
    }

    public void DragonandFighter(FighterCaracter Fighter, Dragon Dragon) {

    if(ActionCanWorksDragon(Fighter, Dragon) == 1){
        if (Dragon.VarDamageDragon == 1 && Fighter.VarDefenseFighter == 0) {
            Dragon.DamageDragonFighterCaracter(Fighter, Dragon);
            Dragon.VarDamageDragon = 0;
        }
        if (Fighter.VarDefenseFighter == 1 && Dragon.VarDamageDragon == 1) {
            Dragon.DragonDefense(Fighter, Dragon);
            Fighter.VarDefenseFighter = 0;
        }
    }
    }

}
