package ArraysUtils.Sorts;

import ArraysUtils.ArrayManager;
import ArraysUtils.ArrayValue;

import java.awt.*;
import java.util.Arrays;

public class CountingSort implements Sorter {
    @Override
    public void sort(ArrayValue[] arr) {
        int max = getMaxInt(arr);
        int[] counter = new int[max + 1];
        Arrays.fill(counter, 0);
        countIntElements(arr, counter);
        int tmpIndex = 0;
        for(int i = 0; i < counter.length; i++) {
            arr[i].setColor(Color.WHITE);
            while (counter[i] > 0){
                arr[tmpIndex++].setValue(i);
                counter[i]--;
            }
            arr[i].setColor(ArrayManager.getColorFromInt(arr[i].getValue()));
            pause();
        }
    }

    public void countIntElements(ArrayValue[] arr, int[] counter) {
        for(ArrayValue ar: arr) {
            counter[ar.getValue()]++;
        }
    }
}
