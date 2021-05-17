package Algorithm;

import java.util.Stack;

/**
 * @Created by XDarker
 * @Description 用一个栈实现另一个栈的排序
 * @Date 2020/8/9 15:58
 */
public class T0005_sortStackByStack {


    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(1);
        stack.add(3);
        stack.add(2);


        sortStackByStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

    private static void sortStackByStack(Stack<Integer> stack) {

        Stack<Integer> helpStack = new Stack();

        while (!stack.isEmpty()) {

            int cur = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() < cur) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }
}
