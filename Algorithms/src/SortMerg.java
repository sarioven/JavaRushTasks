import java.util.Random;

public class SortMerg {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] array = new int[10];

        for(int i = 0; i < array.length; i++)
            array[i] = rnd.nextInt();

        showArray(array);

        sortMerge(array);

        showArray(array);

    }

    public static void sortMerge(int[] a) {
        if(a == null)
            return;

        if(a.length < 2)
            return;

        int endFinal = a.length / 2;

        int[] a1 = new int[endFinal];
        int[] a2 = new int[a.length - endFinal];
        int[] a3;

        for(int i = 0; i < endFinal; i++)
            a1[i] = a[i];

        for(int i = 0; i < a.length - endFinal; i++)
            a2[i] = a[endFinal + i];

        sortMerge(a1);
        sortMerge(a2);
        a3 = merge(a1, a2);

        for(int i=0; i < a.length; i++)
            a[i] = a3[i];
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] a = new int[a1.length + a2.length];

        int j = 0, k = 0;

        for (int i = 0; i < a.length; i++) {
            if (j > a1.length - 1) {
                a[i] = a2[k];
                k++;

                continue;
            } else if (k > a2.length - 1) {
                a[i] = a1[j];
                j++;

                continue;
            }

            if (a1[j] < a2[k]) {
                a[i] = a1[j];
                j++;
            } else {
                a[i] = a2[k];
                k++;
            }
        }

        return a;
    }

    public static void showArray(int[] a) {
        for(int i : a)
            System.out.print(i + " ");

        System.out.println();
    }
}
