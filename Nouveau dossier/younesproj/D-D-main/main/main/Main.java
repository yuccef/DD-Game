package main;

import javax.swing.JFrame;

public class Main{

    public static void main(String agrs[]){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Donjons & Dragons");

        GamePannel gamePannel = new GamePannel();
        window.add(gamePannel);
        window.addKeyListener(gamePannel.keyHandler);

        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //GameStart frame = new GameStart();
        
    }
}