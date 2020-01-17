package ArraysUtils.Sorts;

import ArraysUtils.ArrayValue;
import Utils.Constants;

public interface Sorter {

    void sort(ArrayValue[] arr);

    default void pause() {
        try{
            Thread.sleep(Constants.TIME_SLEEP_MILLISECOND);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
