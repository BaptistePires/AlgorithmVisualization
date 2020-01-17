import ArraysUtils.ArrayManager;
import UI.MyWindow;
import Utils.Constants;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting porgram . . .");
        MyWindow w = new MyWindow();
        w.init();

        double lastRefresh = System.currentTimeMillis();
        double currentTime;
        while (true){
            currentTime = System.currentTimeMillis();
            if(currentTime - lastRefresh >= Constants.SKIP_TICKS) {
                w.repaint();
                lastRefresh = currentTime;
            }
        }

    }
}
