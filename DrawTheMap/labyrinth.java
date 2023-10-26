package DrawTheMap;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.String;

import TheDragon.Dragon;
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
    public int xDragon = 740;
    public int yDragon = 440;
    public String PicturesSheet = "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/";
    public String PicturesSheet2 = "../Project/Ressource/CharactersMvmnt/FirstDragon/";
    public String FirePicture ="../Project/Ressource/CharactersMvmnt/FirstDragon/Fire.png";

    public JLabel characterLabel;
    public JLabel DragonLabel;
    public JLabel FireLabel;
    public int currentImageIndexFighterRun = 0;
    public int currentImageIndexFighterAttack=0;
    public int currentImageIndexDragonRun = 0;
    public int currentImageIndexDragonAttack = 0;

    Timer timerFire; // Timer pour gérer l'animation du feu
    int xFire; // Coordonnée x du feu
    int yFire; // C
                    int FirstTime=0;


    public char SideDragon, SideFighter;
    JLabel FighterLabel3;
    JLabel FighterLabel2;
    JLabel FighterLabel5;
    JLabel FighterLabel6;

    FighterCaracter Bnadem = new FighterCaracter( "GHita ",   400, 10, 10, xFighter, yFighter);
    Dragon Dragon = new Dragon("Dragon", 400, 10, 10, xDragon, yDragon);

    public String[] imagePathsFighterRun = {
            PicturesSheet + "run1.png",
            PicturesSheet + "run2.png",
            PicturesSheet + "run3.png",
            PicturesSheet + "run4.png",
            PicturesSheet + "run5.png",
            PicturesSheet + "run6.png",
            PicturesSheet + "run7.png",
            PicturesSheet + "run8.png",
    };


    public String[] imagePathsFighterAttack={
        PicturesSheet + "Attack1.png",
        PicturesSheet + "Attack2.png",
        PicturesSheet + "Attack3.png",
        PicturesSheet + "Attack4.png",
    };

    public String[] imagePathsFighterAttackInverse={
        PicturesSheet + "Attack11.png",
        PicturesSheet + "Attack22.png",
        PicturesSheet + "Attack33.png",
        PicturesSheet + "Attack44.png",
    };
    

    
    public String[] imagePathsFighterRunInverse = {
            PicturesSheet + "run11.png",
            PicturesSheet + "run22.png",
            PicturesSheet + "run33.png",
            PicturesSheet + "run44.png",
            PicturesSheet + "run55.png",
            PicturesSheet + "run66.png",
            PicturesSheet + "run77.png",
            PicturesSheet + "run88.png",
    };

    public String[] imagePathsDragonRun = {
            PicturesSheet2 + "run1.png",
            PicturesSheet2 + "run2.png",
            PicturesSheet2 + "run3.png",
            PicturesSheet2 + "run4.png",
            PicturesSheet2 + "run5.png",
            PicturesSheet2 + "run6.png",
            PicturesSheet2 + "run7.png",
          
    };

    public String[] imagePathsDragonRunInverse={
        PicturesSheet2 + "run11.png",
        PicturesSheet2 + "run22.png",
        PicturesSheet2 + "run33.png",
        PicturesSheet2 + "run44.png",
        PicturesSheet2 + "run55.png",
        PicturesSheet2 + "run66.png",
     
    };
    
    public String[] imagePathsDragonAttack={
        PicturesSheet2 + "Attack1.png",
        PicturesSheet2 + "Attack2.png",
        PicturesSheet2 + "Attack3.png",
        PicturesSheet2 + "Attack4.png",
        PicturesSheet2 + "Attack5.png",
        PicturesSheet2 + "Attack6.png",
        PicturesSheet2 + "Attack7.png",
    };

    public String[] imagPathsDragonAttackInverse={
        PicturesSheet2 + "Attack11.png",
        PicturesSheet2 + "Attack22.png",
        PicturesSheet2 + "Attack33.png",
        PicturesSheet2 + "Attack44.png",
        PicturesSheet2 + "Attack55.png",
        PicturesSheet2 + "Attack66.png",
        PicturesSheet2 + "Attack77.png",
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
        Font font2 = new Font("Lucida Handwriting", Font.BOLD, 7);
        FighterLabel.setBounds(20, 210, 124,    124);
        ImageIcon imageIconFighter1 = new ImageIcon("../Project/Ressource/CharactersMvmnt/KnightMvmnt1/FirstCharacterIcone.png");
        Image image = imageIconFighter1.getImage();
        Image newImage = image.getScaledInstance(124, 124, Image.SCALE_SMOOTH); 
        imageIconFighter1 = new ImageIcon(newImage); 
        FighterLabel.setIcon(imageIconFighter1);
        FighterLabel.setBorder(border1);

        //name
         FighterLabel2 = new JLabel(" Y "+Bnadem.yFighter);
        FighterLabel2.setBorder(border1);
        FighterLabel2.setFont(font2);
        FighterLabel2.setForeground(Color.decode("#425b8a"));
        FighterLabel2.setOpaque(true);
        FighterLabel2.setBackground(Color.decode("#d1c0b9"));
        FighterLabel2.setBounds(20, 150, 110, 50);

        //life
         FighterLabel3 = new JLabel("  X :"+ Bnadem.xFighter) ;
        FighterLabel3.setBorder(border1);
        FighterLabel3.setFont(font2);
        FighterLabel3.setForeground(Color.decode("#425b8a"));
        FighterLabel3.setOpaque(true);
        FighterLabel3.setBackground(Color.decode("#d1c0b9"));
        FighterLabel3.setBounds(20, 350, 110, 50);

        // Dragon Label
        JLabel FighterLabel4 = new JLabel();
        FighterLabel4.setBounds(150, 210, 124,    124);
        ImageIcon imageIconFighter2 = new ImageIcon("../Project/Ressource/CharactersMvmnt/FirstDragon/FirstDragonIcone.png");
        Image image2 = imageIconFighter2.getImage();
        Image newImage2 = image2.getScaledInstance(124, 124, Image.SCALE_SMOOTH);
        imageIconFighter2 = new ImageIcon(newImage2);
        FighterLabel4.setIcon(imageIconFighter2);
        FighterLabel4.setBorder(border1);

        //name
        FighterLabel5 = new JLabel(" Y "+yDragon);
        FighterLabel5.setBorder(border1);
        FighterLabel5.setFont(font2);
        FighterLabel5.setForeground(Color.decode("#425b8a"));
        FighterLabel5.setOpaque(true);
        FighterLabel5.setBackground(Color.decode("#d1c0b9"));
        FighterLabel5.setBounds(150, 150, 110, 50);


        //life
        FighterLabel6 = new JLabel("  X :"+ xDragon) ;
        FighterLabel6.setBorder(border1);
        FighterLabel6.setFont(font2);
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
        labelTimer.setForeground(Color.decode("#425b8a"));
        labelTimer.setOpaque(true);
        labelTimer.setBackground(Color.decode("#d1c0b9"));









        RightSide.add(FighterLabel2);
        RightSide.add(FighterLabel);
        RightSide.add(FighterLabel3);

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

        DragonLabel = new JLabel();
        characterPanel.add(DragonLabel);
        DragonLabel.setBounds(xDragon, yDragon, 40, 40);
        characterLabel = new JLabel();
        characterPanel.add(characterLabel);
        characterLabel.setBounds(xFighter, yFighter, 40, 40);

        FireLabel = new JLabel();
        characterPanel.add(FireLabel);
        FireLabel.setBounds(xDragon, yDragon, 40, 40);

        


         Timer timerFighterRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexFighterRun = (currentImageIndexFighterRun + 1) % imagePathsFighterRun.length; // Loop through the images
            }
        });
        timerFighterRun.start();

        Timer timerDragonRun = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexDragonRun = (currentImageIndexDragonRun + 1) % imagePathsDragonRun.length; // Loop through the images
            }
        });
        timerDragonRun.start();

        Timer timerFighterAttack = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexFighterAttack = (currentImageIndexFighterAttack + 1) % imagePathsFighterAttack.length; // Loop through the images
            }
        });
        timerFighterAttack.start();


        Timer timerDragonAttack = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndexDragonAttack = (currentImageIndexDragonAttack + 1) % imagePathsDragonAttack.length; // Loop through the images
            }
        });
        timerDragonAttack.start();



        timerFire = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(FirstTime==0){
                xFire = xDragon;
                yFire = yDragon;
                FirstTime=1;
                }
            if(SideDragon=='L'){

                if (xFire == xFighter   || xFire==40 || xFire==760) {
                    timerFire.stop();
                    FireLabel.setIcon(null);
                }else{
                    ShowFire(FirePicture, xFire, yFire);
                    xFire -= 5;

                }
            }
            if(SideDragon=='R'){
             
             if (xFire == xFighter   || xFire==760) {
                    timerFire.stop();
                    FireLabel.setIcon(null);
                }else{
                    ShowFire(FirePicture, xFire, yFire);
                    xFire += 5;

                }   
            }
                        

  
        }
        
        });
        timerFire.setInitialDelay(0);
      

    
        
        Window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right knight
                    SideFighter = 'R';
                    if( xFighter+ 40 < xDragon){
                        moveFighter(1,1, 0);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // Left knight
                    SideFighter = 'L';
                    moveFighter(1,-1, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) { // Up knight
                    moveFighter(1,0, -1);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) { // Down knight
                    moveFighter(1,0, 1);
                } else if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
                    moveAttack(1);
                }
                //key listener for dragon
                if(e.getKeyChar() == 'd' || e.getKeyChar() == 'D'){
                    SideDragon = 'R';
                    moveFighter(2,1, 0);
                }else if(e.getKeyChar() == 'q' || e.getKeyChar() == 'Q'){
                    SideDragon = 'L';
                    moveFighter(2,-1, 0);
                }else if(e.getKeyChar() == 'z' || e.getKeyChar() == 'Z'){
                    moveFighter(2,0, -1);
                }else if(e.getKeyChar() == 's' || e.getKeyChar() == 'S'){
                    moveFighter(2,0, 1);
                }
                else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    moveAttack(2);
                }

            }
             

                @Override
            public void keyReleased(KeyEvent e) {
                    // Do nothing here, as we are not using keyReleased
                }
            });
        Window.setVisible(true);
    }

    public void moveFighter(int Choice, int dx, int dy) {
        int newX = xFighter + dx * 5;
        int newY = yFighter + dy * 5;
        int newXX=xDragon+dx*5;
        int newYY=yDragon+dy*5;
    if(dx>=0 ){
    if(Choice == 1){
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
                ShowFighter(imagePathsFighterRun[currentImageIndexFighterAttack], imagePathsDragonRun[currentImageIndexDragonRun]);
                      FighterLabel2.setText(" Y " + yFighter);
                      FighterLabel3.setText("  X :" + xFighter);

            }
        }
    }
        if(Choice==2){
        if(newXX>=0 && newXX+40<MATRIX_SIZE && newYY>=0 && newYY+40<MATRIX_SIZE){
            boolean canMove=true;
            for(int i=newXX;i<newXX+40;i++){
            for(int j=newYY;j<newYY+40;j++){
                if(Bmatrix[i][j]==1){
                canMove=false;
                break;
                }
            }
            }
            if(canMove){
            xDragon=newXX;
            yDragon=newYY;
            ShowFighter(imagePathsFighterRun[currentImageIndexFighterRun], imagePathsDragonRun[currentImageIndexDragonRun]);
            FighterLabel5.setText(" Y " + yDragon);
            FighterLabel6.setText("  X :" + xDragon);
            }
        }
    }

}

    if(dx<=0 ){
        if(Choice == 1){
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
                ShowFighter(imagePathsFighterRunInverse[currentImageIndexFighterRun], imagePathsDragonRun[currentImageIndexDragonRun]);
                      FighterLabel2.setText(" Y " + yFighter);
                      FighterLabel3.setText("  X :" + xFighter);

            }
        }

    }

if(Choice==2){
        if(newXX>=0 && newXX+40<MATRIX_SIZE && newYY>=0 && newYY+40<MATRIX_SIZE){
            boolean canMove=true;
            for(int i=newXX;i<newXX+40;i++){
            for(int j=newYY;j<newYY+40;j++){
                if(Bmatrix[i][j]==1){
                canMove=false;
                break;
                }
            }
            }
            if(canMove){
            xDragon=newXX;
            yDragon=newYY;
            ShowFighter(imagePathsFighterRun[currentImageIndexFighterRun], imagePathsDragonRunInverse[currentImageIndexDragonRun]);
            FighterLabel5.setText(" Y " + yDragon);
            FighterLabel6.setText("  X :" + xDragon);
            }
        }
    }

}
    
    }



    public void ShowFighter(String nomImage, String nomImage2) {

        ImageIcon imageIcon = new ImageIcon(nomImage);
        ImageIcon imageIcon2 = new ImageIcon(nomImage2);

        characterLabel.setIcon(imageIcon);
        DragonLabel.setIcon(imageIcon2);

        characterLabel.setBounds(xFighter, yFighter, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        DragonLabel.setBounds(xDragon, yDragon, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
        // characterLabel.repaint();
    }




    public void moveAttack( int Choice)  {
    if(Choice==1){
        if(SideFighter=='R'){
                    if(SideDragon=='R'){
        int newX = xFighter +  7;
        int newY = yFighter ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(imagePathsFighterAttack[currentImageIndexFighterAttack],imagePathsDragonRun[currentImageIndexDragonRun]);
            }
        }
    }
                    if(SideDragon=='L'){
         int newX = xFighter +  7;
        int newY = yFighter ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(imagePathsFighterAttack[currentImageIndexFighterAttack],imagePathsDragonRunInverse[currentImageIndexDragonRun]);
            }
        }

    }
}
        if(SideFighter=='L'){
                         if(SideDragon=='R'){
        int newX = xFighter -  7;
        int newY = yFighter ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(imagePathsFighterAttackInverse[currentImageIndexFighterAttack],imagePathsDragonRun[currentImageIndexDragonRun]);
            }
        }
    }
                         if(SideDragon=='L'){
        int newX = xFighter -  7;
        int newY = yFighter;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xFighter = newX;
                yFighter = newY;
                ShowFighter(imagePathsFighterAttackInverse[currentImageIndexFighterAttack],imagePathsDragonRunInverse[currentImageIndexDragonRun]);
            }
        }
    }
}
}
    if(Choice==2){
     if(SideDragon=='R'){
                          if(SideFighter=='R'){
        int newX = xDragon;
        int newY = yDragon ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                ShowFighter(imagePathsFighterRun[currentImageIndexFighterRun],imagePathsDragonAttack[currentImageIndexDragonAttack]);
                timerFire.start();

            }
        }
    }
                          if(SideFighter=='L'){
         int newX = xDragon ;
        int newY = yDragon ;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                        timerFire.start();

                ShowFighter(imagePathsFighterRunInverse[currentImageIndexFighterRun],imagePathsDragonAttack[currentImageIndexDragonAttack]);
            }
        }

    }
}
     if(SideDragon=='L'){
                       if(SideFighter=='R'){
        int newX = xDragon;
        int newY = yDragon;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                        timerFire.start();

                ShowFighter(imagePathsFighterRun[currentImageIndexFighterRun],imagPathsDragonAttackInverse[currentImageIndexDragonAttack]);
            }
        }
    }
                       if(SideFighter=='L'){
      int newX = xDragon ;
        int newY = yDragon;
        if (newX >= 0 && newX + 40 < MATRIX_SIZE && newY >= 0 && newY + 40 < MATRIX_SIZE) {
            boolean canMove = true;
            for (int i = newX; i < newX + 40; i++) {
                for (int j = newY; j < newY + 40; j++) {
                    if (Bmatrix[i][j] == 1) { // If the pixel is black
                        canMove = false;
                        break;
                    }
                }
            }
            if (canMove) {
                xDragon = newX;
                yDragon = newY;
                        timerFire.start();

                ShowFighter(imagePathsFighterRunInverse[currentImageIndexFighterRun],imagPathsDragonAttackInverse[currentImageIndexDragonAttack]);
            }
        }                  
        
                        

}
}
}


}



public void ShowFire(String nomImage, int x, int y) {

    ImageIcon imageIcon = new ImageIcon(nomImage);
    FireLabel.setIcon(imageIcon);
    FireLabel.setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());

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

