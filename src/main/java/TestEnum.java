/**
 * Created by chenjie on 16/5/19.
 */
public enum TestEnum {


    EDITING(0), COMMITTED(1), AUDITED(2), SENDING(3), SENT(4), CANCELED(5), AUDITING(6), DENIED(7);

    private int value;

    TestEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
