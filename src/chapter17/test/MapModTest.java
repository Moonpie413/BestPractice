package chapter17.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxh on 16-11-12.
 * package chapter17.test
 * des
 */
public class MapModTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("test1", "hello");
        map.put("test2", "world");
        System.out.println("原始map：" + map);

        for (Map.Entry entry : map.entrySet()) {
            entry.setValue("forEach修改值");
        }

        System.out.println("foreach修改后的map：" + map);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }
}
