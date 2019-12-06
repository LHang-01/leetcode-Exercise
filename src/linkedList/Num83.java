package linkedList;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Num83 {
    /**
     * 执行用时 :1 ms
     * , 在所有 java 提交中击败了 98.51%
     * 的用户
     * 内存消耗 :36.5 MB
     * , 在所有 java 提交中击败了65.61%
     * 的用户
     *
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode root = head;
        while (head.next!=null){
            if (head.next.val==head.val){
                //如果节点的下一个节点=本节点，则本节点的下一个节点=本节点的下一个节点的下一个节点，即删掉了重复的节点
                head.next=head.next.next;
            }else {
                //如果节点的下一个节点！=本节点，则说明不重复，因此本节点=本节点的下一个节点
                head=head.next;
            }
        }
        return root;
    }
}
