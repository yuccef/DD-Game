import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.String;






public class labyrinth {

    private static final int MATRIX_SIZE = 810;
    // private static final int BLOCK_SIZE = 40;

    Image image;
    Image imageStep;
    private JFrame fenetre;
    private int[][] Lmatrix;
    public int[][] Bmatrix;


    
        private int xKnight = 120;
        private int yKnight = 120;

        private int KnightRight = xKnight+60;
        private int KnightDown = yKnight-74;
        
        private int  xx,yy;
        private JLabel characterLabel;
    
    public String[] imagePathsKnightRun = {
        "../project/CharactersMvmnt/WitchMvmnt/run1.png",
        "../project/CharactersMvmnt/WitchMvmnt/run2.png",
        "../project/CharactersMvmnt/WitchMvmnt/run3.png",
        "../project/CharactersMvmnt/WitchMvmnt/run4.png",
        "../project/CharactersMvmnt/WitchMvmnt/run5.png",
        "../project/CharactersMvmnt/WitchMvmnt/run6.png",
        "../project/CharactersMvmnt/WitchMvmnt/run7.png",
        "../project/CharactersMvmnt/WitchMvmnt/run8.png"
    };
    
    public String[] imagePathsKnightRunInverse = {
        "../project/CharactersMvmnt/WitchMvmnt/run11.png",
        "../project/CharactersMvmnt/WitchMvmnt/run22.png",
        "../project/CharactersMvmnt/WitchMvmnt/run33.png",
        "../project/CharactersMvmnt/WitchMvmnt/run44.png",
        "../project/CharactersMvmnt/WitchMvmnt/run55.png",
        "../project/CharactersMvmnt/WitchMvmnt/run66.png",
        "../project/CharactersMvmnt/WitchMvmnt/run77.png",
        "../project/CharactersMvmnt/WitchMvmnt/run88.png"
    };


    



    private int currentImageIndexKinghtRun = 0;
 
    public labyrinth() {
        fenetre = new JFrame("Affichage de photos");
        fenetre.setSize(800, 800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






        JPanel characterPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image image = new ImageIcon("../project/MapPixels/labyrinth1.jpg").getImage();
                Image mageTEST = new ImageIcon("../project/MapPixels/labyrinth2.jpg").getImage();
                  int[][] m = {
                    {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1}
                };
                Bmatrix = CreatTheBigMatrix(m);   

                for(int i=0; i<800; i=i+40){
                    for(int j=0; j<800; j=j+40){
                        if(Bmatrix[i][j] == 0){
                            g.drawImage(image, i , j, this);
                        }
           
                    }
                }

                for(int i=0; i<20;i++){
                    for(int j=0; j<20; j++){
                        if(m[i][j] == 1){
                            g.drawImage(mageTEST, i*40 , j*40, this);
                        }
                    }   
                }
                //print Bmatrix
                for(int i=0; i<800; i=i+40){
                    for(int j=0; j<800; j=j+40){
                        System.out.print(Bmatrix[j][i]);
                    }
                    System.out.println();

                
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
           xx = xKnight;    
           yy = yKnight;  
           
           
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


    public int[][]  loadMap( String test ){
  
        int Littlematrix[][] = new int[20][20];

            for( int i=0; i<20; i++){
                for(int j=0; j<20; j++){
                    Littlematrix[j][i] = 0;
                }
            }


        try{

            InputStream is = getClass().getResourceAsStream(test);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); 


            int col = 0;  
            int row = 0; 
            while(col <20 && row < 20){
                String line = br.readLine(); //Lire la ligne
                while(col <20){      
                    String numbers[] = line.split(" "); 
                    int num = Integer.parseInt(numbers[col]); 
                    Littlematrix[col][row] = num;
                    col++;
                }
                if (col == 20){
                    col = 0;
                    row++;
                } 
            }


            br.close();
        }catch(Exception e){
            System.out.println("Error loading map");
        }
    return Littlematrix;
    }


    public int[][] CreatTheBigMatrix(int Littlematrix[][]){
        int[][] finaleMatrix = new int[800][800];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 40; k++) {
                    for (int l = 0; l < 40; l++) {
                        finaleMatrix[j * 40 + k][i * 40 + l] = Littlematrix[j][i];
                    }
                }
            }
        }


                    return finaleMatrix;


    }

    private void moveKnight(int dx, int dy) {
        int newX = xKnight + dx * 5; // Step size 5 in the x direction
        int newY = yKnight + dy * 5; // Step size 5 in the y direction
    
        // Checking boundaries to avoid going out of the matrix
        if (newX >= 0 && newX + 30 < MATRIX_SIZE && newY >= 0 && newY + 30 < MATRIX_SIZE) {
            // Checking for collision with maze walls
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
    
    

    private void afficherImageKnight(String nomImage) {

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
            }
        });
}
}
