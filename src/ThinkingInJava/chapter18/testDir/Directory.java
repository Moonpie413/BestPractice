package ThinkingInJava.chapter18.testDir;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangxh on 16-11-14.
 * package ThinkingInJava.chapter18.testDir
 * des
 */
public class Directory {

    public static TreeInfo walk(File start) {
        return TreeInfo.recurseDirs(start, ".*");
    }

    public static class TreeInfo implements Iterable<File> {
        private List<File> fileList = new ArrayList<>();
        private List<File> dirList = new ArrayList<>();

        public void addAll(TreeInfo treeInfo) {
            this.fileList.addAll(treeInfo.fileList);
            this.dirList.addAll(treeInfo.dirList);
        }

        @Override
        public Iterator<File> iterator() {
            return fileList.iterator();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("dirs: \n");
            for (File dir : dirList) {
                builder.append("[ " + dir.toString() + " ] \n");
            }
            builder.append("files: \n");
            for (File file : fileList) {
                builder.append("[ " + file.toString() + " ] \n");
            }
            return builder.toString();
        }

        public static TreeInfo recurseDirs(File dir, String regex) {
            TreeInfo result = new TreeInfo();
            if (!dir.isDirectory()) throw new RuntimeException("dir is not a dir");
            for (File f : dir.listFiles()) {
                if (f.isDirectory()) {
                    result.dirList.add(f);
                    result.addAll(recurseDirs(f, regex));
                } else {
                    if (f.getName().matches(regex)) {
                        result.fileList.add(f);
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Directory.walk(new File(".")));
    }
}
