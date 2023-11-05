package sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    private int[] toSort;

    public BubbleSort(int[] arr) {
        this.toSort = arr;
    }

    public int[] Sort() {
        for (int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < toSort.length - i - 1; j++) {
                if (this.toSort[j] > this.toSort[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        return toSort;
    }

    public void swap(int a, int b) {
        int temp = this.toSort[a];
        this.toSort[a] = this.toSort[b];
        this.toSort[b] = temp;
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort(new int[] { 1, 0, 2, 100, -1, 20, -24, 5, 678, 124, 512, 42, 25 });
        System.out.println(Arrays.toString(bs.Sort()));
    }
}
