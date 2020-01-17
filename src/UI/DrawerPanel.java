package UI;

import ArraysUtils.ArrayManager;

import javax.swing.*;
import java.awt.*;

public class DrawerPanel extends JPanel {


    private ArrayManager ah;
    private int ARR_SIZE = Math.max(MyWindow.WINDOW_HEIGHT, MyWindow.WINDOW_WIDTH);
    private double lastCounterReset;
    private int fpsCounter;
    private int fpsCounterBuffer;
    private Font panelFont;

    public DrawerPanel() {
        setBackground(Color.BLACK);
        ah = new ArrayManager(ARR_SIZE);
        lastCounterReset = System.currentTimeMillis();
        fpsCounter = 0;
        fpsCounterBuffer = 0;
        panelFont = new Font("Serrif", Font.BOLD, 15);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawArray(g2d);
        drawText(g2d);
        updateFPSCounter();
    }

    public void drawText(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(panelFont);
        g2d.drawString("FPS : " + Integer.toString(fpsCounterBuffer), 10, 25);
        g2d.drawString("Current algorithm : " + ah.currentAlgoName, 10, 45);
    }
    public void drawArray(Graphics2D g2d) {
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
            g2d.setColor(ah.getColorFromInt(ah.intArray[i]));
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    public void updateFPSCounter() {
        double now = System.currentTimeMillis();
        fpsCounter++;
        if(now - lastCounterReset >= 1000d){
            fpsCounterBuffer = fpsCounter;
            fpsCounter =0;
            lastCounterReset = System.currentTimeMillis();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MyWindow.WINDOW_WIDTH, MyWindow.WINDOW_HEIGHT);
    }

}
