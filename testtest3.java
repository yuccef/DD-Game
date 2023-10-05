import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testtest3 {
    private JFrame fenetre;
    private JLabel imageLabel1;
    private JLabel imageLabel2;
    private Timer timer;
    private int x1 = 0; // Position en x de la première image
    private int x2 = 800; // Position en x de la deuxième image

    public testtest3(){
        fenetre = new JFrame("Animation de photos");
        fenetre.setSize(800, 600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);

        imageLabel1 = new JLabel(new ImageIcon("../project/caracteresIcone/positionTwoChevalier.png"));
        imageLabel2 = new JLabel(new ImageIcon("../project/caracteresIcone/positionOneChevalier.png"));

        fenetre.add(imageLabel1);
        fenetre.add(imageLabel2);
        imageLabel1.setBounds(x1, 220, 100, 100); // Position et taille de la première image
        imageLabel2.setBounds(x2, 220, 100, 100); // Position et taille de la deuxième image

    }
}