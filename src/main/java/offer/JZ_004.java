package offer;

import java.util.Arrays;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/4 22:22
 */
public class JZ_004 {

    public static void main(String[] args) {


    }


    public static TreeNode buildTree(int[] pre, int[] in) {

        //不管什么遍历方式，结果长度肯定是一样的，都是总结点数
        if (pre == null || pre.length != in.length || pre.length < 1) {
            return null;
        }

        //获取到根节点的value值
        TreeNode root = new TreeNode(pre[0]);

        int index = findIndex(pre, in);
        //构建左子树
        //root.left = buildTree(左子树的前序数组，左子树的中序数组)
        root.left = buildTree(Arrays.copyOfRange(pre, 1, index + 1),
                            Arrays.copyOfRange(in, 0, index));

        //构建右子树
        //root.right = buildTree(右子树的前序数组，右子树的中序数组)
        root.right = buildTree(Arrays.copyOfRange(pre, index+1, pre.length),
                Arrays.copyOfRange(in, index + 1, in.length));

        return root;
    }


    /**
     * 找根节点
     * @param pre
     * @param in
     * @return
     */
    public static int findIndex(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                return i;
            }
        }
        return 0;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}


