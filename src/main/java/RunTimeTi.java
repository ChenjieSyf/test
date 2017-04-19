import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by chenjie on 16/10/18.
 */

interface Shape {
    public void draw();
}
interface xi{

}
class Circle implements Shape , xi{
    public void draw() {
        System.out.println("Circle.draw()");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Square.draw()");
    }
}

class Triangle implements Shape {
    public void draw() {
        System.out.println("Triangle.draw()");
    }
}


public class RunTimeTi {
    public static void main(String[] args) throws Exception{
       /* Vector s = new Vector();
        Class[] shapeClass={Circle.class,Square.class,Triangle.class};
        for (int i = 0; i < shapeClass.length ; i++) {
            s.addElement(shapeClass[i].newInstance());
        }
       *//* s.addElement(new Circle());
        s.addElement(new Square());
        s.addElement(new Triangle());*//*
        Enumeration e = s.elements();
        while (e.hasMoreElements())
            ((Shape) e.nextElement()).draw();*/
        //Class[]faces = new Circle().getClass().getInterfaces();

        //System.out.println(faces.length);
        Class clazz = Class.forName("Circle");
        Method method = clazz.getMethod("draw");
         method.invoke(clazz.newInstance());

    }
}

