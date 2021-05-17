package offer;

import java.util.*;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/2/21 21:55
 */
public class 二叉树遍历 {


    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.right = nodeF;
        nodeE.left = nodeG;

        System.out.print("前序遍历递归方式:");
        preOrder1(nodeA);
        System.out.println();
        System.out.print("前序遍历利用栈:");
        preOrder2(nodeA);
        System.out.println();

        System.out.println("================");
        System.out.print("中序遍历:");
        midOrder1(nodeA);
        System.out.println();
        System.out.print("中序遍历利用栈:");
        midOrder2(nodeA);
        System.out.println();


        System.out.println("================");
        System.out.print("后序遍历:");
        postOrder1(nodeA);
        System.out.println();
        System.out.print("后序遍历利用栈:");
        postOrder2(nodeA);
        System.out.println();


        System.out.println("================");
        System.out.print("层序遍历:");
        bfs(nodeA);
        System.out.println();
        System.out.print("层序遍历分层打印:");
        List<List<String>> lists = bfs2(nodeA);
        System.out.println(lists);
    }

    /**
     * 递归方式
     *
     * @param root
     */
    public static void preOrder1(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value);
        preOrder1(root.left);
        preOrder1(root.right);

    }

    /**
     * 利用栈
     *
     * @param root
     */
    public static void preOrder2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void midOrder1(Node root) {
        if (root == null) {
            return;
        }
        midOrder1(root.left);
        System.out.print(root.value);
        midOrder1(root.right);

    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void midOrder2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            System.out.print(node.value);
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

    public static void postOrder1(Node root) {
        if (root == null) {
            return;
        }
        postOrder1(root.left);
        postOrder1(root.right);
        System.out.print(root.value);

    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrder2(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            stack2.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value);
        }

    }

    /**
     * 层序遍历
     *
     * @param root
     */
    private static void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    private static List<List<String>> bfs2(Node root) {
        List<List<String>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> listStr = new ArrayList<>();
            while (size-- > 0) {
                Node node = queue.poll();
                listStr.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(listStr);
        }
        return lists;

    }

    public static class Node {
        public String value;
        public Node right;
        public Node left;

        public Node(String value) {
            this.value = value;
        }
    }
}
