import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class AllCharactersMvmntghita {

    private int xKnight = 325;
    private int yKnight = 570;

    private int xKnight1, yKnight1, xknight2,yKnight2;
    
    public JPanel DicePaneltest; 

    
    private JFrame fenetre;
    //private JPanel characterPanel;

    private JLabel characterLabel;
    private JLabel nextImageLabel;
    private JLabel nextImageLabel1;
    private JLabel nextImageLabel2;
    private JLabel nextImageLabel3;


    public String[] imageNext= {
    		"/home/ghita/Téléchargements/yuccef2/DD-Game-main/MapPixels/step3.jpg"	
    };
   
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


    public String[] imagePathsWitchRun = {
        "../project/CharactersMvmnt/WitchMvmnt/run1.png",
        "../project/CharactersMvmnt/WitchMvmnt/run2.png",
        "../project/CharactersMvmnt/WitchMvmnt/run3.png",
        "../project/CharactersMvmnt/WitchMvmnt/run4.png",
        "../project/CharactersMvmnt/WitchMvmnt/run5.png",
        "../project/CharactersMvmnt/WitchMvmnt/run6.png",
        "../project/CharactersMvmnt/WitchMvmnt/run7.png",
        "../project/CharactersMvmnt/WitchMvmnt/run8.png"
    };

    public String[] imagePathsWitchRunInverse = {
        "../project/CharactersMvmnt/WitchMvmnt/run11.png",
        "../project/CharactersMvmnt/WitchMvmnt/run22.png",
        "../project/CharactersMvmnt/WitchMvmnt/run33.png",
        "../project/CharactersMvmnt/WitchMvmnt/run44.png",
        "../project/CharactersMvmnt/WitchMvmnt/run55.png",
        "../project/CharactersMvmnt/WitchMvmnt/run66.png",
        "../project/CharactersMvmnt/WitchMvmnt/run77.png",
        "../project/CharactersMvmnt/WitchMvmnt/run88.png"
    };

    public String[] imagePathsWitchAttack = {
        "../project/CharactersMvmnt/WitchMvmnt/attack1.png",
        "../project/CharactersMvmnt/WitchMvmnt/attack2.png",
        "../project/CharactersMvmnt/WitchMvmnt/attack3.png",
        "../project/CharactersMvmnt/WitchMvmnt/attac4.png",
        "../project/CharactersMvmnt/WitchMvmnt/attac5.png",
        "../project/CharactersMvmnt/WitchMvmnt/attac6.png",
        "../project/CharactersMvmnt/WitchMvmnt/attack7.png",
    };

    public String[] imagePathsPirateRun = {
        "../project/CharactersMvmnt/PirateMvmnt/run1.png",
        "../project/CharactersMvmnt/PirateMvmnt/run2.png",
        "../project/CharactersMvmnt/PirateMvmnt/run3.png",
        "../project/CharactersMvmnt/PirateMvmnt/run4.png",
        "../project/CharactersMvmnt/PirateMvmnt/run5.png",
        "../project/CharactersMvmnt/PirateMvmnt/run6.png",
        "../project/CharactersMvmnt/PirateMvmnt/run7.png",
    };


    public String[] imagePathsPirateAttack = {
         "../project/CharactersMvmnt/PirateMvmnt/attack1.png",
         "../project/CharactersMvmnt/PirateMvmnt/attack2.png",
         "../project/CharactersMvmnt/PirateMvmnt/attack3.png",
         "../project/CharactersMvmnt/PirateMvmnt/attack4.png",
         "../project/CharactersMvmnt/PirateMvmnt/attack5.png",
         "../project/CharactersMvmnt/PirateMvmnt/attack6.png",
         "../project/CharactersMvmnt/PirateMvmnt/attack7.png",
    };



    private int currentImageIndexKinghtRun = 0;
    private int currentImageIndexKnightAttack = 0;
    private int currentImageIndexKnightDefense = 0;
    
    public AllCharactersMvmntghita() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 700);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel imageNextPanel = new JPanel() {
        	  @Override
              public void paintComponent(Graphics g) {
                  super.paintComponent(g);
                Image image = new ImageIcon("../project/MapPixels/3.jpg").getImage();
                 
                // Draw the image as the background
                  for (int y = 50; y < 750; y += 50) {
                      for (int x = 0; x < 750; x += 50) {
                      g.drawImage(image, x, y, this);
                      }}//; 
              
                      int kx1 = 100 + xKnight;
                      xKnight1 = kx1;

                      int kx2 = xKnight - 100;
                      xknight2 = kx2;

                      int ky1 = 100 + yKnight;
                      yKnight1 = ky1;

                      int ky2 = yKnight - 100;
                      yKnight2 = ky2;

                  

              }
        };
        JPanel characterPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
              Image image = new ImageIcon("../project/MapPixels/3.jpg").getImage();
               
              // Draw the image as the background
                for (int y = 50; y < 750; y += 50) {
                    for (int x = 0; x < 750; x += 50) {
                    g.drawImage(image, x, y, this);
                    }}//; 
                
             

                   Random randomPixel4 = new Random();

                    int xk=xKnight+50;
                    int yk=yKnight;

                    int kx1 = randomPixel4.nextInt(601 - xk ) + xk + 50 ;
                    int kx2 = randomPixel4.nextInt(xk + 1 + 50)  ;   


                    int ky1 = randomPixel4.nextInt(601 - yk) + yk + 50;
                    int ky2 = randomPixel4.nextInt(yk + 51 );
                  
                    afficherImageNext(xk, ky1, xk, ky2, kx1 , yk, kx2, yk);


            }
        };

        characterPanel.setPreferredSize(new Dimension(650, 650));
        characterPanel.setBounds(50, 0, 650, 650);
        fenetre.setSize(new Dimension(650, 650));
        fenetre.setResizable(false);
        fenetre.add(characterPanel);
        fenetre.add(imageNextPanel);
    
        imageNextPanel.setVisible(true);
        characterPanel.setVisible(true);
        
        characterPanel.setLayout(null); // Set layout to null to position the character precisely
        imageNextPanel.setLayout(null); // Set layout to null to position the character precisely
        
        characterLabel = new JLabel();
        nextImageLabel= new JLabel();
        nextImageLabel1= new JLabel();
        nextImageLabel2= new JLabel();
        nextImageLabel3= new JLabel();
        
        characterPanel.add(characterLabel);
        imageNextPanel.add(nextImageLabel);
        imageNextPanel.add(nextImageLabel1);
        imageNextPanel.add(nextImageLabel2);
        imageNextPanel.add(nextImageLabel3);
        
        characterLabel.setVisible(true);
        nextImageLabel.setVisible(true);
        nextImageLabel1.setVisible(true);
        nextImageLabel2.setVisible(true);
        nextImageLabel3.setVisible(true);


        Timer timerKnightRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKinghtRun = (currentImageIndexKinghtRun + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timerKnightRun.start();


        Timer timerKnightAttack = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKnightAttack = (currentImageIndexKnightAttack + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timerKnightAttack.start();



        Timer timerKnightDefense = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKnightDefense = (currentImageIndexKnightDefense + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timerKnightDefense.start();
 

        Dices dices = new Dices();

        fenetre.setVisible(true);   
        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {


                

                if( e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER){
                    dices.rollDice();
                }
        
               //key listener for knight
               
                if ( e.getKeyCode() == KeyEvent.VK_RIGHT) {       //Right knight
                    if (xKnight > 570)  xKnight = 570; 

                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    xKnight = kx1;

                }

                if ( e.getKeyCode() == KeyEvent.VK_LEFT) {        //Left knight
                    xKnight = xknight2; 
                    if (xKnight <= 0)  xKnight = 0; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    Random randomPixel1 = new Random();

                    int xk=xKnight+50;
                    int yk=yKnight;

                    int kx1 = randomPixel1.nextInt(601 - xk ) + xk + 50 ;
                    int kx2 = randomPixel1.nextInt(xk + 1 + 50)  ;   


                    int ky1 = randomPixel1.nextInt(601 - yk) + yk + 50;
                    int ky2 = randomPixel1.nextInt(yk + 51 );
                  



                    afficherImageNext(xk, ky1, xk, ky2, kx1 , yk, kx2, yk);
                    }

                if ( e.getKeyCode() == KeyEvent.VK_UP) {          //Up knight
                    yKnight = yKnight2; 
                    if (yKnight <= 50) yKnight = 50;                     
                   afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
                    Random randomPixel2 = new Random();

                    int xk=xKnight+50;
                    int yk=yKnight;

                    int kx1 = randomPixel2.nextInt(601 - xk ) + xk + 50 ;
                    int kx2 = randomPixel2.nextInt(xk + 1 + 50)  ;   


                    int ky1 = randomPixel2.nextInt(601 - yk) + yk + 50;
                    int ky2 = randomPixel2.nextInt(yk + 51 );
                  



                    afficherImageNext(xk, ky1, xk, ky2, kx1 , yk, kx2, yk);
                   }

                if ( e.getKeyCode() == KeyEvent.VK_DOWN) {        //Down knight
                    yKnight = yKnight1; 
                    if (yKnight >= 550)  yKnight = 550;
                  afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    Random randomPixel3 = new Random();

                    int xk=xKnight+50;
                    int yk=yKnight;

                    int kx1 = randomPixel3.nextInt(601 - xk ) + xk + 50 ;
                    int kx2 = randomPixel3.nextInt(xk + 1 + 50)  ;   


                    int ky1 = randomPixel3.nextInt(601 - yk) + yk + 50;
                    int ky2 = randomPixel3.nextInt(yk + 51 );
                  



                    afficherImageNext(xk, ky1, xk, ky2, kx1 , yk, kx2, yk);

                }
                

                if (e.getKeyChar() == 'y'| e.getKeyChar() == 'Y'  ){     //Attack knight
                afficherImageKnight(imagePathsKnightAttack[currentImageIndexKnightAttack]); 
                    

                    }

                 if ( e.getKeyChar() == 'd'| e.getKeyChar() == 'D' ) {    //Defense knight
                afficherImageKnight(imagePathsKnightDefense[currentImageIndexKnightDefense]);
                            

                    }  
               
           
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Do nothing here, as we are not using keyReleased
            }
        });

        fenetre.add(dices.panelDice);
        fenetre.setFocusable(true);
        fenetre.requestFocus();
        fenetre.setVisible(true);
    }


    private void afficherImageKnight(String nomImage) {
        ImageIcon imageIcon = new ImageIcon(nomImage);
        characterLabel.setIcon(imageIcon);
        characterLabel.setBounds(xKnight, yKnight, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        characterLabel.repaint(); // Repaint the label to show the updated position

    }
    
    private void afficherImageNext(int x, int y,int z, int a, int b, int c,int d, int e) {
        ImageIcon imageIcon = new ImageIcon("../project/MapPixels/step3.jpg");
        System.out.println("Displaying image at x=" + x + " and y=" + y);
        nextImageLabel.setIcon(imageIcon);
        nextImageLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        nextImageLabel.repaint(); // Repaint the label to show the updated position
        nextImageLabel1.setIcon(imageIcon);
        nextImageLabel1.setBounds(z, a, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        nextImageLabel1.repaint();
        nextImageLabel2.setIcon(imageIcon);
        nextImageLabel2.setBounds(b,c , imageIcon.getIconWidth(), imageIcon.getIconHeight());
        nextImageLabel2.repaint();
        nextImageLabel3.setIcon(imageIcon);
        nextImageLabel3.setBounds(d, e, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        nextImageLabel3.repaint();

    }
    

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingUtilities.invokeLater(() -> new AllCharactersMvmntghita());
        });
    }
}


class Dices {
    public JButton rollButton;
    public JPanel panelDice;
    public JLabel resultLabel;
    public JLabel diceImageLabel1;
    public JLabel diceImageLabel2;

    public Dices() {
        rollButton = new JButton("Lancer les des");
        resultLabel = new JLabel();
        diceImageLabel1 = new JLabel();
        diceImageLabel2 = new JLabel();

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        panelDice = new JPanel();
        panelDice.setPreferredSize(new Dimension(650, 50));
        panelDice.setBounds(0, 0, 650, 50);
        panelDice.add(rollButton);
        panelDice.add(resultLabel);
        panelDice.add(diceImageLabel1);
        panelDice.add(diceImageLabel2);

    }

    public void rollDice() {
       
        Random random = new Random();
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(20) + 1;

        // Charger et afficher les images des faces des dés correspondantes
        String imagePath1 = "./Dice/dice" + roll1 + ".png";
        String imagePath2 = "./Dice/die20" + roll2 + ".png";
        ImageIcon icon1 = new ImageIcon(imagePath1);
        ImageIcon icon2 = new ImageIcon(imagePath2);
        diceImageLabel1.setIcon(icon1);
        diceImageLabel2.setIcon(icon2);
    }
}