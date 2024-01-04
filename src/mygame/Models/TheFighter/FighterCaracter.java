////// il faut que j'utilise le pattern design de singeletton dans le fighter et
//  dans le dragon  afin d'eviter que deux instance se cree en meme temps 
//  (voire meme labyrinth)   .

// remarque il faut que je vois si ca marche avec le fait que la creation de l'ojet ne cange pas parcontre il faut que je change la vie a chaque fois 



package src.mygame.Models.TheFighter;

import src.mygame.Models.TheDragon.Dragon;
import src.mygame.Views.labyrinth;
import src.mygame.Views.winOrLose;
import src.mygame.Controllers.Sound;


public class FighterCaracter {





    private static FighterCaracter instanceFighter = null;


    public int yFighter ;
    public  int xFighter ;

    public int MATRIX_SIZE = 810;

    // Liste des attributs
    labyrinth labyrinth;

    public int damage;
    public String name;
    public int score;
    public int defense;
    public int Close;

    public Sound sound= new Sound();
    
    public int VarDefenseFighter=0;
    public int VarBlessedFighter=0;
    public int VarDamageFighter=0;
    
    
    // Liste des méthodes
    private FighterCaracter( String nom, int initialScore, int initialDamage, int initialDefense, int xFighter1, int yFighter1) {
        name = nom;
        score = initialScore;
        damage = initialDamage;
        defense = initialDefense;
        xFighter =xFighter1;
        yFighter =yFighter1;

    }
    public static FighterCaracter getHumanFighterInstance() {
         int  xFighter = 0;
        int   yFighter = 40;
        if (instanceFighter == null) {
            instanceFighter = new FighterCaracter( "Human ",   400, 30, 10, xFighter, yFighter);
        }
        return instanceFighter;

    }

    public static FighterCaracter getWitchFighterInstance() {
         int  xFighter = 0;
        int   yFighter = 40;
        if (instanceFighter == null) {
            instanceFighter =  new FighterCaracter( "Witch ",   400, 30, 10, xFighter, yFighter);
        }
            return instanceFighter;

    }
    
    public static FighterCaracter getPirateFighterInstance() {
         int  xFighter = 0;
        int   yFighter = 40;
        if (instanceFighter == null) {
            instanceFighter = new FighterCaracter( "Knight ",   400, 30, 10, xFighter, yFighter);
        }
        return instanceFighter;

    }

    public void DamageFighterCaracterTheDragon(FighterCaracter Fighter, Dragon Dragon) {
        if(Dragon.score > 30){
        Dragon.score -= Fighter.damage;
        VarDamageFighter = 1;
        }
        else{
            Dragon.score = 0;
            System.out.println("You win");
            sound.playSound(1);
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
            sound.playSound(3);
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
