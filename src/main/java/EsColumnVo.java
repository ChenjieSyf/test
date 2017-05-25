/**
 * Created by chenjie on 17/5/4.
 */
public class EsColumnVo {

    private String columnName;

    private String type;

    private String defaultValue;

    private int isRegular = 0;

    private boolean state;

   public EsColumnVo(String columnName, String type){
       this.columnName=columnName;
       this.type=type;
   }

    public EsColumnVo(){

    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getIsRegular() {
        return isRegular;
    }

    public void setIsRegular(int isRegular) {
        this.isRegular = isRegular;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
