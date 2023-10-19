
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

    public void DamageFighterCaracter(FighterCaracter Fighter) {
        Fighter.score -= damage;
    }

    public void FighterCaracterAttack(FighterCaracter Fighter, Dragon Dragon) {
        DamageFighterCaracter(Fighter);
    }



    public void FighterCaracterDealth() {
        if (score <= 0) death= 1;
            death= 0; 
    }


}
