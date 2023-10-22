package TheDragon;

import DrawTheMap.MapMaths;
import TheFighter.FighterCaracter;

public class Dragon {

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
    public Dragon(char nom, int initialScore, int initialDamage, int initialDefense) {
        name = String.valueOf(nom);
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
    }

    public void DamageDragonFighterCaracter(FighterCaracter Fighter, Dragon Dragon) {
        Fighter.score -= Dragon.damage;
        VarDamageDragon = 1;
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
