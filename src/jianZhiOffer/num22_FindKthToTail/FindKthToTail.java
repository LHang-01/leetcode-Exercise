package jianZhiOffer.num22_FindKthToTail;

/**
 * 剑指offer面试题22--链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 双指针
 */

public class FindKthToTail {
    //设置两个指针a、b，若当a指针到链表末尾时，b指针正好指向倒数第k个结点，此时返回指针b处的结点即可，这时a指针的位置减去b指针的位置等于k-1，
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k <= 0) return null;
        ListNode fast = head;
        while (k-1>0&&fast!=null){
            fast = fast.next;
            k--;
        }
        if (fast==null) return null;
        while (fast.next!=null){
            fast=fast.next;
            head=head.next;
        }
        return head;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
