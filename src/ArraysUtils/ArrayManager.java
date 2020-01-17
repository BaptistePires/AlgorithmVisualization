package ArraysUtils;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayManager {

    public final int TIME_SLEEP_MILLISECOND = 20;
    public final int MICRO_PAUSE = 1;

    //    public static int ARRAY_SIZE = 100;
    public ArrayValue[] intArray;
    public int size;
    public int max, min;
    private int arrayAccesses;
    public String currentAlgoName;

    public ArrayManager(int size) {
        this.size = size;
        intArray = new ArrayValue[size];
        max = size;
        min = 1;
        arrayAccesses = 0;
        currentAlgoName = "";
        init();
    }

    public void init() {
        int i = 0;
        for (i = 0; i < size; i++) {
            intArray[i] = new ArrayValue(i, getColorFromInt(i));
        }

        Runnable r = () -> {

            System.out.println("Shuffling array . . .");
            shuffle();
            System.out.println("Starting insertion sort . . .");
            selectionSort();
            System.out.println("Insertion sort over");
            System.out.println("Shuffling array . . .");
            shuffle();
            System.out.println("Starting bubble sort . . .");
            bubbleSort();
            System.out.println("Bubble sort over");
        };
        new Thread(r).start();


    }

    public void shuffle() {
        List<ArrayValue> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
    }

    public void insertionSort() {
        currentAlgoName = "Insertion Sort";
        ArrayValue saveVal;
        int j;
        for (int i = 1; i < intArray.length; i++) {
            intArray[i].setColor(Color.WHITE);
            saveVal = intArray[i];

            j = i - 1;
            intArray[j].setColor(Color.WHITE);
            while (j >= 0 && intArray[j].getValue() > saveVal.getValue()) {
                intArray[j + 1] = intArray[j];
                j--;
                intArray[j + 1].setColor(getColorFromInt(intArray[j + 1].getValue()));
            }
            intArray[j + 1] = saveVal;
            pause(TIME_SLEEP_MILLISECOND);
            intArray[j+1].setColor(getColorFromInt(intArray[j+1].getValue()));
        }
    }

    public void bubbleSort() {
        currentAlgoName = "Bubble Sort";
        ArrayValue tmp;
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int j = 0; j < intArray.length - i - 1; j++) {
                if (intArray[j].getValue() > intArray[j + 1].getValue()) {
                    tmp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = tmp;
                }
            }
            pause(TIME_SLEEP_MILLISECOND);
        }
    }

    public void selectionSort() {
        currentAlgoName = "Selection sort";
        int tmpIndex;
        for(int i = 0; i < intArray.length - 1; i++) {
            intArray[i].setColor(Color.WHITE);
            tmpIndex = i;
            for (int j = i + 1; j < intArray.length; j++) {
                if(intArray[j].getValue() < intArray[tmpIndex].getValue()) tmpIndex = j;
            }
            ArrayValue tmp = intArray[tmpIndex];
            intArray[tmpIndex] = intArray[i];
            intArray[i] = tmp;
            intArray[tmpIndex].setColor(getColorFromInt(intArray[tmpIndex].getValue()));
            pause(TIME_SLEEP_MILLISECOND);
        }
    }

    public void pause(int milliS) {
        try {
            Thread.sleep(milliS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getArrayAccesses() {
        return arrayAccesses;
    }

    public void setArrayAccesses(int arrayAccesses) {
        this.arrayAccesses = arrayAccesses;
    }

    public Color getColorFromInt(int x) {
        if (x == 0) x++;
        return Color.getHSBColor((float) x / size , .8f, 0.8f);
    }
}
