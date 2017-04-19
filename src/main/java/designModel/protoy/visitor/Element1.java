package designModel.protoy.visitor;


/**
 * Created by chenjie on 16/3/23.
 */
public class Element1 implements IElement {

    public void doSomething() {
        System.out.println("this is element 1 ,see you later man");
    }

    public void accept(IVisit iVisit) {
        iVisit.visit(this);
    }
}
