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


        
        private JLabel characterLabel;
    
    public String[] imagePathsKnightRun = {
        "../project/CharactersMvmnt/PirateMvmnt/run1.png",
        "../project/CharactersMvmnt/PirateMvmnt/run2.png",
        "../project/CharactersMvmnt/PirateMvmnt/run3.png",
        "../project/CharactersMvmnt/PirateMvmnt/run4.png",
        "../project/CharactersMvmnt/PirateMvmnt/run5.png",
        "../project/CharactersMvmnt/PirateMvmnt/run6.png",
        "../project/CharactersMvmnt/PirateMvmnt/run7.png",
      
    };
    
    public String[] imagePathsKnightRunInverse = {
        "../project/CharactersMvmnt/PirateMvmnt/run11.png",
        "../project/CharactersMvmnt/PirateMvmnt/run22.png",
        "../project/CharactersMvmnt/PirateMvmnt/run33.png",
        "../project/CharactersMvmnt/PirateMvmnt/run44.png",
        "../project/CharactersMvmnt/PirateMvmnt/run55.png",
        "../project/CharactersMvmnt/PirateMvmnt/run66.png",
        "../project/CharactersMvmnt/PirateMvmnt/run77.png",
     
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
                int [][] mapTXT=loadMap("map.txt");
                Lmatrix = transposeMatrix(mapTXT);
               
                
                Bmatrix = CreatTheBigMatrix(Lmatrix);   

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
    int newX = xKnight + dx * 5; // Multiply by 40 to match the block size
    int newY = yKnight + dy * 5; // Multiply by 40 to match the block size

    if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
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

public int[][] transposeMatrix(int[][] matrix) {
    int rows = matrix.length;
    int columns = matrix[0].length;

    int[][] transposedMatrix = new int[columns][rows];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            transposedMatrix[j][i] = matrix[i][j];
        }
    }

    return transposedMatrix;
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
