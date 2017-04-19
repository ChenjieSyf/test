package StringBuilder;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by chenjie on 16/4/27.
 */
public class MySun {

    private String name;

    private int age;

    private String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("my name", name).append("my age", age).append("my year", year).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(1, 7).append(name).append(age).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;

        if (obj instanceof MySun) {
            MySun mySun = (MySun) obj;
            equals = new EqualsBuilder().append(name, mySun.name).append(age, mySun.age).isEquals();
        }
        return equals;
    }


}
