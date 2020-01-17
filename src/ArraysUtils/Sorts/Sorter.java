package ArraysUtils.Sorts;

import ArraysUtils.ArrayValue;
import Utils.Constants;

import java.lang.reflect.Array;

public interface Sorter {

    void sort(ArrayValue[] arr);

    default void pause() {
        try{
            Thread.sleep(Constants.TIME_SLEEP_MILLISECOND);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default int getMaxInt(ArrayValue[] arr) {
        int indexMax = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getValue() > max) {
                max = arr[i].getValue();
                indexMax = i;
            }
        }
        return arr[indexMax].getValue();
    }

    default int getMinInt(ArrayValue[] arr) {
        int minIndex = 0, min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getValue() < min){
                min = arr[i].getValue();
                minIndex = i;
            }
        }
        return arr[minIndex].getValue();
    }

    default void swap(ArrayValue[] arr, int i1, int i2) {
        ArrayValue tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

}
