package DrawTheMap;


import javax.swing.*;
import javax.swing.border.LineBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;

//import TheDragon.Dragon;
import TheFighter.FighterCaracter;



public class labyrinth {

    public  int MATRIX_SIZE = 810;
    Image image;
    Image imageStep;

    public JFrame Window;
    public int[][] Lmatrix;
    public int[][] Bmatrix;
    
    public int xFighter = 120;
    public int yFighter = 120;

    public JLabel characterLabel;
    public int currentImageIndexFighterRun = 0;

    FighterCaracter Bnadem = new FighterCaracter( "GHita ",   400, 10, 10);
    FighterCaracter Pirate = new FighterCaracter(  "Pirate", 300, 10, 10);

    //
    
    public String[] imagePathsFighterRun = {
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run1.png",
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run2.png",
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run3.png",
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run4.png",
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run5.png",
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run6.png",
        "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/run7.png",
      
    };

    public String[] imagePathsFighterAttack={
            "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/Attack1.png",
            "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/Attack2.png",
            "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/Attack3.png",
            "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/Attack4.png",

    };

    
    public String[] imagePathsKnightRunInverse = {
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run11.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run22.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run33.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run44.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run55.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run66.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run77.png",
     
    };


 
    public labyrinth() {



        Window = new JFrame("Affichage de photos");
        Window.setSize(800, 800);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //RightSide Panel
        JPanel RightSide = new JPanel();
        RightSide.setLayout(null); 
        RightSide.setBounds(800, 0, 285, 612);
        RightSide.setBackground(Color.decode("#e8dfdb"));
        LineBorder border = new LineBorder(Color.decode("#365979"), 10, true);
        LineBorder border1 = new LineBorder(Color.decode("#8bb1c4"), 5, true);
        LineBorder border2 = new LineBorder(Color.decode("#b96343"), 5, true);

        RightSide.setBorder(border);

        //RightSide Label (Title)
        JLabel TitleLabel = new JLabel("  Jeu de combat");
        TitleLabel.setBorder(border);
        Font font = new Font("Lucida Handwriting", Font.BOLD, 20);
        TitleLabel.setFont(font);
        TitleLabel.setForeground(Color.decode("#7e5835"));
        TitleLabel.setOpaque(true);
        TitleLabel.setBackground(Color.decode("#d1c0b9"));
        TitleLabel.setBounds(40, 60, 220, 50);


         // Fither 1 Label

        //picture
        JLabel FighterLabel = new JLabel();
        Font font2 = new Font("Lucida Handwriting", Font.BOLD, 15);
        FighterLabel.setBounds(20, 210, 124,    124);
        ImageIcon imageIconFighter1 = new ImageIcon("../Project/Ressource/CharactersMvmnt/KnightMvmnt1/FirstCharacterIcone.png");
        Image image = imageIconFighter1.getImage();
        Image newImage = image.getScaledInstance(124, 124, Image.SCALE_SMOOTH); 
        imageIconFighter1 = new ImageIcon(newImage); 
        FighterLabel.setIcon(imageIconFighter1);
        FighterLabel.setBorder(border1);

        //name
        JLabel FighterLabel2 = new JLabel("  "+Bnadem.name);
        FighterLabel2.setBorder(border1);
        FighterLabel2.setFont(font2);
        FighterLabel2.setForeground(Color.decode("#425b8a"));
        FighterLabel2.setOpaque(true);
        FighterLabel2.setBackground(Color.decode("#d1c0b9"));
        FighterLabel2.setBounds(20, 150, 110, 50);

        //life
        JLabel FighterLabel3 = new JLabel("  Life :"+ Bnadem.score) ;
        FighterLabel3.setBorder(border1);
        FighterLabel3.setFont(font2);
        FighterLabel3.setForeground(Color.decode("#425b8a"));
        FighterLabel3.setOpaque(true);
        FighterLabel3.setBackground(Color.decode("#d1c0b9"));
        FighterLabel3.setBounds(20, 350, 110, 50);


        // Fither 2 Label

        //picture
        JLabel FighterLabel4 = new JLabel();
        Font font3 = new Font("Lucida Handwriting", Font.BOLD, 15);
        FighterLabel4.setBounds(150, 210, 124,    124);
        ImageIcon imageIconFighter2 = new ImageIcon("../Project/Ressource/CharactersMvmnt/PirateMvmnt/run1.png");
        Image image2 = imageIconFighter2.getImage();
        Image newImage2 = image2.getScaledInstance(124, 124, Image.SCALE_SMOOTH);
        imageIconFighter2 = new ImageIcon(newImage2);
        FighterLabel4.setIcon(imageIconFighter2);
        FighterLabel4.setBorder(border1);
        
        //name
        JLabel FighterLabel5 = new JLabel("    "+Pirate.name);
        FighterLabel5.setBorder(border1);
        FighterLabel5.setFont(font3);
        FighterLabel5.setForeground(Color.decode("#425b8a"));
        FighterLabel5.setOpaque(true);
        FighterLabel5.setBackground(Color.decode("#d1c0b9"));
        FighterLabel5.setBounds(150, 150, 110, 50);

        //life
        JLabel FighterLabel6 = new JLabel("  Life :"+ Pirate.score) ;
        FighterLabel6.setBorder(border1);
        FighterLabel6.setFont(font3);
        FighterLabel6.setForeground(Color.decode("#425b8a"));
        FighterLabel6.setOpaque(true);
        FighterLabel6.setBackground(Color.decode("#d1c0b9"));
        FighterLabel6.setBounds(150, 350, 110, 50);

        //Timer
        JLabel labelTimer = new JLabel("0");
        Timer timer = new Timer(1000, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                labelTimer.setText("Timer : " + count + "s");
            }
        });

        timer.start();
        labelTimer.setBounds(170, 6,    110, 30);
        labelTimer.setBorder(border2);
        labelTimer.setFont(font3);
        labelTimer.setForeground(Color.decode("#425b8a"));
        labelTimer.setOpaque(true);
        labelTimer.setBackground(Color.decode("#d1c0b9"));









        RightSide.add(FighterLabel2);
        RightSide.add(FighterLabel);
        RightSide.add(FighterLabel3);
        RightSide.add(FighterLabel4);
        RightSide.add(FighterLabel5);
        RightSide.add(FighterLabel6);
        RightSide.add(labelTimer);

        RightSide.add(TitleLabel);
        Window.add(RightSide);
        Window.setLayout(null);



        

        JPanel characterPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image image = new ImageIcon("../Project/Ressource/MapPixels/labyrinth1.jpg").getImage();
                Image mageTEST = new ImageIcon("../Project/Ressource/MapPixels/labyrinth2.jpg").getImage();
               
                 MapMaths MapManage = new MapMaths();

                //Lmatrix = MapManage.loadMap("map.txt");
                Lmatrix = MapManage.loadMap();
                Bmatrix = MapManage.CreatTheBigMatrix(Lmatrix);   

                for(int i=0; i<800; i=i+40){
                    for(int j=0; j<800; j=j+40){
                        if(Bmatrix[i][j] == 0){
                            g.drawImage(image, i , j, this);
                        }
           
                    }
                }

                for(int i=0; i<20;i++){
                    for(int j=0; j<20; j++){
                        if(Lmatrix[i][j] == 1){
                            g.drawImage(mageTEST, i*40 , j*40, this);
                        }
                    }   
                }

        }             
    };

        characterPanel.setPreferredSize(new Dimension(800, 650));
        characterPanel.setBounds(0, 0, 800, 650);
        Window.setSize(new Dimension(1100, 650));
        Window.setResizable(false);
        Window.add(characterPanel);
        characterPanel.setLayout(null); // Set layout to null to position the character precisely


        characterLabel = new JLabel();
        characterPanel.add(characterLabel);
        //label.add(characterPanel);
        characterLabel.setBounds(xFighter, yFighter, 40, 40);


         Timer timerFighterRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexFighterRun = (currentImageIndexFighterRun + 1) % imagePathsFighterRun.length; // Loop through the images
            }
        });
        timerFighterRun.start();
        
        Window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right knight
                    moveFighter(1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left knight
                    moveFighter(-1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Up knight
                    moveFighter(0, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down knight
                    moveFighter(0, 1);
                } else if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
                    ShowFighter(imagePathsFighterAttack[currentImageIndexFighterRun]);
                }
            }
             

                @Override
            public void keyReleased(KeyEvent e) {
                    // Do nothing here, as we are not using keyReleased
                }
            });
        Window.setVisible(true);
    }

    public void moveFighter(int dx, int dy) {
        int newX = xFighter + dx * 5;
        int newY = yFighter + dy * 5;
    
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { 
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(imagePathsFighterRun[currentImageIndexFighterRun]);
            }
        }
    }

    public void ShowFighter(String nomImage) {

        ImageIcon imageIcon = new ImageIcon(nomImage);
        characterLabel.setIcon(imageIcon);
        characterLabel.setBounds(xFighter, yFighter, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        characterLabel.repaint(); // Repaint the label to show the updated position
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new labyrinth();
                 //new FighterCaracter();

            }
        });
    }
}

