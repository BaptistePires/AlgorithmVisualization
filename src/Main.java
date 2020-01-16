import ArraysUtils.ArrayManager;
import UI.MyWindow;

public class Main {


    public static void main(String[] args) {
        System.out.println("Starting porgram . . .");
        MyWindow w = new MyWindow();
        w.init();
        while (true) w.repaint();

    }
}
