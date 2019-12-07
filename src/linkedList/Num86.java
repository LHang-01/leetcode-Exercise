package linkedList;

import java.util.LinkedList;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 */
public class Num86 {
    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 35.5 MB
     * , 在所有 java 提交中击败了
     * 57.14%
     * 的用户
     *
     * 我们可以用两个指针before 和 after 来追踪上述的两个链表。两个指针可以用于分别创建两个链表，
     * 然后将这两个链表连接即可获得所需的链表。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode s = small;
        ListNode l = large;
        while (head!=null){
            if (head.val<x){
                s.next=head;
                s=s.next;
            }else {
                l.next=head;
                l=l.next;
            }
            head=head.next;
        }
        l.next=null;
        s.next=large.next;
        return small.next;

    }
}
