package jianZhiOffer.print_linked_list_from_end_to_head;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 剑指offer面试题6--从尾到头打印链表
 * 输入一个链表的头节点，从尾到头打印链表每个节点的值
 */
public class Num6_FromEndToHead {
    //1.用栈实现
    //时间复杂度为O(n)、空间复杂度为O(n)
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        //相当于return new ArrayList<>(stack);
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
    //2.递归实现
    //如果没到链表尾部，就不断递归，直到最后一个节点，之后开始返回，执行下一句add方法，此时第一个被添加的是尾节点，最后一步递归调用的返回（即第一次递归调用）将添加最开始的头节点。
    //时间复杂度为O(n)、空间复杂度为O(n)
    private ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode!=null) {
            printListFromTailToHead1(listNode.next);
            ans.add(listNode.val);
        }
        //终止条件:listNode=null
        return ans;
    }
    //3.如果可以改变链表结构，则可以先反转链表指针，在遍历输出即可，可以不用辅助空间
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
