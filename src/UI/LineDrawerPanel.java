package UI;

import ArraysUtils.ArrayManager;
import Utils.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DrawerPanel extends BasePanel {


    private ArrayManager ah;
    private int ARR_SIZE = Math.max(MyWindow.WINDOW_HEIGHT, MyWindow.WINDOW_WIDTH);
//    private int ARR_SIZE = 800;
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

    private void drawText(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(panelFont);
        g2d.drawString("FPS : " + Integer.toString(fpsCounterBuffer) + " [cap : " + (int)Constants.FRAMES_PER_SEC +"]", 10, 25);
        g2d.drawString("Current algorithm : " + ah.currentAlgoName, 10, 45);
        g2d.drawString("Array length : " + ah.size, 10, 65);
    }

    private void drawArray(Graphics2D g2d) {
        float stroke = (float) MyWindow.WINDOW_WIDTH / (float) ARR_SIZE;
        if (stroke <= 0) stroke = 1;
        Stroke stroke3 = new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(stroke3);
        int x1, y1, x2, y2;
        for (int i = 0; i < ARR_SIZE; i++) {
            x1 = Math.min(i * (int) stroke, MyWindow.WINDOW_WIDTH);
            y1 = MyWindow.WINDOW_HEIGHT;
            x2 = Math.min(i * (int) stroke, MyWindow.WINDOW_WIDTH);
            float hRatio = (float) ah.intArray[i].getValue() / (float) ah.max;
            y2 = MyWindow.WINDOW_HEIGHT - (int) (MyWindow.WINDOW_HEIGHT * hRatio);
            g2d.setColor(ah.intArray[i].getColor());

            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    private void updateFPSCounter() {
        double now = System.currentTimeMillis();
        fpsCounter++;
        if(now - lastCounterReset >= 1000d){
            fpsCounterBuffer = fpsCounter;
            fpsCounter =0;
            lastCounterReset = System.currentTimeMillis();
        }
    }



}
