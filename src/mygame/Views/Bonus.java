package src.mygame.Views;

import javax.swing.*;

import java.util.Random;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;


import src.mygame.*;
import src.mygame.Utils.MapMaths;

public class Bonus {
    labyrinth labyrinthBonus;
    int[][] matrix ;
    int[][] matrixBonus;
    int[] indices = new int[4];



    public void Bonus(labyrinth labyrinth) {

        Random random = new Random();
        labyrinthBonus = labyrinth;
        matrix = labyrinthBonus.Lmatrix;
        matrixBonus = labyrinthBonus.Bmatrix;

        do {
            indices[0] = random.nextInt(20); // i
            indices[1] = random.nextInt(20); // j
            indices[2] = random.nextInt(20); // i1
            indices[3] = random.nextInt(20); // j1
        } while (matrix[indices[0]][indices[1]] != 0 || matrix[indices[2]][indices[3]] != 0);


        JPanel DrawTheBonus = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image Bonus = new ImageIcon("../Project/src/mygame/resource/Bonus.png").getImage();
                g.drawImage(Bonus, indices[0] ,indices[1] , this);
                g.drawImage(Bonus, indices[2] ,indices[3] , this);
        }             
    };






        }


    }


    

