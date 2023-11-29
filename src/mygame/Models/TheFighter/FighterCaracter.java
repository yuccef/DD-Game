package src.mygame.Models.TheFighter;

import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Views.labyrinth;
import src.mygame.Views.winOrLose;


public class FighterCaracter {

    public int MATRIX_SIZE = 810;

    // Liste des attributs
    labyrinth labyrinth;

    public int xFighter;
    public int yFighter;
    public int damage;
    public String name;
    public int score;
    public int defense;
    public int Close;
    
    public int VarDefenseFighter=0;
    public int VarBlessedFighter=0;
    public int VarDamageFighter=0;
    
    
    // Liste des méthodes
    public FighterCaracter( String nom, int initialScore, int initialDamage, int initialDefense, int xFighter1, int yFighter1) {
        name = nom;
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
        xFighter =xFighter1;
        yFighter =yFighter1;

    }

    public void DamageFighterCaracterTheDragon(FighterCaracter Fighter, Dragon Dragon) {
        if(Dragon.score > 30){
        Dragon.score -= Fighter.damage;
        VarDamageFighter = 1;
        }
        else{
            Dragon.score = 0;
            System.out.println("You win");
                        new winOrLose();

        }
    }

    public void FighterDefense(FighterCaracter Fighter, Dragon Dragon) {
        Fighter.score -= Dragon.damage - Fighter.defense;
        VarDefenseFighter = 1;
    }

    public int FighterCaracterUpdateDealth(FighterCaracter Fighter) {
        if (Fighter.score <= 0) return 1;
        else return 0;
    }

    public void lose(FighterCaracter Fighter) {
        if (FighterCaracterUpdateDealth(Fighter) == 1) {
            System.out.println("You lose");
            new winOrLose();

            // break;
        }
    }

    public void BonusLife(FighterCaracter Fighter) {
            Fighter.score += 20;
        
    
    }

    public int ActionCanWorks(FighterCaracter Fighter, Dragon Dragon) {
        if (Fighter.xFighter - Dragon.xDragon <= 40 && Fighter.yFighter - Dragon.yDragon <= 40) return Close = 1;
        else return Close = 0;
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
