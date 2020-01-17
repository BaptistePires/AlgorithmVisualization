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


    void drawArray(Graphics2D g2d) {
        float stroke = (float) MyWindow.WINDOW_WIDTH / (float) Constants.ARRAY_SIZE;
        if (stroke <= 0) stroke = 1;
        Stroke stroke3 = new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(stroke3);
        int x1, y1, x2, y2;
        for (int i = 0; i < Constants.ARRAY_SIZE; i++) {
            x1 = Math.min(i * (int) stroke, MyWindow.WINDOW_WIDTH);
            y1 = MyWindow.WINDOW_HEIGHT;
            x2 = Math.min(i * (int) stroke, MyWindow.WINDOW_WIDTH);
            float hRatio = (float) ah.intArray[i].getValue() / (float) ah.max;
            y2 = MyWindow.WINDOW_HEIGHT - (int) (MyWindow.WINDOW_HEIGHT * hRatio);
            g2d.setColor(ah.intArray[i].getColor());
            g2d.drawLine(x1, y1, x2, y2);
        }
    }





}
