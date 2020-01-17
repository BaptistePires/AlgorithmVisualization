package ArraysUtils.Sorts;

import ArraysUtils.ArrayValue;

import java.awt.*;

import static ArraysUtils.ArrayManager.getColorFromInt;

public class SelectionSort implements Sorter {
    @Override
    public void sort(ArrayValue[] arr) {
        int tmpIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i].setColor(Color.WHITE);
            tmpIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getValue() < arr[tmpIndex].getValue()) tmpIndex = j;
            }
            ArrayValue tmp = arr[tmpIndex];
            arr[tmpIndex] = arr[i];
            arr[i] = tmp;
            arr[tmpIndex].setColor(getColorFromInt(arr[tmpIndex].getValue()));
            pause();
        }
    }
}
