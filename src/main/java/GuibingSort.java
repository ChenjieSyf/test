/**
 * Created by chenjie on 16/1/25.
 */
public class GuibingSort {

    public static void main(String[] args) {

        int[] a = {1, 23, 45, 67, 89, 32, 45, 65, 67};
        divide(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }


    public static void divide(int[] a) {
        int[] last = new int[a.length];
        if (a.length > 1) {
            int firsthalf = a.length / 2;
            int[] a1 = new int[firsthalf];
            int[] a2 = new int[a.length - firsthalf];
            System.arraycopy(a, 0, a1, 0, firsthalf);
            divide(a1);
            System.arraycopy(a, firsthalf, a2, 0, a.length - firsthalf);
            divide(a2);
            last = merge(a1, a2);
            for (int i = 0; i < last.length; i++) {
                System.out.print(+last[i] + " ");
                if (i == last.length - 1) {
                    System.out.println("");
                }
            }
            System.arraycopy(last, 0, a, 0, a.length);
        }

    }


    public static int[] merge(int[] list1, int[] list2) {

        int[] temp = new int[list1.length + list2.length];
        int step = 0;
        int current1 = 0;
        int current2 = 0;
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[step++] = list1[current1++];
            } else
                temp[step++] = list2[current2++];


        }

        while (current1 < list1.length) {
            temp[step++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[step++] = list2[current2++];
        }

        return temp;
    }

}
