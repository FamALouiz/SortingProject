package sortingAlgorithms;

import src.Main;

public class BubbleSortMachine extends Thread {
    private static final BubbleSort bubbleSort = new BubbleSort(Main.heights);

    @Override
    public void run() {
        try {
            bubbleSort.Sort();
        } catch (Exception e) {
            return;
        }
    }
}
