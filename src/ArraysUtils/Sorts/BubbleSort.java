package ArraysUtils.Sorts;

import ArraysUtils.ArrayValue;

import static Utils.Constants.TIME_SLEEP_MILLISECOND;

public class BubbleSort implements Sorter {

    @Override
    public void sort(ArrayValue[] arr) {
        ArrayValue tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].getValue() > arr[j + 1].getValue()) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            pause();
        }
    }
}
