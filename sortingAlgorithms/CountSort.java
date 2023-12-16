package sortingAlgorithms;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;

import src.Main;
import src.Rect;

public class CountSort extends Highlighter implements SortingAlgorithm {
    private int[] counts;
    private int size;

    private final int DELAY = 100;

    public CountSort(int[] arr, int k) {
        this.counts = new int[k + 2];
        this.size = arr.length;
        for (int i : arr)
            counts[(i - 410) / 5]++;
    }

    public void Sort() throws InterruptedException {
        traverse();
        Thread.sleep(DELAY);
        traverse();
        int[] res = new int[this.size];
        int idx = 0;
        for (int i = 0; i < this.counts.length; i++) {
            while (this.counts[i] > 0) {
                res[idx++] = i;
                this.counts[i]--;
            }
        }
        Main.removeAllRects();
        for (int i = 0; i < this.size; i++) {
            Main.rects[i] = Main.sortedRects[i];
            Main.addComp(new Component[] { Main.sortedRects[i] });
            Thread.sleep(DELAY);
        }
        Arrays.sort(Main.heights);
        Main.update();
    }

    public void traverse() throws InterruptedException {
        for (int i = 0; i < this.size; i++) {
            Color prevColor = ((Rect) (Main.rects[i])).getColor();
            highlight(i);
            Thread.sleep(DELAY);
            Component temp = Main.removeRect(i);
            Rect oldRect = new Rect(temp, prevColor);
            Main.rects[i] = oldRect;
            Main.addComp(new Component[] { oldRect });
        }
    }
}
