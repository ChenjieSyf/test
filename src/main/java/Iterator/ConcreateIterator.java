package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenjie on 16/4/26.
 */
public class ConcreateIterator implements Itrator {

    private List<String> list = new ArrayList<String>();

    private int cursor;

    public ConcreateIterator(List<String> list1) {
        this.list = list1;
    }

    public Boolean hasNext() {
        if (cursor != list.size()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Object obj = null;
        if (this.hasNext()) {

            return this.list.get(cursor++);
        }
        return null;
    }


}
