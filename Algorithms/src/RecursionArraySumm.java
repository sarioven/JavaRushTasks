import java.util.Arrays;

public class RecursionArraySumm {
    public static void main(String[] args) {
        System.out.println("" + RecSumm(new int[]{}));
    }

    public static int RecSumm(int[] array) {
        return array.length < 1 ? 0 : array[0] + RecSumm(Arrays.copyOfRange(array, 1, array.length));
    }
}
