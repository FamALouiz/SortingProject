package sortingAlgorithms;

public class BubbleSort implements SortingAlgorithm {
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
}
