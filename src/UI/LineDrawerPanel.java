package UI;

import ArraysUtils.ArrayManager;
import Utils.Constants;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LineDrawerPanel extends SortingDrawerPanel {


    //private int ARR_SIZE = Math.max(MyWindow.WINDOW_HEIGHT, MyWindow.WINDOW_WIDTH);
//    private int ARR_SIZE = 800;

    @Override
    void drawArray(Graphics2D g2d) {
        float stroke = (float) getWidth() / (float) ah.size;
        if (stroke < 1) stroke = 1;
//        Stroke stroke3 = new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(new BasicStroke(stroke));
        int x1, y1, x2, y2;
        for (int i = 0; i < ah.size; i++) {
            x1 = (i * (int)stroke) + (int)stroke ;
            y1 = getHeight();
            float hRatio = (float) ah.intArray[i].getValue() / (float) ah.max;
            y2 = getHeight() - (int) (getHeight()* hRatio);
            g2d.setColor(ah.intArray[i].getColor());
            g2d.drawLine(x1, y1, x1, y2);
        }


    }





}
