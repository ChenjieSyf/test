package arithmetic;

/**
 * Created by chenjie on 17/4/14.
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] values = new int[]{7, 3, 8, 2, 5,7,15};
        /*new QuickSort().simpleSort(values, 0, values.length - 1);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }*/
        qs(values,0,values.length-1);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

    public static void qs(int[] a, int left, int right) {
        if(left>= right) return;
        int returnIndex = simpleSort(a, left, right);
        qs(a, left, returnIndex - 1);
        qs(a, returnIndex + 1, right);
    }


    public static int simpleSort(int[] a, int leftIndex, int rightIndex) {

        int currentIndex = leftIndex;
        int indexValue = a[currentIndex];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && indexValue <= a[rightIndex]) {
                rightIndex--;
            }
            a[currentIndex] = a[rightIndex];

            while (leftIndex < rightIndex && a[leftIndex] < indexValue) {
                leftIndex++;
            }
            a[rightIndex] = a[leftIndex];
            a[leftIndex] = indexValue;
            currentIndex = leftIndex;

        }
        return currentIndex;
    }
}
