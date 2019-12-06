package linkedList;

import java.util.Stack;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Num206 {
    public static void main(String [] arrs){
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        reverseList(node);
    }

    /**
     * 迭代：
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。
     *
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.9 MB
     * , 在所有 java 提交中击败了
     * 48.53%
     * 的用户
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head==null) return head;
        ListNode last =null;
        while (head!=null){
            ListNode pre=head.next;
            head.next=last;
            last=head;
            head=pre;
        }
        return last;
    }
}
