package TheFighter;

import TheDragon.Dragon;
import DrawTheMap.labyrinth;
import DrawTheMap.MapMaths;


public class FighterCaracter {

    public int MATRIX_SIZE = 810;
    labyrinth labyrinth ;


   // public labyrinth labyrinth; // Suppose that Labyrinth is a class with public Bmatrix, xKnight, and yKnight
     int xFighter;
    public int yFighter;
    public int xDragon, yDragon;
    public char name;
    public int score;
    public int damage;
    public int defense;
    public int Close;

    public FighterCaracter( ) {
        //  this.labyrinth = labyrinth;
        //  this.xFighter = labyrinth.xKnight;
        //  this.yFighter = labyrinth.yKnight;
        //  this.name = nom;
        //  this.damage = initialDamage;
        //  this.defense = initialDefense;
        //  this.score = initialScore;
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

    public int FighterCaracterUpdateDealth( FighterCaracter Fighter) {
        if (Fighter.score <= 0) return  1;
        else return 0; 
    }

    public void lose(FighterCaracter Fighter) {
        if (FighterCaracterUpdateDealth(Fighter) == 1) {
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

    public int ActionCanWorks(FighterCaracter Fighter, Dragon Dragon,int [][] Bmatrix ,labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        if (xFighter-xDragon <= 40 && yFighter-yDragon <= 40) return Close = 1;
        else return Close = 0;
    }

    // public void FighterCaracterMove(int dx, int dy, int X, int Y , int [][] Bmatrix , labyrinth labyrinth) {
    //     this.labyrinth = labyrinth;
    //     int newX =X + dx * 5;
    //     int newY = Y + dy * 5;

    //     if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
    //         boolean canMove = true;
    //         for (int i = newX; i < newX + 40; i++) {
    //             for (int j = newY; j < newY + 40; j++) {
    //                 if (Bmatrix[i][j] == 1) { // If the Knight collides with a wall
    //                     canMove = false;
    //                     break;
    //                 }
    //             }
    //         }
    //         if (canMove) {
    //             X = newX;
    //             Y = newY;
    //             labyrinth.afficherImageKnight(labyrinth.imagePathsKnightRun[labyrinth.currentImageIndexKinghtRun]);
    //         }
    //     }
    // }
}
