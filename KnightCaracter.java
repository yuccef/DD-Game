

public class KnightCaracter { // Renommez la classe en "KnightCharacter"

    public int damage; // Corrigez le nom de la variable "dammage" en "damage"
    public int score;
    public int recup;

    public KnightCaracter(int initialScore) { // Ajoutez un constructeur
        score = initialScore;
    }

    public void bless(int k) { // Corrigez le nom de la méthode "blessed" en "bless" et ajoutez le mot-clé "public"
        score -= k;
    }

    public int death() {
        if (score <= 0) {
            return 1;
        } else {
            return 0; // Assurez-vous de retourner une valeur pour le cas où score > 0
        }
    }

    public void damage(Dragon dragon) { // Corrigez le nom de la méthode "Dammage" en "damage" et la signature du paramètre
        dragon.score -= damage;
    }

    // Ajoutez d'autres méthodes et champs au besoin

}
