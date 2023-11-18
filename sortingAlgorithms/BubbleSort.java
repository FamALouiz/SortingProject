package sortingAlgorithms;

public class BubbleSort implements SortingAlgorithm {
    private int[] toSort;

    public BubbleSort(int[] arr) {
        this.toSort = arr;
    }

    public void Sort() {

    }

    public void swap(int a, int b) {
        int temp = this.toSort[a];
        this.toSort[a] = this.toSort[b];
        this.toSort[b] = temp;
    }
}
