package UI;

import ArraysUtils.ArrayManager;
import Utils.Constants;

import java.awt.*;

public class SortingDrawerPanel extends BasePanel {

    double lastCounterReset;
    int fpsCounter;
    int fpsCounterBuffer;
    Font panelFont;
    ArrayManager ah;

    SortingDrawerPanel() {
        setBackground(Color.BLACK);
        ah = new ArrayManager(Constants.ARRAY_SIZE);
        lastCounterReset = System.currentTimeMillis();
        fpsCounter = 0;
        fpsCounterBuffer = 0;
        panelFont = new Font("Serrif", Font.BOLD, 15);
        ah.launchAllSorts();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawArray(g2d);
        drawText(g2d);
        updateFPSCounter();
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

    private void drawText(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(panelFont);
        g2d.drawString("FPS : " + Integer.toString(fpsCounterBuffer) + " [cap : " + (int) Constants.FRAMES_PER_SEC +"]", 10, 25);
        g2d.drawString("Current algorithm : " + ah.currentAlgoName, 10, 45);
        g2d.drawString("Array length : " + ah.size, 10, 65);
    }

    void drawArray(Graphics2D g) {}
}
