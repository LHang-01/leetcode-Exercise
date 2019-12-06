package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class Num141 {
    /**
     * 执行用时 :
     * 6 ms
     * , 在所有 java 提交中击败了
     * 25.46%
     * 的用户
     * 内存消耗 :
     * 37.8 MB
     * , 在所有 java 提交中击败了
     * 95.98%
     * 的用户
     *
     * 这题一直有一个问题没想清楚：为什么set存节点就对，存节点的值就是错的。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head=head.next;
        }
        return false;
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :
     * 37.1 MB
     * , 在所有 java 提交中击败了97.08%的用户
     *
     * 设置两个指针，一个每次走一步，另一个每次走两步，分别称之为快、慢指针。
     * 如果快慢两个指针在一个环形链表里，那么快指针一定会追上慢指针，否则快指针会先走到链表尾部，说明没有环存在。
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head==null||head.next==null) return false;
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
