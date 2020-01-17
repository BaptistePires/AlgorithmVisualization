package UI;


import Utils.Constants;

import java.awt.*;

public class CircleDrawerPanel extends SortingDrawerPanel {


    CircleDrawerPanel() {
        super();

    }

    @Override
    void drawArray(Graphics2D g) {
        int w, h;
        float sizeRatio;
        int diag = getWidth() * getWidth() + getHeight() * getHeight();
        int r = Math.min(getHeight(), getWidth()) / 2;
        float strokeVal = (float) r / ah.size;
        if (strokeVal < 1) strokeVal = 1;
        int x, y;
        for(int i = 0; i < Constants.ARRAY_SIZE; i++) {
            g.setColor(ah.intArray[i].getColor());
            sizeRatio = (float)ah.intArray[i].getValue() / ah.max;
            x = (int) (i * strokeVal);
            y = (int) (i * strokeVal);
            w = getWidth() - (2 * x);
            h = getHeight() - (2 * y);
            g.drawOval(x, y, w, h);


        }


    }
}
