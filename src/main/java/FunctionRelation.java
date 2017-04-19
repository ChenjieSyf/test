import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjie on 16/4/23.
 */
public class FunctionRelation {

    public static void main(String[] args) {

        String[] relations = {"f1 f2", "f1 f3", "f1 f4", "f1 f5",
                "f6 f2", "f6 f3", "f6 f4",
                "f5 f1", "f5 f3", "f5 f9", "f5 f2",
                "f4 f1", "f4 f6",
                "f3 f1", "f3 f6", "f3 f5",
                "f2 f1", "f2 f6", "f2 f5"};
        int rtoMum[][] = new int[6][6];

        for (int i = 0; i < relations.length; i++) {

            String[] convert = relations[i].split(" ");
            rtoMum[Integer.parseInt(convert[0].substring(1, convert[0].length()))][Integer.parseInt(convert[2].substring(1, convert[2].length()))] = 1;
        }
        int s = 2;

        int relationAmount = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {


            }
            if (relationAmount > s + 1) {
            }
        }
    }
}

 /*   public int[] findRelation(int i,int j ,int rtn[][]) {
        List<Integer> rlist = new ArrayList<Integer>();
        for (int k = 0; k < rtn.length; k++) {
            for (int l = 0; l < rtn[k].length; l++) {
                if (k == i || k == j) {
                    if (rtn[k][l] == 1) {
                        rlist.add(l);
                    }
                }
            }
        }

    }}}*/
