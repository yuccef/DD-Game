package TheFighter;

import DrawTheMap.labyrinth;
import TheDragon.Dragon;

public class FighterCaracter {

    public int MATRIX_SIZE = 810;

    // Liste des attributs
    labyrinth labyrinth;

    public int xFighter;
    public int yFighter;
    public char name;
    public int score;
    public int damage;
    public int defense;
    public int Close;

    public int VarDefenseFighter=0;
    public int VarBlessedFighter=0;
    public int VarDamageFighter=0;

  
    // Liste des méthodes
    public FighterCaracter(labyrinth labyrinth, char nom, int initialScore, int initialDamage, int initialDefense) {
        name = nom;
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
        xFighter = labyrinth.xFighter;
        yFighter = labyrinth.yFighter;
        this.labyrinth = labyrinth;

    }

    public void DamageFighterCaracterTheDragon(FighterCaracter Fighter, Dragon Dragon) {
        Dragon.score -= Fighter.damage;
        VarDamageFighter = 1;
    }

    public void FighterDefense(FighterCaracter Fighter, Dragon Dragon) {
        Fighter.score = Dragon.damage - Fighter.defense;
        VarDefenseFighter = 1;
    }

    public int FighterCaracterUpdateDealth(FighterCaracter Fighter) {
        if (Fighter.score <= 0) return 1;
        else return 0;
    }

    public void lose(FighterCaracter Fighter) {
        if (FighterCaracterUpdateDealth(Fighter) == 1) {
            System.out.println("You lose");
            // break;
        }
    }

    public void BonusLife(FighterCaracter Fighter) {
        if (Fighter.score <= 49) {
            Fighter.score += 20;
        }
        if (Fighter.score >= 100) {
            Fighter.score = 100;
        }
    }

    public int ActionCanWorks(FighterCaracter Fighter, Dragon Dragon) {
        if (xFighter - Dragon.xDragon <= 40 && yFighter - Dragon.yDragon <= 40) return Close = 1;
        else return Close = 0;
    }

    public void FighterCaracterMove(int dx, int dy, int X, int Y) {
        int newX = X + dx * 5;
        int newY = Y + dy * 5;

        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (labyrinth.Bmatrix[i][j] == 1) { // If the Knight collides with a wall
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                X = newX;
                Y = newY;
                labyrinth.ShowFighter(labyrinth.imagePathsFighterRun[labyrinth.currentImageIndexFighterRun]);
            }
        }
    }

    public void FitherAndDragon(FighterCaracter Fighter, Dragon Dragon) {
        if (ActionCanWorks(Fighter, Dragon) == 1) {
            if (VarDamageFighter == 1 && Dragon.VarDefenseDragon == 0) {
                DamageFighterCaracterTheDragon(Fighter, Dragon);
                VarDamageFighter = 0;
            }
            if (VarDamageFighter == 1 && Dragon.VarDefenseDragon == 1) {
                FighterDefense(Fighter, Dragon);
                VarDamageFighter = 0;
            }
           
        }
    }


}
