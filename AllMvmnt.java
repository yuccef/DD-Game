import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class AllMvmnt {

    Image image = new ImageIcon("../project/MapPixels/3.jpg").getImage();
    Image imageStep = new ImageIcon("../project/MapPixels/step3.jpg").getImage();

    private int turn = 4;

    private int xKnight = 325;
    private int yKnight = 570;

    private int xWitch= 0;
    private int yWitch= 375;

    private int xPirate= 325;
    private int yPirate= 50;


    private int xKnight1, yKnight1, xknight2,yKnight2;
    private int xWitch1, yWitch1, xWitch2,yWitch2;
    private int xPirate1, yPirate1, xPirate2,yPirate2;



    private JFrame fenetre;

    private JLabel characterLabel;
    private JLabel characterLabelWitch;
    private JLabel characterLabelPirate;

     Random randomPixel1 = new Random();

   

   

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

    private int currentImageIndexWitchRun = 0;

    private int currentImageIndexPirateRun = 0;
    private int currentImageIndexPirateAttack = 0;




    public AllMvmnt() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 700);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
     
        JPanel characterPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
                Image image = new ImageIcon("../project/MapPixels/3.jpg").getImage();

                for (int y = 50; y < 750; y += 50) {
                    for (int x = 0; x < 750; x += 50) {
                    g.drawImage(image, x, y, this);
                    }}; 



       
            //Knight
                if(turn % 3 == 1){ 


                //right
                    if(xKnight >= 550) xKnight1 = 570;
                    else  xKnight1 = randomPixel1.nextInt(600 - xKnight-60  ) + xKnight + 60 ;


                 //left
                    if(xKnight<=60) xknight2 = 0;
                    else  xknight2 =   randomPixel1.nextInt(xKnight - 60 ) +1;

                //down
                    if(yKnight>=500) yKnight1 = 570; 
                    else  yKnight1 = randomPixel1.nextInt(600 - (yKnight + 60)) + yKnight ;  
                    
                //up
                   if(yKnight<=100) yKnight2 = 50;
                   else  yKnight2=  randomPixel1.nextInt(yKnight - 60) + 50 ;

                    g.drawImage(imageStep, xKnight1, yKnight, this);
                    g.drawImage(imageStep, xknight2, yKnight, this);
                    g.drawImage(imageStep, xKnight, yKnight1, this);
                    g.drawImage(imageStep, xKnight, yKnight2, this);    
            }
        
             //Witch
                if(turn % 3 == 2){ 

            //right
                if(xWitch>=570) xWitch1 = 570;
                else  xWitch1 = randomPixel1.nextInt(600 - xWitch - 60 ) + xWitch + 60 ;

            
            //left   
                if(xWitch<=60) xWitch2 = 0;
                else  xWitch2 =   randomPixel1.nextInt(xWitch - 60 ) + 1;

            //down
                if(yWitch>=500) yWitch1 = 570; 
                else  yWitch1 = randomPixel1.nextInt(600 - (yWitch + 60)) + yWitch ;

            //up
                if(yWitch<=100) yWitch2 = 50;
                else  yWitch2=  randomPixel1.nextInt(yWitch - 60) + 50;

            g.drawImage(imageStep, xWitch1, yWitch, this);
            g.drawImage(imageStep, xWitch2, yWitch, this);
            g.drawImage(imageStep, xWitch, yWitch1, this);
            g.drawImage(imageStep, xWitch, yWitch2, this);   
        }

            //pirate
            if(turn % 3 == 0){  
                    

            //right
                if(xPirate>=570) xPirate1 = 550;
                else  xPirate1 = randomPixel1.nextInt(600 - (xPirate +60) )+ xPirate +60    ;

            //left
                if(xPirate<=60) xPirate2 = 0;
                else  xPirate2 =   randomPixel1.nextInt(xPirate - 60 ) + 1;
            
            //down

                if(yPirate>=570) yPirate1 = 570; 
                else  yPirate1 = randomPixel1.nextInt(600 - (yPirate + 60)) + yPirate ;

            //up

                if(yPirate<=100) yPirate2 = 50;
                else  yPirate2=  randomPixel1.nextInt(yPirate - 60)+50 ;



            g.drawImage(imageStep, xPirate1, yPirate, this);
            g.drawImage(imageStep, xPirate2, yPirate, this);
            g.drawImage(imageStep, xPirate, yPirate1, this);
            g.drawImage(imageStep, xPirate, yPirate2, this); 

        }   
              }
        };

        characterPanel.setPreferredSize(new Dimension(650, 650));
        characterPanel.setBounds(50, 0, 650, 650);
        fenetre.setSize(new Dimension(650, 650));
        fenetre.setResizable(false);
        fenetre.add(characterPanel);
        characterPanel.setLayout(null); // Set layout to null to position the character precisely


        characterLabel = new JLabel();
        characterLabelWitch = new JLabel();
        characterLabelPirate = new JLabel();

        characterPanel.add(characterLabel);
        characterPanel.add(characterLabelWitch);
        characterPanel.add(characterLabelPirate);



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
               if (turn % 3 == 1) {
                if ( turn % 3 == 1 && e.getKeyCode() == KeyEvent.VK_RIGHT) {       //Right knight
                    xKnight = xKnight1;
                    turn++;
                    if (xKnight > 570)  xKnight = 570;   
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                    fenetre.repaint();

                }

                if ( turn % 3 == 1 && e.getKeyCode() == KeyEvent.VK_LEFT) {        //Left knight
                    xKnight = xknight2; 
                    turn++;
                    if (xKnight <= 0)  xKnight = 0; 
                    afficherImageKnight(imagePathsKnightRunInverse[currentImageIndexKinghtRun]); 
                     fenetre.repaint();


                }

                if (turn % 3 == 1 &&  e.getKeyCode() == KeyEvent.VK_UP) {          //Up knight
                    yKnight = yKnight2; 
                    turn++;
                    if (yKnight <= 50) yKnight = 50; 
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
                    fenetre.repaint();


                }

                if ( turn % 3 == 1 && e.getKeyCode() == KeyEvent.VK_DOWN) {        //Down knight
                    yKnight = yKnight1; 
                    turn++;
                    if (yKnight >= 550)  yKnight = 550;
                    afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                                        fenetre.repaint();


                }
                
                if (turn % 3 == 1 && e.getKeyChar() == 'y'| e.getKeyChar() == 'Y'  ){     //Attack knight
                afficherImageKnight(imagePathsKnightAttack[currentImageIndexKnightAttack]); 
                            turn++;

                    }

                 if ( turn % 3 == 1 && e.getKeyChar() == 'd'| e.getKeyChar() == 'D' ) {    //Defense knight
                afficherImageKnight(imagePathsKnightDefense[currentImageIndexKnightDefense]);
                            turn++;

                    }  
               }
                

                //key listener for witch
                else if (turn % 3 == 2) {
                if ( turn % 3 == 2 && e.getKeyCode() == KeyEvent.VK_RIGHT) { //Right witch
                    xWitch = xWitch1; 
                    turn++;
                    if (xWitch > 570)   xWitch = 570;  
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]); 
                    fenetre.repaint();


                }

                 if (turn % 3 == 2 &&  e.getKeyCode() == KeyEvent.VK_LEFT) { //Left witch
                    xWitch = xWitch2; ;
                    turn++;
                    if (xWitch <= 0)  xWitch = 0;
                    afficherImageWitch(imagePathsWitchRunInverse[currentImageIndexWitchRun]);
                                        fenetre.repaint();


                }
                
                 if (turn % 3 == 2 &&  e.getKeyCode() == KeyEvent.VK_UP) { //Up witch
                    yWitch =  yWitch2 ;
                    turn++;
                    if (yWitch<= 50)   yWitch = 50; 
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]);
                                        fenetre.repaint();

 
                }

                 if (turn % 3 == 2 &&  e.getKeyCode() == KeyEvent.VK_DOWN) { //Down witch
                    yWitch =  yWitch1; 
                    turn++;
                    if (yWitch >= 550)  yWitch = 550; 
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]);
                                        fenetre.repaint();


                }   
                
                 if ( turn % 3 == 2 && e.getKeyChar() ==  'i' | e.getKeyChar() == 'I' ) { //Attack witch
                afficherImageWitch(imagePathsWitchAttack[currentImageIndexWitchRun]);
                            turn++;

                    }
                }      
                
                                 
                //key listener for pirate  
                else if (turn % 3 == 0) {       
                 if (turn%3 == 0 && e.getKeyCode() == KeyEvent.VK_RIGHT) {  //Right pirate
                    xPirate = xPirate1; 
                    turn++;
                    if (xPirate > 570)   xPirate = 570;  
                    afficherImagePirate(imagePathsPirateRun[currentImageIndexPirateRun]); 
                                        fenetre.repaint();

                }

                 if (turn%3 == 0 && e.getKeyCode() == KeyEvent.VK_LEFT) {  //Left pirate
                    xPirate = xPirate2;
                    turn++;
                    if (xPirate <= 0)  xPirate = 0;
                    afficherImagePirate(imagePathsPirateRun[currentImageIndexPirateRun]);
                                        fenetre.repaint();

                }

                 if (turn%3 == 0 && e.getKeyCode() == KeyEvent.VK_UP) {  //Up pirate
                    yPirate = yPirate2;
                    turn++;
                    if (yPirate<= 50)   yPirate = 50; 
                    afficherImagePirate(imagePathsPirateRun[currentImageIndexPirateRun]); 
                                        fenetre.repaint();

                }

                 if (turn%3 == 0 && e.getKeyCode() == KeyEvent.VK_DOWN) {  //Down pirate
                    yPirate = yPirate1; 
                    turn++;
                    if (yPirate >= 550)  yPirate = 550; 
                    afficherImagePirate(imagePathsPirateRun[currentImageIndexPirateRun]);
                                        fenetre.repaint();

                }
                
                 if (turn%3 == 0 && e.getKeyChar() ==  'n' | e.getKeyChar() == 'N' ) { //Attack pirate
                afficherImagePirate(imagePathsPirateAttack[currentImageIndexPirateAttack]);
                            turn++;    
                    }  
                

                if (e.getKeyChar() == 'y'| e.getKeyChar() == 'Y'  ){     //Attack knight
                afficherImageKnight(imagePathsKnightAttack[currentImageIndexKnightAttack]); 

                    }

                if ( e.getKeyChar() == 't'| e.getKeyChar() == 'T'  ){     //Defense knight
                afficherImageKnight(imagePathsKnightDefense[currentImageIndexKnightDefense]);        
                    }
            
                
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

    private void afficherImageWitch(String nomImageWitch) {
        ImageIcon imageIconWitch = new ImageIcon(nomImageWitch);
        characterLabelWitch.setIcon(imageIconWitch);
        characterLabelWitch.setBounds(xWitch, yWitch, imageIconWitch.getIconWidth(), imageIconWitch.getIconHeight());
        characterLabelWitch.repaint(); // Repaint the label to show the updated position

    }

    private void afficherImagePirate(String nomImagePirate) {
        ImageIcon imageIconPirate = new ImageIcon(nomImagePirate);
        characterLabelPirate.setIcon(imageIconPirate);
        characterLabelPirate.setBounds(xPirate, yPirate, imageIconPirate.getIconWidth(), imageIconPirate.getIconHeight());
        characterLabelPirate.repaint(); // Repaint the label to show the updated position

    }

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingUtilities.invokeLater(() -> new AllMvmnt());
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