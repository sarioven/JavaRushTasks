import java.util.Random;

public class SortChoose {
    public static void main(String[] args) {
        int[] array = new int[10];

        Random rnd = new Random();

        for(int i = 0; i < array.length; i++)
            array[i] = rnd.nextInt();

        showArray(array);

        sortChoose(array);

        showArray(array);
    }

    public static void sortChoose(int[] a) {
        int min, k = 0, buffer;

        for(int i=0; i < a.length; i++) {
            min = k;

            for(int j=k; j < a.length; j++) {
                if(a[min] > a[j]) {
                    buffer = a[min];
                    a[min] = a[j];
                    a[j] = buffer;
                }
            }

            k++;
        }
    }

    public static void showArray(int[] a) {
        for(int i : a)
            System.out.print(i + " ");

        System.out.println();
    }
}
