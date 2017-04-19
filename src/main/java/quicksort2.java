/**
 * Created by chenjie on 16/3/8.
 */
public class quicksort2 {

    public static void main(String[] args) {
        int a[] = {12, 11, 2, 34, 56, 76, 54};
        quicksort(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void quicksort(int[] a, int low, int high) {

        if (low < high) {
            int p = findpoint(a, low, high);
            quicksort(a, low, p-1);
            quicksort(a, p + 1, high);

        }
    }

    static int findpoint(int[] a, int low, int high) {

        int point = a[low];
        int temp;
        while (low < high) {

            while (low < high && point < a[high]) {
                high--;
            }
            a[low] = a[high];

            while (low < high && point > a[low]) {
                low++;
            }

            a[high] = a[low];

        }
        a[low] = point;
        return low;
    }
}
