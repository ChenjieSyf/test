/**
 * Created by chenjie on 17/4/21.
 */
public class GenericsTest {


    public static void main(String[] args) {
        GenericsTest g = new GenericsTest();
        g.getSubReturn(g.new B("idog"));
    }

    class B {
        public String name = "";

        public B(String name) {
            this.name = name;
        }
    }

    class A<B> {
        public B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }

    public <T> A<B> getSubReturn(B b) {
        A a = new A();
        a.setB(b);

        return a;
    }
}
