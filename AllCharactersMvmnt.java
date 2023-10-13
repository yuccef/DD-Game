import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AllCharactersMvmnt {
    private int xKnight = 325;
    private int yKnight = 550;

    private int xWitch= 0;
    private int yWitch= 325;

    private JFrame fenetre;
    private JPanel characterPanel;
    private JLabel characterLabel;
    private JLabel characterLabelWitch;


    public String[] imagePathsKnightRun = {
        "../project/KnightMvmnt/run1.png",
        "../project/KnightMvmnt/run2.png",
        "../project/KnightMvmnt/run3.png",
        "../project/KnightMvmnt/run4.png",
        "../project/KnightMvmnt/run5.png",
        "../project/KnightMvmnt/run6.png",
        "../project/KnightMvmnt/run7.png",
        "../project/KnightMvmnt/run8.png"
    };


    public String[] imagePathsKnightRunInverse = {
        "../project/KnightMvmnt/run11.png",
        "../project/KnightMvmnt/run22.png",
        "../project/KnightMvmnt/run33.png",
        "../project/KnightMvmnt/run44.png",
        "../project/KnightMvmnt/run55.png",
        "../project/KnightMvmnt/run66.png",
        "../project/KnightMvmnt/run77.png",
        "../project/KnightMvmnt/run88.png"
    };

        public String[] imagePathsWitchRun = {
        "../project/WitchMvmnt/run1.png",
        "../project/WitchMvmnt/run2.png",
        "../project/WitchMvmnt/run3.png",
        "../project/WitchMvmnt/run4.png",
        "../project/WitchMvmnt/run5.png",
        "../project/WitchMvmnt/run6.png",
        "../project/WitchMvmnt/run7.png",
        "../project/WitchMvmnt/run8.png"
    };

      public String[] imagePathsKnightAttack = {
        "../project/KnightMvmnt/KnightAttack1.png",
        "../project/KnightMvmnt/KnightAttack2.png",
         "../project/KnightMvmnt/KnightAttack3.png",
         "../project/KnightMvmnt/KnightAttack4.png",
    };

          public String[] imagePathsKnightDefense = {
        "../project/KnightMvmnt/KnightDefense.png",
        "../project/KnightMvmnt/KnightDefense2.png",
        "../project/KnightMvmnt/KnightDefense3.png",
    };


      private int currentImageIndexKinghtRun = 0;
      private int currentImageIndexWitchRun = 0;
      private int currentImageIndexKnightAttack = 0;
      private int currentImageIndexKnightDefense = 0;

    public AllCharactersMvmnt() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        characterPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("./BackGround.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
                setPreferredSize(new Dimension(353, 346));

            }
        };
        fenetre.setSize(new Dimension(650, 650));
        fenetre.setResizable(false);
        fenetre.add(characterPanel);
        characterPanel.setLayout(null); // Set layout to null to position the character precisely


        characterLabel = new JLabel();
        characterLabelWitch = new JLabel();
        characterPanel.add(characterLabel);
        characterPanel.add(characterLabelWitch);


        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKinghtRun = (currentImageIndexKinghtRun + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timer.start();


        Timer timer1 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKnightAttack = (currentImageIndexKnightAttack + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timer1.start();

        Timer timer2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexKnightDefense = (currentImageIndexKnightDefense + 1) % imagePathsKnightRun.length; // Loop through the images
            }
        });
        timer2.start();
        

        Timer timerWitch = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]);
                currentImageIndexWitchRun = (currentImageIndexWitchRun + 1) % imagePathsWitchRun.length; // Loop through the images
            }
        });
        timerWitch.start();


        fenetre.setVisible(true);   
        fenetre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    xKnight += 5;
                    if (xKnight > 570)  xKnight = 570;   
                    afficherImage(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    xKnight -= 5; 
                    if (xKnight <= 0)  xKnight = 0; 
                    afficherImage(imagePathsKnightRunInverse[currentImageIndexKinghtRun]); 
                }

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    yKnight -= 5; 
                    if (yKnight <= 0) yKnight = 0; 
                    afficherImage(imagePathsKnightRun[currentImageIndexKinghtRun]);
                }


                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yKnight += 5; 
                    if (yKnight >= 550)  yKnight = 550;
                    afficherImage(imagePathsKnightRun[currentImageIndexKinghtRun]); 
                }

                if (e.getKeyChar() == 'y'| e.getKeyChar() == 'Y'  ) {
                afficherImage(imagePathsKnightAttack[currentImageIndexKnightAttack]); 

                    }
                 if (e.getKeyChar() == 'd'| e.getKeyChar() == 'D' ) {
                afficherImage(imagePathsKnightDefense[currentImageIndexKnightDefense]);

                    }  


if (e.getKeyCode() == 'k' | e.getKeyCode() == 'K') {
                    xWitch += 5; 
                    if (xWitch > 570)   xWitch = 570;  
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]); 
                }


 if (e.getKeyCode() ==  'h' | e.getKeyCode() == 'H') {
                    xWitch -= 5;
                    if (xWitch <= 0)  xWitch = 0;
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]);
                }

 if (e.getKeyCode() ==  'u' | e.getKeyCode() == 'U') {
                    yWitch -= 5;
                    if (yWitch<= 0)   yWitch = 0; 
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]); 
                }
if (e.getKeyCode() ==  'j' | e.getKeyCode() == 'J') {
                    yWitch += 5; 
                    if (yWitch >= 550)  yWitch = 550; 
                    afficherImageWitch(imagePathsWitchRun[currentImageIndexWitchRun]);
                }        
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Do nothing here, as we are not using keyReleased
            }
        });


        fenetre.setFocusable(true);
        fenetre.requestFocus();
        fenetre.setVisible(true);
    }


    private void afficherImage(String nomImage) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AllCharactersMvmnt());
    }
}
