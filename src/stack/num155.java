package stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 *
 * 执行用时 : 8 ms , 在所有 java 提交中击败了 92.64%的用户
 * 内存消耗 : 40.6 MB, 在所有 java 提交中击败了95.13%的用户
 *
 * 思路：重点是维护最小栈的栈顶
 * 我采用的是在添加push的时候维护：
 * push时，比较节点与最小栈的栈顶元素的大小：
 * 若当前节点小，则在最小栈中增加该节点；若栈顶元素小，则说明即使增加当前节点，但最小元素，仍然是栈顶元素，因此在最小栈中重复增加栈顶元素
 * 这样就有一个好处，当出栈的时候，不仅stack可以直接出栈，minstack也可以直接出栈
 *
 */
public class num155 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public num155() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()){
            if (minStack.peek()>x){
                minStack.push(x);
            }else {
                minStack.push(minStack.peek());
            }
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
