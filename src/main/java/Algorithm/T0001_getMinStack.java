package Algorithm;

import java.util.Stack;

/**
 * @Created by XDarker
 * @Description 设计一个有getMin功能的栈
 * @Date 2020/8/3 23:04
 */
public class T0001_getMinStack {


    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public T0001_getMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {

        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= this.getMinNum()) {
            stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public Integer pop() {
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public Integer getMinNum() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }

}
