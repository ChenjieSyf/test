package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjie on 16/4/26.
 */
public class ConcreteAggragate implements IAggregate {

    private List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);

    }

    public void remove(Object obj) {
        list.remove(obj);
    }

    public Itrator itrator() {
        return new ConcreateIterator(list);
    }
}
