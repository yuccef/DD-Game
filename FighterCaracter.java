
public class FighterCaracter { 


public int x,y;
public char name;
public int score;
public int damage;
public int defense;
public int death;
    
    public FighterCaracter(char nom ,int initialScore, int initialDamage, int initialDefense) {
        name = nom;
        damage = initialDamage;
        defense = initialDefense;
        score = initialScore;
    }

    public void DamageFighterCaracterTheDragon(FighterCaracter Fighter, Dragon Dragon) {
        Dragon.score -= Fighter.damage;
    }

    public void FighterCaracterBlessed(FighterCaracter Fighter, Dragon Dragon) {
        Fighter.score -= Dragon.damage; ;
    }
    
    public void FighterDefense(FighterCaracter Fighter, Dragon Dragon) {
        Fighter.score -= Dragon.damage - Fighter.defense;
    }

    public void FighterCaracterUpdateDealth( FighterCaracter Fighter) {
        if (Fighter.score <= 0) Fighter.death= 1;
            Fighter.death= 0; 
    }

    public void lose(FighterCaracter Fighter) {
        if (Fighter.death == 1) {
            System.out.println("You lose");
           // break;
        }
    }

    public void BonusLife(FighterCaracter Fighter) {
        if(Fighter.score <= 49) {
            Fighter.score += 20;
        }
        if (Fighter.score >= 100) {
            Fighter.score = 100;
        }
    }
}
