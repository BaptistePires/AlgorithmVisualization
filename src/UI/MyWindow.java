package UI;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public final static String TITLE = "AlgorithmVisualization";

    public final static int WINDOW_WIDTH = 800;
    public final static int WINDOW_HEIGHT = 800;

    private BasePanel drawer;

    public MyWindow() {
        drawer = new CircleDrawerPanel();
    }

    public void init() {
        setTitle(MyWindow.TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
//        this.add(new HomePanel(), BorderLayout.CENTER);
        this.add(drawer, BorderLayout.CENTER);
        this.pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
