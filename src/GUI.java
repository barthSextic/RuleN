import javax.swing.*;
import java.awt.*;


public class GUI  extends JFrame {

    private final int DIMENSION = 511;
    // constructor
    public GUI() {

        JFrame screen = new JFrame();

        screen.setSize(DIMENSION, DIMENSION);
        screen.setTitle("Rule N - Rick Howell");
        screen.setBackground(new Color(100, 200, 250));

        screen.setVisible(true);

        new Panel();

        screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public int getSideLength() {
        return DIMENSION;
    }

}
