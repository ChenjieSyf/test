package TiJavaTest;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by chenjie on 16/11/21.
 */
public class Hongbao {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println("输入金额");
        int money = in.nextInt();
        System.out.println("输入人数");
        int num = in.nextInt();
        if (money / num > 200) {
            System.err.println("单个红包超过200 不符合规则");
            return;
        }

        double[] dou = radomRedPacket(money, num);

        while (dou[dou.length - 1] > 200) {//最后一个红包的金额大于200 重新分配 直到不是200为止
            dou = radomRedPacket(money, num);
        }
        /*while (dou[dou.length - 1] > 200) {

        }*/


        for (int i = 0; i < dou.length; i++) {
            System.out.println(dou[i]);
        }
    }


    public static double[] radomRedPacket(int money, int num) {
        double[] dou = new double[num];
        Random r = new Random();
        DecimalFormat format = new DecimalFormat(".##");
        double middle = 200;
        double redMoney = 0;//本次红包金额
        double nextMoney = money;//剩余红包金额
        double sum = 0;//总数
        int index = 0;
        for (int i = num; i > 0; i--) {
            if (i == 1) {//如果是最后一个红包 直接将剩余金额给他
                dou[index] = nextMoney;
            } else {
                while (true) {//随机生成红包金额 如果小于规定的数目 并且剩余金额大于0 则生成成功,放入对应数组
                    String str = format.format(r.nextDouble() * nextMoney);
                    redMoney = Double.parseDouble(str);
                    if (redMoney > 0 && redMoney < middle) {
                        break;
                    }
                }
                nextMoney = Double.parseDouble(format.format(nextMoney - redMoney));//剩余金额
                sum = sum + redMoney;
                dou[index] = redMoney;
                index++;
            }
        }
        return dou;
    }
}
