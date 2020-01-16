package ArraysUtils;

import UI.DrawerPanel;
import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayManager {

    public int TIME_SLEEP_MILLISECOND = 20;

    //    public static int ARRAY_SIZE = 100;
    public Integer[] intArray;
    public int size;

    public int max, min;

    public ArrayManager(int size) {
        this.size = size;
        intArray = new Integer[size];
        max = size;
        min = 1;
        init();
    }

    public void init() {
        int i = 0;
        int tmp;
        for (i = 0; i <size; i++) {
            intArray[i] = i+1;
        }

        Runnable r = () -> {
            pause(1000);
            System.out.println("Shuffling array . . .");
            shuffle();
            System.out.println("Starting insertion sort . . .");
            insertionSort();
            System.out.println("Insertion sort over");
            System.out.println("Shuffling array . . .");
            shuffle();
            System.out.println("Starting bubble sort . . .");
            bubbleSort();
            System.out.println("Bubble sort over");
        };
        new Thread(r).start();

    }

    public Color getColorFromInt(int x) {
        if(x==0)x++;
        return Color.getHSBColor((float) x / size, 1.0f, 1.0f);
    }

    public void shuffle() {
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
    }

    public void insertionSort() {

        int saveVal, j;
        for(int i = 1; i < intArray.length; i++) {
            saveVal = intArray[i];
            j = i - 1;

            while(j >= 0 && intArray[j] > saveVal) {
                intArray[j + 1] = intArray[j];
                j--;
            }
            intArray[j + 1] = saveVal;
            pause(TIME_SLEEP_MILLISECOND);
        }
    }

    public void bubbleSort() {
        int tmp;
        for(int i = 0; i < intArray.length - 1; i++) {
            for(int j = 0;  j < intArray.length - i -1; j++) {
                if(intArray[j] > intArray[j+1]){
                    tmp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = tmp;
                }
            }
            pause(10);
        }
    }

    public void pause(int milliS) {
        try {
            Thread.sleep(milliS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
