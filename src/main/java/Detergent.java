/**
 * Created by chenjie on 16/9/29.
 */


class Cleanser {
    public Cleanser(int i) {
        System.out.println(i);
    }

    private String s = new String("Cleanser");

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public void print() {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser(1);
        x.dilute();
        x.apply();
        x.scrub();
        x.print();
    }
}

public class Detergent extends Cleanser {


    public Detergent() {

        super(1);
    }

    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }

    // Add methods to the interface:
    public void foam() {
        class Xiao{
            private int i;
        }
        Xiao xiao = new Xiao();
        append(" foam()");
    }

    public void ff(){
    }
    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.print();
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}
