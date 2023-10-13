
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRollerGUI {
    private JFrame frame;
    private JButton rollButton;
    private JLabel resultLabel;
    private JLabel diceImageLabel1;
    private JLabel diceImageLabel2;

    public DiceRollerGUI() {
        frame = new JFrame("Lancer de dés");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        rollButton = new JButton("Lance les dés");
        resultLabel = new JLabel("Lance les dés!");
        diceImageLabel1 = new JLabel();
        diceImageLabel2 = new JLabel();

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        frame.add(rollButton);
        frame.add(resultLabel);
        frame.add(diceImageLabel1);
        frame.add(diceImageLabel2);

        frame.pack();
        frame.setVisible(true);
    }

    private void rollDice() {
        Random random = new Random();
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(20) + 1;
        resultLabel.setText("You rolled " + roll1 + " and " + roll2);

        // Load and display the corresponding dice face images
        String imagePath1 = "./resources/dice" + roll1 + ".png";
        String imagePath2 = "./resources/die20" + roll2 + ".png";
        ImageIcon icon1 = new ImageIcon(imagePath1);
        ImageIcon icon2 = new ImageIcon(imagePath2);
        diceImageLabel1.setIcon(icon1);
        diceImageLabel2.setIcon(icon2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceRollerGUI());
    }
}
