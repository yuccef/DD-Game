import javax.swing.*;
import java.awt.*;
 
public class Dessin extends JPanel {
     
    public Dessin() {
        setBackground(Color.RED);
    }
     
    public void paintcomponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 200, 900);
    }
 
}
