package linkedList;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Num61 {
    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 100.00%的用户
     * 内存消耗 : 35.7 MB , 在所有 java 提交中击败了 83.09% 的用户
     *
     * 先将链表闭合成环
     * 找到相应的位置断开这个环，确定新的链表头和链表尾
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null||head.next == null) return head;
        int sum;
        ListNode last = head;
        //统计链表中节点数量
        for (sum=1;last.next!=null;sum++){
            last=last.next;
        }
        k=k%sum;
        //如果只用走0b步，直接返回头结点
        if(k==0) return head;
        //将尾结点指向头结点，则链表闭合成环
        last.next=head;
        //继续走sum-k步，就找到了右旋转k步后的头结点head和尾结点last
        for (int i=0;i<sum-k;i++){
            last=head;
            head=head.next;
        }
        //将头结点和尾结点断开
        last.next=null;
        //返回头结点
        return head;
    }
}
