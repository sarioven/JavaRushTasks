import java.util.Arrays;

public class SortFast {
    public static void main(String[] args) {
        int[] array = new int[] {32, 4, 20, 5, 60};

        QuickSort(array, 0, array.length-1);

        for(int i : array)
            System.out.print(i + " ");
    }

    public static void QuickSort(int[] array, int start, int end) {
        if(array.length == 0)
            return;

        int middle = end - (int)Math.floor((((end - start) * 1.0) / 2));
        int sample = array[middle];
        int k = start, j = end, buffer;

        while(k <= j) {
            while(array[k] < sample)
                k++;

            while(array[j] > sample)
                j--;

            if(k <= j) {
                buffer = array[j];
                array[j] = array[k];
                array[k] = buffer;
                k++;
                j--;
            }
        }

        if(start < j)
            QuickSort(array, start, j);

        if(end > k)
            QuickSort(array, k, end);
    }
}
