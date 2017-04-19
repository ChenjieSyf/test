import java.util.*;

/**
 * Created by chenjie on 16/1/19.
 */
public class TestCollect {

    public static void main(String[] args) {
       /* List<Integer> list = Arrays.asList(91, 23, 45, 63, 24, 12);
        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list);*/

        Collection<Integer> set1 = new HashSet<Integer>();


        System.out.println("HashSet 耗时" + new TestCollect().getUsedMillis(set1, 500000));


        Collection<Integer> set2 = new LinkedHashSet<Integer>();
        System.out.println("LinkedHashSet 耗时" + new TestCollect().getUsedMillis(set2, 500000));


        Collection<Integer> set3 = new TreeSet<Integer>();

        System.out.println("TreeSet 耗时" + new TestCollect().getUsedMillis(set3, 500000));

        Collection<Integer> list1 = new ArrayList<Integer>();
        System.out.println("ArrayList 耗时" + new TestCollect().getUsedMillis(list1, 50000));


        Collection<Integer> list2 = new LinkedList<Integer>();
        System.out.println("LinkedList 耗时" + new TestCollect().getUsedMillis(list2, 50000));

    }


    public long getUsedMillis(Collection<Integer> T, int size) {
        long starttime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        for (Integer i : list) {
            T.add(i);
        }

        Collections.shuffle(list);
        for (Integer i : list) {
            T.remove(i);
        }

  list.forEach(integer -> {

  });
        long endTime = System.currentTimeMillis();

        return endTime - starttime;


    }

    interface Cast {
        public int get(int i) ;
    }

    public void d() {

        Cast o = (Cast) (int i) -> { System.out.println("hi"); return i; };
        System.out.println( o.get(1));

    }


}


