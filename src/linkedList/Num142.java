package linkedList;

import java.util.HashSet;
import java.util.Set;

public class Num142 {
    public ListNode detectCycle(ListNode head) {
        /**
         * 执行用时 :
         * 8 ms
         * , 在所有 java 提交中击败了
         * 28.21%
         * 的用户
         * 内存消耗 :
         * 36.2 MB
         * , 在所有 java 提交中击败了
         * 5.03%
         * 的用户
         *
         * 法一：哈希表
         */
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }

    /**
     * Floyd 的算法被划分成两个不同的 阶段 。
     * 在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 null 并退出。否则，用 相遇节点 来找到环的入口。
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 35.8 MB
     * , 在所有 java 提交中击败了
     * 8.16%
     * 的用户
     */
    public ListNode detectCycle1(ListNode head) {
        if (head==null||head.next==null) return null;
        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                fast=head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
