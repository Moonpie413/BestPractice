package ThinkingInJava.practice1;

import ThinkingInJava.practice1.anno.Constraints;
import ThinkingInJava.practice1.anno.DBTable;
import ThinkingInJava.practice1.anno.IntegerSQL;
import ThinkingInJava.practice1.anno.StringSQL;
import ThinkingInJava.practice1.bean.TestBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangxh on 16-11-16.
 * package ThinkingInJava.practice1
 * des
 */
public class TableCreator {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<TestBean> testBeanClass = (Class<TestBean>) Class.forName("ThinkingInJava.practice1.bean.TestBean");
        DBTable dbTable = testBeanClass.getAnnotation(DBTable.class);
        String dbName;
        if (dbTable != null && !"".equals(dbTable.name())) {
            dbName = dbTable.name().toUpperCase();
        } else {
            dbName = testBeanClass.getSimpleName().toUpperCase();
        }
        List<String> columnNames = new ArrayList<>();
        String columName;
        for (Field field : testBeanClass.getDeclaredFields()) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1) {
                continue;
            }
            if (annotations[0] instanceof IntegerSQL) {
                IntegerSQL integerSQL = (IntegerSQL) annotations[0];
                if (integerSQL.name().length() < 1) {
                   columName = field.getName();
                } else {
                    columName = integerSQL.name();
                }
                columnNames.add("\t" + columName + " INT(" + integerSQL.value() + ")" + getConstraints(integerSQL.constraints()));
            }
            if (annotations[0] instanceof StringSQL) {
                StringSQL stringSQL = (StringSQL) annotations[0];
                if (stringSQL.name().length() < -1) {
                    columName = field.getName();
                } else {
                    columName = stringSQL.name();
                }
                columnNames.add("\t" + columName + "STRING(" + stringSQL.value() + ")" + getConstraints(stringSQL.constaints()));
            }
        }
        StringBuilder commond = new StringBuilder("CREATE TABLE " + dbName + "(");
        for (String colum : columnNames) {
            commond.append("\n" + colum + ",");
        }
        String tableCreater = commond.substring(0, commond.length() - 1) + ";)";
        System.out.println(tableCreater);
    }

    public static String getConstraints(Constraints con) {
        StringBuilder constraints = new StringBuilder();
        if (con.primaryKey()) constraints.append(" PRIMARY KEY");
        if (con.allowNull()) constraints.append(" ALLOW NULL");
        if (con.unique()) constraints.append(" UNIQUE");
        return constraints.toString();
    }
}
