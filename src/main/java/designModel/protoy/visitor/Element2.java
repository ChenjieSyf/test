package designModel.protoy.visitor;

/**
 * Created by chenjie on 16/3/24.
 */
public class Element2 implements IElement {

    public void doSomething() {
        System.out.println("this is element 2 ,can you hear me?");
    }

        public void accept(IVisit iVisit) {
        System.out.println("this is element 2,hear sorrow onlyss");
    }
}
