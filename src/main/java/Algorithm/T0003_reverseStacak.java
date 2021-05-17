package Algorithm;

import java.util.Stack;

/**
 * @Created by XDarker
 * @Description 逆序一个栈
 * @Date 2020/8/9 14:57
 */
public class T0003_reverseStacak {


    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("====reverse====");
        reverseStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void reverseStack(Stack<Integer> stack) {

        //退出条件
        if (stack.isEmpty()){
            return;
        }

        //拿到最后一个并移除
        int i = getAndRemoveLast(stack);
        reverseStack(stack);
        stack.push(i);
    }

    /**
     * 将栈的栈底元素返回并移除
     * @param stack
     * @return
     */
    private static int getAndRemoveLast(Stack<Integer> stack) {

        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLast(stack);
            stack.push(result);
            return last;
        }

    }

}
