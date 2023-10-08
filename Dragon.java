public class Dragon {
    public int score;

    public Dragon(int initialScore) {
        score = initialScore;
    }

    public void attack(KnightCaracter knight) {
        knight.damage(this);
    }

    // Ajoutez d'autres méthodes et champs au besoin

    public static void main(String[] args) {
        KnightCaracter knight = new KnightCaracter(100); // Exemple d'initialisation du chevalier
        Dragon dragon = new Dragon(200); // Exemple d'initialisation du dragon

        dragon.attack(knight); // Le dragon attaque le chevalier
        System.out.println("Chevalier: Score = " + knight.score);
        System.out.println("Dragon: Score = " + dragon.score);
    }
}

