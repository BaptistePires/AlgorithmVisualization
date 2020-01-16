package UI;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public final static String TITLE = "AlgorithmVisualization";

    public final static int WINDOW_WIDTH = 1920;
    public final static int WINDOW_HEIGHT = 1080;

    private DrawerPanel drawer;

    public MyWindow() {
        drawer = new DrawerPanel();
    }

    public void init() {
        setTitle(MyWindow.TITLE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        this.add(drawer, BorderLayout.CENTER);
        this.pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
