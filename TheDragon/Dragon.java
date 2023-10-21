package TheDragon;

import TheFighter.FighterCaracter;

public class Dragon {

    // Liste des attributs
    public int x, y;
    public String name;
    public int score;
    public int damage;
    public int defense;
    public int death;


    // Liste des méthodes
    public Dragon(char nom, int initialScore, int initialDamage, int initialDefense) {
        name = String.valueOf(nom);
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
    }

    public void DamageDragonFighterCaracter(FighterCaracter Fighter, Dragon Dragon) {
        Fighter.score -= Dragon.damage;
    }

    public void DragonBlessed(FighterCaracter Fighter, Dragon Dragon) {
        Dragon.score -= Fighter.damage; ;
    }

    public void DragonDefense(FighterCaracter Fighter, Dragon Dragon) {
        Dragon.score -= Fighter.damage - Dragon.defense;
    }

    public void DragonUpdateDealth(Dragon Dragon) {
        if (Dragon.score <= 0) Dragon.death= 1;
            Dragon.death= 0; 
    }

    public void lose(Dragon Dragon) {
        if (Dragon.death == 1) {
            System.out.println("You win");
           // break;
        }
    }

    public static void main(String[] args) {

    }
}
