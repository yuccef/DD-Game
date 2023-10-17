import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class labyrinth {

    Image image;
    Image imageStep;
    private JFrame fenetre;
    private int[][] matrix;
    
        private int xKnight = 320;
        private int yKnight = 0;
        private int  xx,yy;
        private JLabel characterLabel;
    
    public String[] imagePathsKnightRun = {
        "../project/CharactersMvmnt/KnightMvmnt/run1.png",
        "../project/CharactersMvmnt/KnightMvmnt/run2.png",
        "../project/CharactersMvmnt/KnightMvmnt/run3.png",
        "../project/CharactersMvmnt/KnightMvmnt/run4.png",
        "../project/CharactersMvmnt/KnightMvmnt/run5.png",
        "../project/CharactersMvmnt/KnightMvmnt/run6.png",
        "../project/CharactersMvmnt/KnightMvmnt/run7.png",
        "../project/CharactersMvmnt/KnightMvmnt/run8.png"
    };
    
    public String[] imagePathsKnightRunInverse = {
        "../project/CharactersMvmnt/KnightMvmnt/run11.png",
        "../project/CharactersMvmnt/KnightMvmnt/run22.png",
        "../project/CharactersMvmnt/KnightMvmnt/run33.png",
        "../project/CharactersMvmnt/KnightMvmnt/run44.png",
        "../project/CharactersMvmnt/KnightMvmnt/run55.png",
        "../project/CharactersMvmnt/KnightMvmnt/run66.png",
        "../project/CharactersMvmnt/KnightMvmnt/run77.png",
        "../project/CharactersMvmnt/KnightMvmnt/run88.png"
    };

    public String[] imagePathsKnightAttack = {
        "../project/CharactersMvmnt/KnightMvmnt/KnightAttack1.png",
        "../project/CharactersMvmnt/KnightMvmnt/KnightAttack2.png",
         "../project/CharactersMvmnt/KnightMvmnt/KnightAttack3.png",
         "../project/CharactersMvmnt/KnightMvmnt/KnightAttack4.png",
    };


    public String[] imagePathsKnightDefense = {
        "../project/CharactersMvmnt/KnightMvmnt/KnightDefense.png",
        "../project/CharactersMvmnt/KnightMvmnt/KnightDefense2.png",
        "../project/CharactersMvmnt/KnightMvmnt/KnightDefense3.png",
    };

    private int currentImageIndexKinghtRun = 0;
 
    public labyrinth() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 810);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel characterPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image image = new ImageIcon("../project/MapPixels/labyrinth1.jpg").getImage();
                Image mageTEST = new ImageIcon("../project/MapPixels/labyrinth2.jpg").getImage();
                matrix = new int[810][810];



            for (int y = 0; y < 810; y += 40) {
                    for (int x = 0; x < 810; x += 40) {                        
                        g.drawImage(image, x, y, this);
                    }
                }
            for (int i = 0; i < 810; i++) {
                    for (int j = 0; j < 810; j++) {
                        matrix[j][i] = 0;
                    }
                }

            for (int y = 0; y < 810; y += 80) {
                for (int x = 0; x < 810; x += 40) {
                        g.drawImage(mageTEST, x, y, this);      
                }
            }

            for (int i = 0; i < 770; i+=80) {
                    for (int j = 0; j < 770; j+=40) {
                            matrix[j][i] = 1;    
                    }
                }

            


            for(int i=0; i < 770; i++){
                    for(int j=0; j < 770; j++){
                        if(matrix[j][i] == 1){
                                matrix[j][i+40] = 1;
                                matrix[j+40][i] = 1;
                                matrix[j+40][i+40] = 1;
                        }
                    }
                }


            g.drawImage(image, 320 , 0, this);
            fillMatrixbyZero(0,320);

            g.drawImage(image, 440 , 80, this);
            fillMatrixbyZero(80,440);


            g.drawImage(image, 160 , 80, this);
            fillMatrixbyZero(80,160);


            g.drawImage(image, 40 , 80, this);
            fillMatrixbyZero(80,40);
       

            g.drawImage(image, 717 , 80, this);
            fillMatrixbyZero(80,717);


            g.drawImage(image, 40 , 160, this);
            g.drawImage(image, 240 , 160, this);
            g.drawImage(image, 120 , 160, this);
            g.drawImage(image, 160 , 160, this);
            g.drawImage(image, 200 , 160, this);
            g.drawImage(image, 320 , 160, this);
            g.drawImage(image, 360 , 160, this);
            g.drawImage(image, 717 , 160, this);

            fillMatrixbyZero(160,40);
            fillMatrixbyZero(160,240);
            fillMatrixbyZero(160,120);
            fillMatrixbyZero(160,160);
            fillMatrixbyZero(160,200);
            fillMatrixbyZero(160,320);
            fillMatrixbyZero(160,360);
            fillMatrixbyZero(160,717);
  

            g.drawImage(image, 400 , 320, this);
            g.drawImage(image, 40 , 320, this);

            fillMatrixbyZero(320,40);
            fillMatrixbyZero(320,400);

            g.drawImage(image, 40 , 400, this);
            g.drawImage(image, 597 , 400, this);

            fillMatrixbyZero(400,40);
            fillMatrixbyZero(400,597);

            g.drawImage(image, 240 , 480, this);

            fillMatrixbyZero(480,240);

            g.drawImage(image, 557 , 240, this);
            g.drawImage(image, 40 , 240, this);
            g.drawImage(image, 120 , 240, this);
            g.drawImage(image, 200 , 240, this);
            g.drawImage(image, 240 , 240, this);

            fillMatrixbyZero(240,557);
            fillMatrixbyZero(240,40);
            fillMatrixbyZero(240,120);
            fillMatrixbyZero(240,200);
            fillMatrixbyZero(240,240);

            g.drawImage(mageTEST, 757 , 120, this);
            fillMatrixbyOne(120, 757);

            g.drawImage(mageTEST, 0 , 120, this);
            fillMatrixbyOne(120, 0);

            g.drawImage(mageTEST, 677 , 120, this);
            fillMatrixbyOne(120, 677);

            g.drawImage(mageTEST, 80 , 120, this);
            fillMatrixbyOne(120, 80);

            g.drawImage(mageTEST, 280 , 120, this);
            fillMatrixbyOne(120, 280);

            g.drawImage(mageTEST, 757 , 40, this);
            fillMatrixbyOne(40, 757);

            g.drawImage(mageTEST, 0 , 40, this);
            fillMatrixbyOne(40, 0);

            g.drawImage(mageTEST, 120 , 40, this);
            fillMatrixbyOne(40, 120);

            g.drawImage(mageTEST, 0 , 200, this);
            fillMatrixbyOne(200, 0);

            g.drawImage(mageTEST, 757 , 200, this);
            fillMatrixbyOne(200, 757);

            g.drawImage(mageTEST, 80 , 200, this);
            fillMatrixbyOne(200, 80);

            g.drawImage(mageTEST, 280 , 200, this);
            fillMatrixbyOne(200, 280);

            g.drawImage(mageTEST, 757 , 280, this);
            fillMatrixbyOne(280, 757);

            g.drawImage(mageTEST, 0 , 280, this);
            fillMatrixbyOne(280, 0);

            g.drawImage(mageTEST, 360 , 280, this);
            fillMatrixbyOne(280, 360);

            g.drawImage(mageTEST, 160 , 280, this);
            fillMatrixbyOne(280, 160);

            g.drawImage(mageTEST, 757 , 360, this);
            fillMatrixbyOne(360, 757);

            g.drawImage(mageTEST, 0 , 360, this);
            fillMatrixbyOne(360, 0);

            g.drawImage(mageTEST, 80 , 360, this);
            fillMatrixbyOne(360, 80);

            g.drawImage(mageTEST, 757 , 440, this);
            fillMatrixbyOne(440, 757);

            g.drawImage(mageTEST, 0 , 440, this);
            fillMatrixbyOne(440, 0);

            g.drawImage(mageTEST, 200 , 440, this);
            fillMatrixbyOne(440, 200);

            g.drawImage(mageTEST, 717 , 440, this);
            fillMatrixbyOne(440, 717);

            g.drawImage(mageTEST, 677 , 440, this);
            fillMatrixbyOne(440, 677);

            g.drawImage(mageTEST, 637 , 440, this);
            fillMatrixbyOne(440, 637);

            g.drawImage(mageTEST, 0 , 520, this);
            fillMatrixbyOne(520, 0);
        
            g.drawImage(mageTEST, 160 , 240, this);
            fillMatrixbyOne(240, 160);
   
        }
    };

        characterPanel.setPreferredSize(new Dimension(810, 650));
        characterPanel.setBounds(0, 0, 810, 650);
        fenetre.setSize(new Dimension(810, 650));
        fenetre.setResizable(false);
        fenetre.add(characterPanel);
        characterPanel.setLayout(null); // Set layout to null to position the character precisely


        characterLabel = new JLabel();
        characterPanel.add(characterLabel);
        characterLabel.setBounds(xKnight, yKnight, 40, 40);


                Timer timerKnightRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKinghtRun = (currentImageIndexKinghtRun + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timerKnightRun.start();


        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
           xx = xKnight;    
           yy = yKnight;  
           
           if(matrix[xx][yy] == 1){

             //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {       //Right knight
                    xKnight = xx+5;
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    fenetre.repaint();

                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {        //Left knight
                    xKnight = xx-5; 
                    afficherImageKnight(imagePathsKnightRunInverse[currentImageIndexKinghtRun]); 
                     fenetre.repaint();
                }   

                if (e.getKeyCode() == KeyEvent.VK_UP) {          //Up knight
                    yKnight = yy+5; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
                    fenetre.repaint();
                }


                if (e.getKeyCode() == KeyEvent.VK_DOWN) {        //Down knight
                    yKnight = yy-5; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                                        fenetre.repaint();
                } 
            

           }
                
        if(matrix[xx][yy] == 0){
               //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {       //Right knight
                    xKnight += 5;
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    fenetre.repaint();

                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {        //Left knight
                    xKnight -= 5; 
                    afficherImageKnight(imagePathsKnightRunInverse[currentImageIndexKinghtRun]); 
                     fenetre.repaint();


                }   

                if (e.getKeyCode() == KeyEvent.VK_UP) {          //Up knight
                    yKnight -= 5; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
                    fenetre.repaint();
                    

                }


                if (e.getKeyCode() == KeyEvent.VK_DOWN) {        //Down knight
                    yKnight += 5; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                                        fenetre.repaint();



                } 
            }
            } 
                @Override
                public void keyReleased(KeyEvent e) {
                    // Do nothing here, as we are not using keyReleased
                }
            });
                


        fenetre.setVisible(true);


    }

    private void afficherImageKnight(String nomImage) {
        // for(int i = 0; i < 810; i++){
        //     for(int j = 0; j < 810; j++){
        //         System.out.print(matrix[i][j]);
        //     }
        //     System.out.println();
        // }
        ImageIcon imageIcon = new ImageIcon(nomImage);
        characterLabel.setIcon(imageIcon);
        characterLabel.setBounds(xKnight, yKnight, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        characterLabel.repaint(); // Repaint the label to show the updated position
    }

  public void ModifyMatrix(int x, int y){
        matrix[x][y] = 1;
        matrix[x+40][y] = 1;
        matrix[x][y+40] = 1;
        matrix[x+40][y+40] = 1;
    }

public void fillMatrixbyZero(int x, int y){
 
    for(int k = 0; k < 40; k++){
        matrix[x][y+k] = 0;
        matrix[x+k][y] = 0;
        
    }

}

public void fillMatrixbyOne(int x, int y){
 
    for(int k = 0; k < 40; k++){
        matrix[x][y+k] = 1;
        matrix[x+k][y] = 1;
        
    }

}
    public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new labyrinth();
            }
        });
}
}
