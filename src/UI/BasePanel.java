package UI;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MyWindow.WINDOW_WIDTH, MyWindow.WINDOW_HEIGHT);
    }
}
