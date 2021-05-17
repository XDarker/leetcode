package offer;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/5 22:04
 */
public class demo {

    public static TreeNode buildTree(int[] pre, int[] in) {

        return buildTree(pre, 0,pre.length - 1, in, 0, in.length - 1);


    }

    public static TreeNode buildTree(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {

        int preLen = preRight - preLeft;
        int intLen = inRight - inLeft;
        if (preLen != intLen || preLen <= 0){
            return null;
        }
        int rootVal = pre[preLeft];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inLeft; i <= inRight; i++) {
            if (rootVal == in[i]){
                int num = i - inLeft;
                root.left = buildTree(pre, preLeft + 1, preLeft + num, in, inLeft, i - 1);
                root.right = buildTree(pre, preLeft + num + 1, preRight, in, i + 1, inRight);
            }
        }
        return root;
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
