package linkedList;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 执行用时 :  0 ms  , 在所有 java 提交中击败了 100.00% 的用户
 * 内存消耗 : 34.4 MB  , 在所有 java 提交中击败了 83.32% 的用户
 */
public class Num24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode ans = new ListNode(0);
        ans.next=head;
        //pre指向已经交换完成的尾结点
        ListNode pre = ans;
        //slow和fast指向正要交换的两个相邻节点
        ListNode slow = pre.next;
        ListNode fast ;
        //temp指向下一次要交换的开始节点，相当于fast.next
        ListNode temp ;
        //只要两个交换节点都不为空时，才循环。
        while (slow!=null&&slow.next!=null){
            fast=slow.next;
            temp=fast.next;
            //交换slow和fast：将pre尾结点指向fast，再将fast.next指向slow，再将slow指向temp.
            pre.next=fast;
            fast.next=slow;
            slow.next=temp;
            //交换完成后，移动pre到目前的尾结点slow,slow指向下一次交换的头结点
            pre=slow;
            slow=temp;
        }
        return ans.next;
    }
}
