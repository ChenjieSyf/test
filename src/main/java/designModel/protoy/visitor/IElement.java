package designModel.protoy.visitor;

/**
 * Created by chenjie on 16/3/23.
 */
public interface IElement {

    public void doSomething();
    public void accept(IVisit iVisit);
}
