package linkedList;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Num21 {
    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了84.20%的用户
     * 内存消耗 :39.3 MB, 在所有 java 提交中击败了68.90%的用户
     *
     * 思路：
     * 如果 l1 当前位置的值小于等于 l2 ，我们就把 l1 的值接在 pre 节点的后面同时将 l1 指针往后移一个。
     * 否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都把 pre 向后移一个元素。
     * 当某一链表为空时，则跳出循环，并且将pre指向不空的另一条链表头。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(-1);;
        ListNode ans=pre;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                pre.next=l1;
                pre=pre.next;
                l1=l1.next;
            }else {
                pre.next=l2;
                pre=pre.next;
                l2=l2.next;
            }
        }
        if (l1==null){
            pre.next=l2;
        }else {
            pre.next=l1;
        }
        return ans.next;
    }
}
