package javahundred1;

/**
 * Created by chenjie on 16/3/10.
 */
public class Caipiao {
    // 问题描述：根据福利彩票的规则，6个蓝色球，范围1--32，不允许重复，1个红色球，范围1-16，自动生存6个蓝色球，1个红色球。
    //最好的做法 最后一位移动到之前被选中的那里
    public static void main(String[] args) {
        int a[] = new int[32];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int[] b = new int[7];
        for (int i = 0; i < 6; i++) {
            b[i] = (int) (Math.random() * 32);
            for (int j = i; j < 31 - i; j++) {
                a[j] = a[j + 1];
            }
        }

        b[6] = (int) (Math.random()*32);

        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]+" ");
        }

    }

}
