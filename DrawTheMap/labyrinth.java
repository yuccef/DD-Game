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

    public JFrame Window;
    public int[][] Lmatrix;
    public int[][] Bmatrix;
    
    public int xFighter = 0;
    public int yFighter = 40;
    public int xDragon = 720;
    public int yDragon = 520;
    public String PicturesSheet = "../Project/Ressource/CharactersMvmnt/KnightMvmnt1/";
    public String PicturesSheet2 = "../Project/Ressource/CharactersMvmnt/FirstDragon/";
    public String FirePicture ="../Project/Ressource/CharactersMvmnt/FirstDragon/FireInversed.png";

    public JLabel characterLabel;
    public JLabel DragonLabel;
    public JLabel FireLabel;
    public int currentImageIndexFighterRun = 0;
    public int currentImageIndexFighterAttack=0;
    public int currentImageIndexDragonRun = 0;
    public int currentImageIndexDragonAttack = 0;

    Timer timerFire; 
    int xFire; 
    int yFire; 
    int FirstTime=0;
    int SetFire=0;


    public char SideDragon, SideFighter;
    JLabel FighterLabelRightSideLife;
    JLabel FighterLabelRightSideName;
    JLabel DragonLabelRightSideName;
    JLabel DragonLabelRightSideLife;


    //Objects
    FighterCaracter Bnadem = new FighterCaracter( "Youssef ",   400, 10, 10, xFighter, yFighter);
    Dragon Dragon = new Dragon("Dragon", 400, 20, 20, xDragon, yDragon);



    //Pictures Path
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
    




    //Methods
    public labyrinth() {



        Window = new JFrame("Affichage de photos");
        Window.setSize(800, 785);
        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //RightSide Panel
        JPanel RightSide = new JPanel();
        RightSide.setLayout(null); 
        RightSide.setBounds(800, 0, 285, 597);
        RightSide.setBackground(Color.decode("#e8dfdb"));
        LineBorder border = new LineBorder(Color.decode("#365979"), 10, true);
        LineBorder border1 = new LineBorder(Color.decode("#8bb1c4"), 5, true);
        LineBorder border2 = new LineBorder(Color.decode("#b96343"), 5, true);
        RightSide.setBorder(border);

        //Life Panels 
        JPanel FighterLifePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(Bnadem.score>200){
                    g.setColor(Color.GREEN);
                }else if(Bnadem.score>100){
                    g.setColor(Color.YELLOW);
                }else{
                    g.setColor(Color.RED);
                }
                
                int width = (int) ((Bnadem.score / (double) 400) * getWidth());
                g.fillRect(0, 0, width, getHeight());
            }
        };
            FighterLifePanel.setBounds(20, 345, 110, 40);
            FighterLifePanel.setBorder(border1);


        JPanel DragonLifePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(Dragon.score>200){
                    g.setColor(Color.GREEN);
                }else if(Dragon.score>100){
                    g.setColor(Color.YELLOW);
                }else{
                    g.setColor(Color.RED);
                }
                
                int width = (int) ((Dragon.score / (double) 400) * getWidth());
                g.fillRect(0, 0, width, getHeight());
            }
        };
            DragonLifePanel.setBounds(160, 345, 110, 40);
            DragonLifePanel.setBorder(border1);


        //Fonts     
        Font FontForTitle = new Font("Comic Sans MS", Font.BOLD, 20);
        Font FontForTimer = new Font("Courier New", Font.BOLD, 14);
        Font FontForNames = new Font("Georgia", Font.BOLD, 16);
        Font FontForLife = new Font("lucida Handwriting", Font.BOLD, 10);




        //RightSide Label (Title Label)
        JLabel TitleLabel = new JLabel("  Jeu de combat");
        TitleLabel.setBorder(border);
        TitleLabel.setFont(FontForTitle);
        TitleLabel.setForeground(Color.decode("#7e5835"));
        TitleLabel.setOpaque(true);
        TitleLabel.setBackground(Color.decode("#d1c0b9"));
        TitleLabel.setBounds(40, 60, 220, 50);

         // RightSide (Timer Label)
        JLabel RightSideLabelTimer = new JLabel("0");
        Timer RightSidetimer = new Timer(1000, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                RightSideLabelTimer.setText("Timer : " + count + "s");
            }
        });

        RightSidetimer.start();
        RightSideLabelTimer.setBounds(170, 6,    110, 30);
        RightSideLabelTimer.setBorder(border2);
        RightSideLabelTimer.setFont(FontForTimer);
        RightSideLabelTimer.setForeground(Color.decode("#425b8a"));
        RightSideLabelTimer.setOpaque(true);
        RightSideLabelTimer.setBackground(Color.decode("#d1c0b9"));



        //Fighter Label

        //picture
        JLabel FighterLabelRightSidePicture = new JLabel();
        FighterLabelRightSidePicture.setBounds(20, 210, 110,    124);
        ImageIcon imageIconFighterLabelRightSidePicture = new ImageIcon("../Project/Ressource/CharactersMvmnt/KnightMvmnt1/IconeFighter.png");
        Image imageFighterLabelRightSidePicture = imageIconFighterLabelRightSidePicture.getImage();
        Image newImageFighterLabelRightSidePicture = imageFighterLabelRightSidePicture.getScaledInstance(124, 124, Image.SCALE_SMOOTH); 
        imageIconFighterLabelRightSidePicture = new ImageIcon(newImageFighterLabelRightSidePicture); 
        FighterLabelRightSidePicture.setIcon(imageIconFighterLabelRightSidePicture);
        FighterLabelRightSidePicture.setBorder(border1);

        //name
        FighterLabelRightSideName = new JLabel("    "+Bnadem.name);
        FighterLabelRightSideName.setBorder(border1);
        FighterLabelRightSideName.setFont(FontForNames);
        FighterLabelRightSideName.setForeground(Color.decode("#425b8a"));
        FighterLabelRightSideName.setOpaque(true);
        FighterLabelRightSideName.setBackground(Color.decode("#d1c0b9"));
        FighterLabelRightSideName.setBounds(20, 150, 110, 50);

        //life
        FighterLabelRightSideLife = new JLabel("Vie:"+ Bnadem.score +"  ") ;
        FighterLabelRightSideLife.setFont(FontForLife);
        FighterLabelRightSideLife.setForeground(Color.decode("#425b8a"));    
        FighterLabelRightSideLife.setBounds(20, 300, 120, 50);


        // Dragon Label

        //picture
        JLabel DragonLabelRightSidePicture = new JLabel();
        DragonLabelRightSidePicture.setBounds(160, 210, 110,    124);
        ImageIcon imageIconDragonLabelRightSidePicture = new ImageIcon("../Project/Ressource/CharactersMvmnt/FirstDragon/DragonIcone.png");
        Image imageDragonLabelRightSidePicture = imageIconDragonLabelRightSidePicture.getImage();
        Image newImageDragonLabelRightSidePicture = imageDragonLabelRightSidePicture.getScaledInstance(124, 124, Image.SCALE_SMOOTH); 
        imageIconDragonLabelRightSidePicture = new ImageIcon(newImageDragonLabelRightSidePicture); 
        DragonLabelRightSidePicture.setIcon(imageIconDragonLabelRightSidePicture);
        DragonLabelRightSidePicture.setHorizontalAlignment(SwingConstants.CENTER);
        DragonLabelRightSidePicture.setVerticalAlignment(SwingConstants.CENTER);
        DragonLabelRightSidePicture.setBorder(border1);

        //name
        DragonLabelRightSideName = new JLabel("    "+ Dragon.name);
        DragonLabelRightSideName.setBorder(border1);
        DragonLabelRightSideName.setFont(FontForNames);
        DragonLabelRightSideName.setForeground(Color.decode("#425b8a"));
        DragonLabelRightSideName.setOpaque(true);
        DragonLabelRightSideName.setBackground(Color.decode("#d1c0b9"));
        DragonLabelRightSideName.setBounds(160, 150, 110, 50);

        //life
        DragonLabelRightSideLife = new JLabel("  Score :"+ Bnadem.score+"  ") ;
        DragonLabelRightSideLife.setFont(FontForLife);
        DragonLabelRightSideLife.setForeground(Color.decode("#425b8a"));
        DragonLabelRightSideLife.setBounds(160, 350, 110, 50);
        

        //Add to Life Panel
        FighterLifePanel.add(FighterLabelRightSideLife);
        DragonLifePanel.add(DragonLabelRightSideLife);

        //Add to RightSide Panel
        RightSide.add(FighterLabelRightSidePicture);
        RightSide.add(DragonLabelRightSidePicture);

        RightSide.add(FighterLabelRightSideName);
        RightSide.add(DragonLabelRightSideName);

        RightSide.add(TitleLabel);
        RightSide.add(RightSideLabelTimer);

        RightSide.add(DragonLifePanel);
        RightSide.add(FighterLifePanel);

        //Add to Window
        Window.add(RightSide);
        Window.setLayout(null);



        
        //Map Panel
        JPanel DrawLabyrinthPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Image RoadMap = new ImageIcon("../Project/Ressource/MapPixels/labyrinth1.jpg").getImage();
                Image WallMap = new ImageIcon("../Project/Ressource/MapPixels/labyrinth2.jpg").getImage();
               
                 MapMaths MapManage = new MapMaths();

                Lmatrix = MapManage.loadMap();
                Bmatrix = MapManage.CreatTheBigMatrix(Lmatrix);   

                for(int i=0; i<800; i=i+40){
                    for(int j=0; j<800; j=j+40){
                        if(Bmatrix[i][j] == 0){
                            g.drawImage(RoadMap, i , j, this);
                        }
           
                    }
                }

                for(int i=0; i<20;i++){
                    for(int j=0; j<20; j++){
                        if(Lmatrix[i][j] == 1){
                            g.drawImage(WallMap, i*40 , j*40, this);
                        }
                    }   
                }

        }             
    };

        //Show the fighter and the dragon and Fire
        characterLabel = new JLabel();
        DragonLabel = new JLabel();
        FireLabel = new JLabel();

        //Initial Position
        characterLabel.setBounds(xFighter, yFighter, 40, 40);
        DragonLabel.setBounds(xDragon, yDragon, 40, 40);
        FireLabel.setBounds(xFire, yFire, 40, 40);

        //Add to Panel
        DrawLabyrinthPanel.setBounds(0, 0, 800, 635);
        DrawLabyrinthPanel.setLayout(null); 
        DrawLabyrinthPanel.add(DragonLabel);
        DrawLabyrinthPanel.add(characterLabel);
        DrawLabyrinthPanel.add(FireLabel);


        //Show the Window
        Window.setSize(new Dimension(1100, 635));
        Window.setResizable(false);
        Window.add(DrawLabyrinthPanel);




        

        //Timer for the fighter and the dragon
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
                 
                    if(xFire==xFighter && yFire==yFighter){
                    timerFire.stop();
                    FireLabel.setIcon(null);
                    Dragon.DamageDragonFighterCaracter(Bnadem, Dragon);
                    Bnadem.FighterCaracterUpdateDealth(Bnadem);
                    Bnadem.lose(Bnadem);
                    FighterLabelRightSideLife.setText(" Vie : " + Bnadem.score);
                    FighterLifePanel.repaint();
                }
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
                    FirstTime=0;    

                }else{
                    ShowFire(FirePicture, xFire, yFire);
                    xFire += 5;

                }   
            }
                        

  
        }
    
        });
        timerFire.setInitialDelay(0);
      

    
        //Key Listener
        Window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //key listener for knight
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // Right knight
                    SideFighter = 'R';
                    if (yFighter!=yDragon){
                        moveFighter(1,1, 0);
                    }else{
                        if(xFighter+40<=xDragon){
                            moveFighter(1,1, 0);
                }
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
                      //FighterLabelRightSideName.setText(" Y " + yFighter);
                      //FighterLabelRightSideLife.setText("  X :" + xFighter);

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
                     // FighterLabelRightSideName.setText(" Y " + yFighter);
                     // FighterLabelRightSideLife.setText("  X :" + xFighter);

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
                FirstTime=0;

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
                        FirstTime=0;

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
                        FirstTime=0;

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
                        FirstTime=0;

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

