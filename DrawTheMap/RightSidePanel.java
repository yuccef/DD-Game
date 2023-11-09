package DrawTheMap;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TheDragon.Dragon;
import TheFighter.FighterCaracter;



public class RightSidePanel extends JPanel {

    public labyrinth labyrinthRightSidePanel;

    public GameTimers gameTimers;
    public JLabel FighterLabelRightSideLife;
    public JLabel FighterLabelRightSideName;
    public JLabel DragonLabelRightSideName;
    public JLabel DragonLabelRightSideLife;

    public JPanel FighterLifePanel;
    public JPanel DragonLifePanel;


    public void RightSidePanel(labyrinth labyrinth) {
        labyrinthRightSidePanel = labyrinth;
        labyrinth labyrinth2= this.labyrinthRightSidePanel;
        //labyrinth labyrinth2 = this.labyrinthRightSidePanel;
        Dragon Dragon = labyrinth2.getDragon();
        FighterCaracter Bnadem = labyrinth2.getBnadem();

        setLayout(null);
        setBounds(800, 0, 285, 597);
        setBackground(Color.decode("#e8dfdb"));
        LineBorder border = new LineBorder(Color.decode("#365979"), 10, true);
        LineBorder border1 = new LineBorder(Color.decode("#8bb1c4"), 5, true);
        LineBorder border2 = new LineBorder(Color.decode("#b96343"), 5, true);
        setBorder(border);
        //Fonts     
        Font FontForTitle = new Font("Comic Sans MS", Font.BOLD, 20);
        Font FontForTimer = new Font("Courier New", Font.BOLD, 14);
        Font FontForNames = new Font("Georgia", Font.BOLD, 16);
        Font FontForLife = new Font("lucida Handwriting", Font.BOLD, 10);

        // Life Panels
           FighterLifePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (Bnadem.score > 200) {
                    g.setColor(Color.GREEN);
                } else if (Bnadem.score > 100) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.RED);
                }

                int width = (int) ((Bnadem.score / (double) 400) * getWidth());
                g.fillRect(0, 0, width, getHeight());
            }
        };
        FighterLifePanel.setBounds(20, 345, 110, 40);
        FighterLifePanel.setBorder(border1);

         DragonLifePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (Dragon.score > 200) {
                    g.setColor(Color.GREEN);
                } else if (Dragon.score > 100) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.RED);
                }

                int width = (int) ((Dragon.score / (double) 400) * getWidth());
                g.fillRect(0, 0, width, getHeight());
            }
        };
        DragonLifePanel.setBounds(160, 345, 110, 40);
        DragonLifePanel.setBorder(border1);

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
        
        // Add components to the panel
        add(FighterLabelRightSidePicture);
        add(DragonLabelRightSidePicture);

        add(FighterLabelRightSideName);
        add(DragonLabelRightSideName);

        add(TitleLabel);
        add(RightSideLabelTimer);

        add(DragonLifePanel);
        add(FighterLifePanel);

        add(FighterLabelRightSideLife);
        add(DragonLabelRightSideLife);
        FighterLifePanel.add(FighterLabelRightSideLife);
        DragonLifePanel.add(DragonLabelRightSideLife);

  
  
    }   
     
}    

