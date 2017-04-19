/**
 * Created by chenjie on 16/1/26.
 */
public class QuickSort1 {

    public static void main(String[] args) {

        int[] a = {34, 33, 53, 33, 23, 7, 14, 10};

        quicjsort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }


      /*
       int i = 0;
        int j = 0;
        int k = 0;
       while (i < 10) {

            while (i < 5) {
                System.out.println("diyige limian de " + i);
                i++;

            }
            while (i < 9) {
                System.out.println("dierge limian de " + i);
                i++;
            }
            i++;
            System.out.println("zuiwaimian  de " + i);
        }*/
       /* quicjsort(a, 0, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }*/

    }

    public static int getIndex(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {

            while (low < high && temp <= a[high]) {
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

    public static void quicjsort(int[] a, int low, int high) {
        if (low < high) {


            int index = getIndex(a, low, high);
            quicjsort(a, low, index - 1);
            quicjsort(a, index + 1, high);

        }

    }
}
