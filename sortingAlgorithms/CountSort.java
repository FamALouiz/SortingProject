package sortingAlgorithms;

public class CountSort {
    private int[] counts;
    private int size;

    public CountSort(int[] arr, int k) {
        this.counts = new int[k + 1];
        this.size = arr.length;
        for (int i : arr)
            counts[i]++;
    }

    public int[] sort() {
        int[] res = new int[this.size];
        int idx = 0;
        for (int i = 0; i < this.counts.length; i++) {
            while (this.counts[i] > 0) {
                res[idx++] = i;
                this.counts[i]--;
            }
        }
        return res;
    }
}
