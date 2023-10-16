import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                        matrix[i][j] = 0;
                    }
                }
            for (int y = 0; y < 810; y += 80) {
                for (int x = 0; x < 810; x += 40) {
                        g.drawImage(mageTEST, x, y, this);
                    
                }
            }
                for (int i = 0; i < 810; i+=80) {
                    for (int j = 0; j < 810; j+=40) {
                        matrix[i][j] = 1;
                    }
                }



            g.drawImage(image, 320 , 0, this);
            matrix[320][0] = 0;

            g.drawImage(image, 440 , 80, this);
            matrix[440][80] = 0;

            g.drawImage(image, 160 , 80, this);
            matrix[160][80] = 0;

            g.drawImage(image, 40 , 80, this);
            matrix[40][80] = 0;

            g.drawImage(image, 717 , 80, this);
            matrix[717][80] = 0;


            g.drawImage(image, 40 , 160, this);
            g.drawImage(image, 240 , 160, this);
            g.drawImage(image, 120 , 160, this);
            g.drawImage(image, 160 , 160, this);
            g.drawImage(image, 200 , 160, this);
            g.drawImage(image, 320 , 160, this);
            g.drawImage(image, 360 , 160, this);
            g.drawImage(image, 717 , 160, this);

            matrix[40][160] = 0;
            matrix[240][160] = 0;
            matrix[120][160] = 0;
            matrix[160][160] = 0;
            matrix[200][160] = 0;
            matrix[320][160] = 0;
            matrix[360][160] = 0;
            matrix[717][160] = 0;




            g.drawImage(image, 400 , 320, this);
            g.drawImage(image, 40 , 320, this);

            matrix[400][320] = 0;
            matrix[40][320] = 0;

            g.drawImage(image, 40 , 400, this);
            g.drawImage(image, 597 , 400, this);

            matrix[40][400] = 0;
            matrix[597][400] = 0;

            g.drawImage(image, 240 , 480, this);

            matrix[240][480] = 0;

            g.drawImage(image, 557 , 240, this);
            g.drawImage(image, 40 , 240, this);
            g.drawImage(image, 120 , 240, this);
            g.drawImage(image, 200 , 240, this);
            g.drawImage(image, 240 , 240, this);

            matrix[557][240] = 0;
            matrix[40][240] = 0;
            matrix[120][240] = 0;
            matrix[200][240] = 0;
            matrix[240][240] = 0;


            g.drawImage(mageTEST, 757 , 120, this);
            g.drawImage(mageTEST, 0 , 120, this);
            g.drawImage(mageTEST, 677 , 120, this);
            g.drawImage(mageTEST, 80 , 120, this);
            g.drawImage(mageTEST, 280 , 120, this);

            matrix[757][120] = 1;
            matrix[0][120] = 1;
            matrix[677][120] = 1;
            matrix[80][120] = 1;
            matrix[280][120] = 1;


            g.drawImage(mageTEST, 757 , 40, this);
            g.drawImage(mageTEST, 0 , 40, this);
            g.drawImage(mageTEST, 120 , 40, this);

            matrix[757][40] = 1;
            matrix[0][40] = 1;
            matrix[120][40] = 1;


            g.drawImage(mageTEST, 0 , 200, this);
            g.drawImage(mageTEST, 757 , 200, this);
            g.drawImage(mageTEST, 80 , 200, this);
            g.drawImage(mageTEST, 280 , 200, this);

            matrix[0][200] = 1;
            matrix[757][200] = 1;
            matrix[80][200] = 1;
            matrix[280][200] = 1;


            g.drawImage(mageTEST, 757 , 280, this);
            g.drawImage(mageTEST, 0 , 280, this);
            g.drawImage(mageTEST, 360 , 280, this);
            g.drawImage(mageTEST, 160 , 280, this);

            matrix[757][280] = 1;
            matrix[0][280] = 1;
            matrix[360][280] = 1;
            matrix[160][280] = 1;


            g.drawImage(mageTEST, 757 , 360, this);
            g.drawImage(mageTEST, 0 , 360, this);
            g.drawImage(mageTEST, 80 , 360, this);

            matrix[757][360] = 1;
            matrix[0][360] = 1;
            matrix[80][360] = 1;

            g.drawImage(mageTEST, 757 , 440, this);
            g.drawImage(mageTEST, 0 , 440, this);
            g.drawImage(mageTEST, 200 , 440, this);
            g.drawImage(mageTEST, 200 , 440, this);
            g.drawImage(mageTEST, 717 , 440, this);
            g.drawImage(mageTEST, 677 , 440, this);
            g.drawImage(mageTEST, 637 , 440, this);
            g.drawImage(mageTEST, 0 , 520, this);
            g.drawImage(mageTEST, 160 , 240, this);

            matrix[757][440] = 1;
            matrix[0][440] = 1;
            matrix[200][440] = 1;
            matrix[200][440] = 1;
            matrix[717][440] = 1;
            matrix[677][440] = 1;
            matrix[637][440] = 1;
            matrix[0][520] = 1;
            matrix[160][240] = 1;
                










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
                    xKnight = xKnight-10;
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    fenetre.repaint();

                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {        //Left knight
                    xKnight = xKnight+10; 
                    afficherImageKnight(imagePathsKnightRunInverse[currentImageIndexKinghtRun]); 
                     fenetre.repaint();
                }   

                if (e.getKeyCode() == KeyEvent.VK_UP) {          //Up knight
                    yKnight = yKnight+10; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
                    fenetre.repaint();
                }


                if (e.getKeyCode() == KeyEvent.VK_DOWN) {        //Down knight
                    yKnight = yKnight-10; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                                        fenetre.repaint();
                } 
            

           }
                
        if(matrix[xx][yy] == 0){
               //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {       //Right knight
                    xKnight += 10;
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    fenetre.repaint();

                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {        //Left knight
                    xKnight -= 10; 
                    afficherImageKnight(imagePathsKnightRunInverse[currentImageIndexKinghtRun]); 
                     fenetre.repaint();


                }   

                if (e.getKeyCode() == KeyEvent.VK_UP) {          //Up knight
                    yKnight -= 10; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
                    fenetre.repaint();
                    

                }


                if (e.getKeyCode() == KeyEvent.VK_DOWN) {        //Down knight
                    yKnight += 10; 
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
        ImageIcon imageIcon = new ImageIcon(nomImage);
        characterLabel.setIcon(imageIcon);
        characterLabel.setBounds(xKnight, yKnight, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        characterLabel.repaint(); // Repaint the label to show the updated position

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(labyrinth::new);
    }
}
