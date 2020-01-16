package UI;

import ArraysUtils.ArrayManager;

import javax.swing.*;
import java.awt.*;

public class DrawerPanel extends JPanel {


    private ArrayManager ah;
    private int ARR_SIZE = Math.max(MyWindow.WINDOW_HEIGHT, MyWindow.WINDOW_WIDTH);

    public DrawerPanel() {
        setBackground(Color.BLACK);
        ah = new ArrayManager(ARR_SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Getting the width of lines to fill in width panel.
        float stroke = (float) MyWindow.WINDOW_WIDTH / (float) ARR_SIZE;
        if (stroke <= 0) stroke = 1;
        g2d.setStroke(new BasicStroke(stroke));
        int x1, y1, x2, y2;
        for (int i = 0; i < ARR_SIZE; i++) {
            x1 = Math.min(i * (int) stroke, MyWindow.WINDOW_WIDTH);
            y1 = MyWindow.WINDOW_HEIGHT;
            x2 = Math.min(i * (int) stroke, MyWindow.WINDOW_WIDTH);
            float hRatio = (float) ah.intArray[i] / (float) ah.max;
            y2 = MyWindow.WINDOW_HEIGHT - (int) (MyWindow.WINDOW_HEIGHT * hRatio);
            g2d.setColor(ah.getColorFromInt(i));
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MyWindow.WINDOW_WIDTH, MyWindow.WINDOW_HEIGHT);
    }

}
