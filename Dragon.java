public class Dragon {

    // Liste des attributs
    public int x, y;
    public String name;
    public int score;
    public int damage;
    public int defense;


    // Liste des méthodes
    public Dragon(char nom, int initialScore, int initialDamage, int initialDefense) {
        name = String.valueOf(nom);
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
    }

    public void damageDragon(FighterCaracter fighter) { 
        fighter.score -= damage;
    }

    public void dragonAttack(FighterCaracter fighter) { 
        damageDragon(fighter);
    }

    public int deathDragon() {
        if (score <= 0) {
            return 1;
        } else {
            return 0;
        }
    }



    public static void main(String[] args) {

    }
}
