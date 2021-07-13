import java.util.Random;

public class SortInsert {
    public static void main(String[] args) {
        int[] array = new int[10];

        Random rnd = new Random();

        for(int i = 0; i < array.length; i++)
            array[i] = rnd.nextInt(10);

        showArray(array);

        sortInsert(array);

        System.out.println();

        showArray(array);
    }

    public static void sortInsert(int[] a) {
        int index, value, step = 1;

        while(step < a.length/3)
            step = step*3 + 1;

        while(step > 0) {
            for (int i = step; i < a.length; i += step) {
                index = i;
                value = a[i];

                while (index > 0 && a[index - step] >= value) {
                    a[index] = a[index - step];
                    index -= step;
                }

                a[index] = value;

                System.out.print("(" + step + ") ");

                showArray(a);
            }

            step /= 3;
        }
    }

    public static void showArray(int[] a) {
        for(int i : a)
            System.out.print(i + " ");

        System.out.println();
    }
}
