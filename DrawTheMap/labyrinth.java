package DrawTheMap;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;

//import TheFighter.FighterCaracter;
 
//import TheFighter.FighterCaracter;

public class labyrinth {


    public   int MATRIX_SIZE = 810;
    Image image;
    Image imageStep;

    public JFrame fenetre;
    public int[][] Lmatrix;
    public int[][] Bmatrix;
    
    public int xKnight = 120;
    public int yKnight = 120;

    public JLabel characterLabel;
    public int currentImageIndexKinghtRun = 0;

    
    public String[] imagePathsKnightRun = {
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run1.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run2.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run3.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run4.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run5.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run6.png",
        "../Project/Ressource/CharactersMvmnt/PirateMvmnt/run7.png",
      
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

        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        fenetre.setSize(new Dimension(800, 650));
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
       
           
               //key listener for knight
               if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right knight
                moveKnight(1, 0);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left knight
                moveKnight(-1, 0);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Up knight
                moveKnight(0, -1);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down knight
                moveKnight(0, 1);
            }
            } 

                @Override
            public void keyReleased(KeyEvent e) {
                    // Do nothing here, as we are not using keyReleased
                }
            });
        fenetre.setVisible(true);
    }

    

    


    public void moveKnight(int dx, int dy) {
        int newX = xKnight + dx * 5;
        int newY = yKnight + dy * 5;
    
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the Knight collides with a wall
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xKnight = newX;
                yKnight = newY;
                afficherImageKnight(imagePathsKnightRun[currentImageIndexKinghtRun]);
            }
        }
    }




    public void afficherImageKnight(String nomImage) {

        ImageIcon imageIcon = new ImageIcon(nomImage);
        characterLabel.setIcon(imageIcon);
        characterLabel.setBounds(xKnight, yKnight, imageIcon.getIconWidth(), imageIcon.getIconHeight());
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

