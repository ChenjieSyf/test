import org.joda.time.DateTime;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by chenjie on 15/11/11.
 */
public class SaberTest {

    public static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> ref = null;
        while ((ref = rq.poll()) != null) {

            if (ref != null) {
                System.out.println("In queue: " + ((VeryBigWeakReference) (ref)).id);
            }
        }
    }

    public static void main(String args[]) throws Exception {

/*
        Juer juer = new Juer();
        SoftReference<Juer> saoge = new SoftReference<Juer>(juer);
        if (saoge != null) {
            juer = saoge.get();
        }
        ReferenceQueue<VeryBig>*/

        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();

        for (int i = 0; i < 3; i++) {
            weakList.add(new VeryBigWeakReference(new VeryBig("Weak" + i), rq));
            System.out.println("Just created weak: " + weakList.getLast());
        }
        System.gc();
        try {
            Thread.sleep(6000);
        } catch (Exception e) {

        }

        checkQueue();
       /* LinkedList<String> ll = new LinkedList<String>();
        ll.add("yesterday");
        ll.add("now");
        ll.add("tomorrow");

       *//* for (int i = 0; i <ll.size() ; i++) {
            SaberTest.<String>so(ll.get(i));
        }

*//*
        String ee = " ||||||";

       String a[] =  ee.split("|");
       /* System.out.println(a.length);*//*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");e
        String str = "2015-05-26 11:20:11";
        DateTime dateTime = new DateTime(sdf.parse(str));*/
      /*  String str = ",chenjie,is,people";
        str = str.substring(1);
        System.out.println(str);*/

      /*  String str = "720203|和平饭店|222|111|250|251|is";
        String res[] = str.split("\\|");
        int ii= res.length;
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }*/

       /* DateTime date = new DateTime();
        date = date.minusDays(1);

        String dt = date.toString("yyyy-MM-dd");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select count(distinct upload_dviceId) num from (select * from st.st_ms_user where dt=").
                append(dt).append("and eleme_device_id IS NOT NULL) st_ms_user right join (select device_ids\n" +
                "                upload_dviceId\n" +
                "                , from temp.st_ms_customers_upload5 where batch_id=").append("42808972218077184")
                .append("and device_ids IS NOT NULL) st_ms_customers_upload5 on (st_ms_user. eleme_device_id =st_ms_customers_upload5.device_ids ) where 1=1  and st_ms_user.user_id is not null");
        System.out.println(stringBuffer);*/


    }

    public static <E> void so(E sm) {

        System.out.println(sm.toString());

    }


}

class VeryBig {
    public String id;

    byte[] b = new byte[2 * 1024];

    public VeryBig(String id) {
        this.id = id;
    }

    protected void finalize() {
        System.out.println("Finalizing VerBig " + id);
    }
}

class VeryBigWeakReference extends WeakReference<VeryBig> {
    public String id;

    public VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBigWeakReference " + id);
    }
}