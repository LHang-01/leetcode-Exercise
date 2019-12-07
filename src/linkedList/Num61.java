package linkedList;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
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
     * 超出内存限制
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了 100.00%的用户
     * 内存消耗 :
     * 35.7 MB
     * , 在所有 java 提交中击败了 83.09% 的用户
     *
     * 先将链表闭合成环
     * 找到相应的位置断开这个环，确定新的链表头和链表尾
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null||head.next == null) return head;
        int sum;
        ListNode last = head;
        for (sum=1;last.next!=null;sum++){
            last=last.next;
        }
        k=k%sum;
        if(k==0) return head;
        last.next=head;
        for (int i=0;i<sum-k;i++){
            last=head;
            head=head.next;
        }
        last.next=null;
        return head;
    }
    /**
     * 先将链表闭合成环
     * 找到相应的位置断开这个环，确定新的链表头和链表尾
     * 超出内存限制
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        int sum=1;
        ListNode root = head;
        ListNode last = head;
        while (last.next!=null){
            last=last.next;
            sum++;
        }
        last.next=root;
        k=k%sum;
        if(k==0) return head;
        while (k!=0){
            root=root.next;
            k--;
        }
        last=root.next;
        root.next=null;
        return last;
    }

}
