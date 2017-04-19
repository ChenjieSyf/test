import org.apache.commons.lang.ObjectUtils;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by chenjie on 16/6/13.
 */
public class Lambta {
   static String hehe ="hehehehehehe";

    public static void main(String[] args) {
       /* new Thread(() -> System.out.println("Hello world !")).start();
        Runnable runnable = ()->{
            System.out.println();
        };*/

        List<User> list = new ArrayList<>();
        /*list.add("jack");
        list.add("javil");
        list.add("jbill");
        list.add("emily");*/

        List<User> users
                = new ArrayList<>();
        User user = new User();
        user.setAge(12);
        user.setName("penaut");
        users.add(user);
        User user1 = new User();
        user1.setAge(11);
        user1.setName("faker");
        users.add(user1);
        User user2 = new User();
        user2.setAge(13);
        user2.setName("GodV");
        users.add(user2);

        //users.stream().sorted(Comparator.comparing(User::getAge).reversed()).map(User::getAge).collect(Collectors.toList()).forEach(System.out::println);
        //users.parallelStream().sorted(Comparator.comparing(User::getAge).reversed()).map(User::getAge).collect(Collectors.toList()).forEach(System.out::println);
         list =   users.stream().filter(user3 -> user3.getAge()==11).collect(Collectors.toList());

       // System.out.println(list.size());

     /*   users.forEach(user3 -> {
            if(user3.getAge()>12){
                user3.setIndex(3);
            }else if (user3.getAge()==12){
                user3.setIndex(2);
            }else {
                user3.setIndex(1);
            }
        });*/

        users.forEach(user3 -> {
            d("str", 0);
        });

        /*d("你好",10000);
        d("真是个什么东西",10000);*/
      /* *//* list.forEach((String s) -> {
            System.out.println("this is " + s);
        });*//*

        list.stream().filter((String s) -> s.startsWith("j")).sorted().forEach(System.out::println);



        UUID.randomUUID();*/


       /* String s = String.join(",", list);
        System.out.println(s);*/


         new Lambta().execute();

    }



    public static <T> void d(T t,long mi) {
     if(mi>0){
      try {

      }catch (Exception e){

      }

  }
        System.out.println(t.toString()+hehe);


    }

    public void execute(){
        MySendThread mySendThread = new MySendThread();
        mySendThread.setMi(10000);
        mySendThread.setStr("zheshi diyige hahahaha");
        mySendThread.start();


        MySendThread mySendThread1 = new MySendThread();
        mySendThread1.setStr("==================wulili");
        mySendThread1.start();
    }

    class jack<T> {

    }

    class  MySendThread extends Thread{
        String str;
        long mi;

        @Override
        public void run() {
            if(mi>0){
                try {
                    sleep(mi);
                }catch (Exception e){

                }

            }
            System.out.println("================"+str);

        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public long getMi() {
            return mi;
        }

        public void setMi(long mi) {
            this.mi = mi;
        }
    }

}

