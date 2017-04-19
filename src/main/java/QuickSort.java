/**
 * Created by chenjie on 16/1/26.
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {11, 23, 45, 67, 89, 76, 43, 21, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    public static void sort(int[] a) {

        int result = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = 1;
                break;
            }
        }
        if (result == 1) {
            int[] b1 = new int[a.length];
            int[] b2 = new int[a.length];
            int b1point = 0;
            int b2point = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > a[0])
                    b2[b2point++] = a[i];
                else
                    b1[b1point++] = a[i];
            }


            int[] a1 = new int[b1point];
            int[] a2 = new int[b2point];
            System.arraycopy(b1, 0, a1, 0, b1point);

            for (int i = 0; i <a1.length ; i++) {
                System.out.print(a1[i] + " ");
                if(i==a1.length-1) System.out.println("");
            }

            System.arraycopy(b2, 0, a2, 0, b2point);

            sort(a1);
            sort(a2);
            System.arraycopy(a1, 0, a, 0, a1.length);
            System.arraycopy(a2, 0, a, a1.length, a2.length);
        }

    }
}
