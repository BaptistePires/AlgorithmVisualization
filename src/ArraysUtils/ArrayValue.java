package ArraysUtils;

import java.awt.*;

public class ArrayValue {

    private int value;
    private Color color;

    public ArrayValue(int v, Color c){
        value = v;
        color = c;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

