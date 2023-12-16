package sortingAlgorithms;

import src.Main;

public class CountSortMachine extends Thread {

    private static final CountSort countSort = new CountSort(Main.heights, Main.heights.length);

    @Override
    public void run() {
        try {
            countSort.Sort();
        } catch (Exception e) {
            return;
        }
    }
}
