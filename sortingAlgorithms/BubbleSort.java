package sortingAlgorithms;

import src.Main;
import java.util.Arrays;
import java.awt.Color;
import src.Rect;

public class BubbleSort extends Highlighter implements SortingAlgorithm {
    private int[] toSort;
    private int size;

    private final int DELAY = 3;

    public BubbleSort(int[] arr) {
        this.toSort = arr;
        System.out.println(Arrays.toString(toSort));
        this.size = this.toSort.length;
    }

    public void Sort() throws InterruptedException {
        for (int i = 0; i < this.size; i++) {
            for (int k = 0; k < this.size - i - 1; k++) {
                boolean swapped = false;
                Color old1 = ((Rect) (Main.rects[k])).getColor();
                Color old2 = ((Rect) (Main.rects[k + 1])).getColor();
                highlight(k);
                highlight(k + 1);
                Thread.sleep(DELAY);
                if (toSort[k] > toSort[k + 1]) {
                    Main.removeRect(k);
                    Main.removeRect(k + 1);
                    swap(k, k + 1);
                    Main.addComp(Main.rects);
                    swapped = true;
                    Thread.sleep(DELAY);
                }
                Thread.sleep(DELAY);
                Main.removeRect(k);
                Main.removeRect(k + 1);
                Main.rects[k] = new Rect(Main.rects[k], swapped ? old2 : old1);
                Main.rects[k + 1] = new Rect(Main.rects[k + 1], swapped ? old1 : old2);
                Main.addComp(Main.rects);
            }
        }
    }

    public void swap(int a, int b) {
        int temp = this.toSort[a];
        this.toSort[a] = this.toSort[b];
        this.toSort[b] = temp;
        swapRects(a, b);
    }
}
