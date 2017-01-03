package ThinkingInJava.practice1.bean;

import ThinkingInJava.practice1.anno.Constraints;
import ThinkingInJava.practice1.anno.DBTable;
import ThinkingInJava.practice1.anno.IntegerSQL;
import ThinkingInJava.practice1.anno.StringSQL;

/**
 * Created by wangxh on 16-11-16.
 * package ThinkingInJava.practice1.bean
 * des
 */
@DBTable()
public class TestBean {

    @IntegerSQL(value = 10, constraints = @Constraints(primaryKey = true, allowNull = false, unique = true))
    private int id;

    @StringSQL(20)
    private String name;

    @IntegerSQL(8)
    private int age;

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
}