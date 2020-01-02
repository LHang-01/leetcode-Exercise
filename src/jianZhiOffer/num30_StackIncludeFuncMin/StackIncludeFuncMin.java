package jianZhiOffer.num30_StackIncludeFuncMin;

import java.util.Stack;

/**
 * 剑指offer面试题30--包含min方法的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。要求push、pop、min方法的时间复杂度都为O(1)
 */
public class StackIncludeFuncMin {
    private Stack<Integer> stack = new Stack<>();
    // 辅助栈，用于存储当前最小值
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        //存放数据的stack存入当前元素，如果即将要存入的元素比当前最小元素还小，stackMin存入这个新的最小元素；否则，stackMin将当前最小元素再次存入。
        stack.push(node);
        if (stackMin.isEmpty()||stackMin.peek()>node){
            stackMin.push(node);
        }else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return stack.peek();
    }

    public int min() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stackMin is empty!");
        }
        return stackMin.peek();
    }
}
