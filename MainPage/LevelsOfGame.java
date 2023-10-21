import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelsOfGame {

    private JFrame fenetreLevels;

    public void showLevelsButton() {
        fenetreLevels = new JFrame("Choisir le niveau souhaité");
        fenetreLevels.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JButton easyButton = createLevelButton("Facile");
        JButton midButton = createLevelButton("Moyenne");
        JButton diffButton = createLevelButton("Difficile");

        mainPanel.add(easyButton);
        mainPanel.add(midButton);
        mainPanel.add(diffButton);

        fenetreLevels.add(mainPanel);

        fenetreLevels.setSize(400, 200);
        fenetreLevels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreLevels.setVisible(true);
    }

    private JButton createLevelButton(String label) {
        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension(200, 50));
BeginTheGame commencerlejeu = new BeginTheGame();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Niveau " + label);
            commencerlejeu.MapOfTheGame();;
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LevelsOfGame gameLevels = new LevelsOfGame();
                gameLevels.showLevelsButton();
            }
        });
    }
}
