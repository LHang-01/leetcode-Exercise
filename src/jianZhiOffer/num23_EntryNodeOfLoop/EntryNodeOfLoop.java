package jianZhiOffer.num23_EntryNodeOfLoop;

/**
 * 剑指offer面试题23--链表中环的入口结点（leetcode142. 环形链表 II）
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
    //1.双指针法
    //1.1有环时，一定是能在循环中return fast（=slow）;
    //1.2没环时，一定能跳出循环，return null;
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead==null||pHead.next==null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                //有环
                fast=pHead;
                while (slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
