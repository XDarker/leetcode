package Algorithm;

import java.util.Stack;

/**
 * @Created by XDarker
 * @Description 两个栈组成一个队列
 * @Date 2020/8/6 22:40
 */
public class T0002_twoStackQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;


    public T0002_twoStackQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    public void add(int num) {
        this.pushStack.push(num);
    }

    public int poll() {
        if (this.pushStack.isEmpty() && this.popStack.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return this.popStack.pop();

    }

    public int peek() {
        if (this.pushStack.isEmpty() && this.popStack.isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return this.popStack.peek();
    }

    public void pushToPop() {
        if (this.popStack.isEmpty()) {
            while (!this.pushStack.isEmpty()) {
                int popNum = this.pushStack.pop();
                this.popStack.push(popNum);
            }
        }
    }
}
