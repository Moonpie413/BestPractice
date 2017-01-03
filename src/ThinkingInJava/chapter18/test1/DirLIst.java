package ThinkingInJava.chapter18.test1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by wangxh on 16-11-14.
 * package ThinkingInJava.chapter18.test1
 * des
 */
public class DirLIst {
    public static void main(String[] args) {
        args = new String[]{"out"};
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            String[] finalArgs = args;
            list = path.list(new FilenameFilter() {
              private Pattern pattern = Pattern.compile(finalArgs[0]);
              @Override
              public boolean accept(File file, String s) {
                  return this.pattern.matcher(s).matches();
              }
          });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
