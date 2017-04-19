package designModel.protoy.visitor;

/**
 * Created by chenjie on 16/3/24.
 */
public class Visitor implements IVisit {
    public void visit(Element1 e) {
        e.doSomething();

    }

    public void visit(Element2 e) {
        e.doSomething();
    }
}
