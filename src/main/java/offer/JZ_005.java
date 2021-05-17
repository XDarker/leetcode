package offer;

import java.util.Stack;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2021/3/6 23:12
 */
public class JZ_005 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty()){
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int restlt = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return restlt;
    }
}
