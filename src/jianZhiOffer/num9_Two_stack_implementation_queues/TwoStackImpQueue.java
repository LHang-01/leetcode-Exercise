package jianZhiOffer.num9_Two_stack_implementation_queues;

import java.util.LinkedList;

/**
 * 剑指offer面试题9--两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的appendTail(在队列尾部插入节点)和deleteHead（在队列头部删除节点）操作。队列中的元素为int类型。
 */
public class TwoStackImpQueue {
    //stack1用于在队列尾部插入节点
    //stack2用于在队列头部删除节点
    //stack1和2中的元素一起组成一个队列
    private LinkedList<Integer> stack1 = new LinkedList<>();
    private LinkedList<Integer> stack2 = new LinkedList<>();

    public void appendTail(int node) {
        stack1.push(node);
    }

    //弹出操作分为三种情况：
    public int deleteHead() {
        //1.stack1和stack2都为空时，说明队列为空，此时抛异常
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //2.stack2为空，则需要将stack1中元素压入stack2中
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        //3.stack2不为空，弹出栈顶元素，即队头
        return stack2.pop();
    }

}
