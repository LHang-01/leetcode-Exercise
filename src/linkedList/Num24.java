package linkedList;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 执行用时 :
 * 0 ms
 * , 在所有 java 提交中击败了 100.00% 的用户
 * 内存消耗 :
 * 34.4 MB
 * , 在所有 java 提交中击败了 83.32% 的用户
 */
public class Num24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode ans = new ListNode(0);
        ans.next=head;
        ListNode pre = ans;
        ListNode slow = pre.next;
        ListNode fast ;
        ListNode temp ;
        while (slow!=null&&slow.next!=null){
            fast=slow.next;
            temp=fast.next;
            pre.next=fast;
            fast.next=slow;
            slow.next=temp;
            pre=slow;
            slow=temp;
        }
        return ans.next;
    }
}
