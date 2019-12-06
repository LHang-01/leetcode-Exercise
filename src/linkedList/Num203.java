package linkedList;

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Num203 {
    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 :
     * 39.2 MB
     * , 在所有 java 提交中击败了 94.47%的用户
     *
     * 用一个临时变量来存储当前节点的前一个节点，即pre.next=head
     * 当当前节点head.val=val时，删除当前节点，既让pre.next=head.next，head向后移动一位继续遍历;
     * 当head.val！=val时，pre和head都向后移动一位;
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next=head;
        ListNode pre = node;
        while (head!=null){
            if(head.val!=val) {
                pre = head;
            }else {
                pre.next=head.next;
            }
            head=head.next;
        }
        return node.next;
    }
}
