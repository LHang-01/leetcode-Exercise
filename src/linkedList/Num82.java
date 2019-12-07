package linkedList;

import java.util.HashSet;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Num82 {
    public  static  void main(String[] arrs){
        ListNode node =new ListNode(1);
        node.next=new ListNode(1);
        /*ListNode last=node.next;
        last.next=new ListNode(3);
        last=last.next;
        last.next=new ListNode(3);
        last=last.next;
        last.next=new ListNode(4);
        last=last.next;
        last.next=new ListNode(4);
        last=last.next;
        last.next=new ListNode(5);
        */
        deleteDuplicates(node);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 98.33%
     * 的用户
     * 内存消耗 :
     * 36.8 MB
     * , 在所有 java 提交中击败了
     * 60.58%
     * 的用户
     * 方法：当前节点的值=下一节点的值时，重复节点的首位不动，删除下一节点，并把flag=true；
     *      下一节点=null&&当前节点的值!=下一节点的值时,需要判断：若flag=false，则说明没有进入过循环，即当前节点不是没有被删除的首个重复值，因此，当前节点往后移动一位；
     *                                           若flag=true，则说明当前节点进入过循环，再判断：若因为下一节点的值不等于当前节点的值而跳出循环，则原地删除当前节点；
     *                                                                                        否则就是因为下一节点=null，这种情况就是当前节点恰好是没有被删除的首个重复节点；
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode node = new ListNode(0);
        node.next=head;
        ListNode pre = node;
        while (head!=null) {
            if (head.next == null) {
                break;
            }
            boolean flag = false;
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
                flag = true;
            }
            if (flag == false) {
                pre = head;
                head = head.next;
            } else if (head.next != null && head.val != head.next.val) {
                head.val = head.next.val;
                head.next = head.next.next;
            } else {
                pre.next = null;
            }
        }
        return node.next;
    }
}