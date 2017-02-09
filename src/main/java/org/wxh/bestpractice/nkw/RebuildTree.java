package org.wxh.bestpractice.nkw;

import java.util.concurrent.TimeUnit;

/**
 * 作者: wangxh
 * 创建日期: 17-2-2
 */
public class RebuildTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) throws InterruptedException {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        TimeUnit.MICROSECONDS.sleep(100);
        TreeNode root = new TreeNode(pre[0]);
        System.out.println(root.val);
        int index = findIndex(pre[0], in); // 找到中序的根结点
        int[] leftIn = new int[index], leftPre = new int[index];
        int[] rightIn = new int[in.length - index - 1], rightPre = new int[in.length - index - 1];
        System.arraycopy(in, 0, leftIn, 0, index);
        System.arraycopy(in, index + 1, rightIn, 0, in.length - index - 1);
        System.arraycopy(pre, 1, leftPre, 0, index);
        System.arraycopy(pre, 1 + index, rightPre, 0, in.length - index - 1);
        root.left = reConstructBinaryTree(leftPre, leftIn);  // 左边递归
        root.right = reConstructBinaryTree(rightPre, rightIn); // 右边递归
        return root;
    }

    public static int findIndex(int num, int[] target) {
        for (int i = 0; i < target.length; i++) {
            if (target[i] == num) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws InterruptedException {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
    }
}
