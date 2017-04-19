package machinetest;

import java.util.Scanner;


/*程序实现目标： 输入一个字符串，将其各个字符对应的ASCII值加5后，输出结果。
        程序要求：该字符串只包含小写字母，若其值加5后的字符值大于'z',将其转换成从a开始的字符。*/

/**
 * Created by chenjie on 17/2/6..
 */
public class AscConverter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
        char[] inChar = inputStr.toCharArray();
        for (int i = 0; i < inChar.length; i++) {

            int ascCodeId = inChar[i];
            int converterCodeId = (ascCodeId - 97 + 5) % 26 + 97;
            System.out.print((char) converterCodeId);
        }
       /* char i = 98;
        System.out.println(i);*/
    }
}
