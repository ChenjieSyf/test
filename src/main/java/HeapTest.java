/**
 * Created by chenjie on 16/2/17.
 */
public class HeapTest {


    public static void main(String[] args) {
        int[] a = {12, 23, 45, 67, 25, 46, 69, 89};

        quickPoint(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void quickPoint(int[] a, int low, int high) {
        if (low < high) {
            int p = quickSort(a, low, high);
            quickPoint(a, low, p - 1);
            quickPoint(a, p + 1, high);
        }

    }

    public static int quickSort(int[] a, int low, int high) {

        int temp = a[low];
        while (low < high) {

            while (low < high && temp < a[high]) {

                high--;
            }
            a[low] = a[high];

            while (low < high && temp >= a[low]) {

                low++;
            }

            a[high] = a[low];


        }
        a[low] = temp;
        return low;
    }
}
