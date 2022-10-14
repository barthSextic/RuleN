import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    public Panel() {

        JPanel square = new Panel();

        square.setSize(10, 10);
        square.setVisible(true);
        square.setForeground(Color.BLACK);

    }

}
