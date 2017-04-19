import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by chenjie on 16/6/28.
 */

interface Jack{
    int i =10;
}
 class JJ{
   public void p(){
       System.out.println("this is a P");
   }
}
public class User extends JJ {

   class DoNotKnow{
    void get(){
        System.out.println(name);
    }
   }

    @Override
    public void p(){
        System.out.println("this is just son");
    }
    public String name;
    public int age;
    public int index;
    public Map<String, Object> map;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void testLong(long i) {
        System.out.println("this long is " + i);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", index=" + index +
                '}';
    }

    public void testReflect(String name) {
        System.out.println("yes this is " + name);
    }

    private static void perr(String msg) {
        System.err.println(msg);
    }

    public final static void is_true(boolean exp) {
        if (!exp) perr("Assertion failed");
    }

    public final static void is_false(boolean exp) {
        if (exp) perr("Assertion failed");
    }

    public final static void
    is_true(boolean exp, String msg) {
        if (!exp) perr("Assertion failed: " + msg);
    }

    public final static void
    is_false(boolean exp, String msg) {
        if (exp) perr("Assertion failed: " + msg);
    }


    public static void main(String[] args) {
       /* Map<String,Object> map = new HashMap<>();
        map.put("tid","1111");
        map.put("sid", "1111");
        User user = new User();
        user.map = map;
        System.out.println(JSON.toJSONString(user));*/
       /* int i = -1;
        i >>>= 31;
        System.out.println(i);
        long l = -1;
        l >>>= 10;
        System.out.println(l);
        short s = -1;
        s >>>= 10;
        System.out.println(s);E047973
        byte b = -1;
        b >>>= 10;
        System.out.println(2>3?5:7);*/
        /*char v =  0x0041;
        long l = 12;
        System.out.println(v);*/
    /*    outer:
        for (int c=1;c<5;c++){
            if(c==2){
                break outer;
            }
            System.out.println("hahahahaha"+c);
        }
        System.out.println("it is over");*/

     /*   User u = new User();
        u.testLong('a');
        System.gc();
        System.runFinalization();
        int i;
        String str = "2016-09-27 09:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfq = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = sdf.parse(str);
            String dateTranster = sdfq.format(date);
            System.out.println(dateTranster);
        } catch (Exception e) {

        }*/
       // User.is_false("a".equals("a"));
//        assert false;
//        System.out.println("this is good fucker");
      /*  List<JJ> list= new ArrayList<>();
        JJ j = new User();
        list.add(j);
        list.get(0).p();
        Vector v= new Vector();*/

        Properties p = System.getProperties();
       //p.list(System.out);
        Set<String> set = new TreeSet<>();
        set.add("chenjie");
        set.add("songyuefeng");
        set.add("love");
        set.add("love");
       /// System.out.println(Collections.max(set));

       /* Iterator it =set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
        try{
            throw new Exception("meiying");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected void finalize() throws Throwable {

    }
}
