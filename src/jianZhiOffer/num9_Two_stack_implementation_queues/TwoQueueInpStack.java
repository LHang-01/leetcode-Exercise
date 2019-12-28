package jianZhiOffer.num9_Two_stack_implementation_queues;

import java.util.Queue;

/**
 * 剑指offer面试题9相关题目--两个队列实现栈
 *
 */
public class TwoQueueInpStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    //入栈：哪个队列不为空就进入该队列中
    public void push(int node) {
        if (!queue1.isEmpty()) {
            queue1.offer(node);
        }else {
            queue2.offer(node);
        }
    }

    //出栈：将不为空的队列中除了最后一个元素之外的所有元素都删除到另一个队列中，然后出列最后一个元素即可。
    public int pop() {
        if (queue1.isEmpty()&&queue2.isEmpty()){
            throw new RuntimeException("栈为空");
        }
        if (!queue1.isEmpty()){
            return function(queue1,queue2);
        }
        return function(queue2,queue1);
    }

    private int function(Queue<Integer> a, Queue<Integer> another) {
        while (a.size()!=1){
            another.offer(a.poll());
        }
        return a.poll();
    }
}
