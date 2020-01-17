package ArraysUtils;

import ArraysUtils.Sorts.*;
import Utils.Constants;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.awt.*;
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
        for (int i = 0; i < size; i++) {
            intArray[i] = new ArrayValue(i, getColorFromInt(i));
        }
    }

    public void launchAllSorts() {


        Runnable r = () -> {

            System.out.println("Shuffling array . . .");
            currentAlgoName = "Shuffling";
            shuffle();
            System.out.println("Starting Counting sort . . .");
            currentAlgoName = "Counting sort";
            new CountingSort().sort(intArray);
            System.out.println("Shuffling . . .");
            shuffle();
            System.out.println("Starting insertion sort . . .");
            currentAlgoName = "Insertion sort";
            new InsertionSort().sort(intArray);
            System.out.println("Insertion sort over");
            System.out.println("Shuffling array . . .");
            currentAlgoName = "Shuffling";
            shuffle();
            System.out.println("Starting bubble sort . . .");
            currentAlgoName = "Bubble sort";
            new BubbleSort().sort(intArray);
            System.out.println("Bubble sort over");
            currentAlgoName = "Shuffling";
            shuffle();
            System.out.println("Starting selection sort . . .");
            currentAlgoName = "Selection sort";
            new SelectionSort().sort(intArray);
            System.out.println("Shuffling array");
        };
        new Thread(r).start();
    }

    public void shuffle() {
        List<ArrayValue> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
    }

    public int getArrayAccesses() {
        return arrayAccesses;
    }

    public void setArrayAccesses(int arrayAccesses) {
        this.arrayAccesses = arrayAccesses;
    }


    public static Color getColorFromInt(int x) {
        if (x == 0) x++;
        float val = (float)x / Constants.ARRAY_SIZE;

        // Remove red from the spectrum, it's used to show array accesses
        if(val < 20f/360) val =20f/360;
        else if(val> 340f/360f) val = 340f/360;
        return Color.getHSBColor(val, 1f, 1f);
    }
}
