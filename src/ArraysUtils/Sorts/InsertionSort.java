package ArraysUtils.Sorts;

import ArraysUtils.ArrayValue;

import java.awt.*;

import static ArraysUtils.ArrayManager.getColorFromInt;

public class InsertionSort implements Sorter{
    @Override
    public void sort(ArrayValue[] arr) {
        ArrayValue saveVal;
        int j;
        for (int i = 1; i < arr.length; i++) {
            arr[i].setColor(Color.RED);
            saveVal = arr[i];

            j = i - 1;
            arr[j].setColor(Color.WHITE);
            while (j >= 0 && arr[j].getValue() > saveVal.getValue()) {
                arr[j + 1] = arr[j];
                j--;
                arr[j + 1].setColor(getColorFromInt(arr[j + 1].getValue()));
            }
            arr[j + 1] = saveVal;
            pause();
            arr[j+1].setColor(getColorFromInt(arr[j+1].getValue()));
        }
    }
}
