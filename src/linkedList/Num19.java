package linkedList;

import java.util.Stack;

/**
 *  19. 删除链表的倒数第N个节点
 *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Num19 {

    public static void main(String [] arrs){
        ListNode node = new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        System.out.println(removeNthFromEnd1(node,2).val);
    }

    /**
     * 方法一：两次遍历算法，第一次遍历完后得到总共的节点数sum，第二次遍历从头节点开始走sum-n步
     * 执行用时 : 0 ms , 在所有 java 提交中击败了100.00% 的用户
     * 内存消耗 : 34.7 MB , 在所有 java 提交中击败了87.05%的用户
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        head = node;
        int sum = -1;
        while (head!=null){
            sum++;
            head=head.next;
        }
        sum = sum-n;
        n=-1;
        head=node;
        ListNode pre = node;
        while (n!=sum){
            n++;
            pre = head;
            head=head.next;
        }
        pre.next=head.next;
        return node.next;
    }

    /**
     * 方法二：一次遍历算法（双指针）
     * 使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔.
     * 直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     *
     * 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00%的用户
     * 内存消耗 : 34.8 MB , 在所有 java 提交中击败了86.85%的用户
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode fast = head;
        while (n!=0){
            fast=fast.next;
            n--;
        }
        ListNode pre = node;
        while (fast!=null){
            pre=head;
            head=head.next;
            fast=fast.next;
        }
        pre.next=head.next;
        return node.next;
    }

    /**
     * 用栈的思想，但是超出了内存限制（这里不用看，因为不一定对）
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode node=new ListNode(0);
        head = node;
        int sum = 1;
        while (!stack.isEmpty()){
            if (sum==n){
                stack.pop();
            }else {
                head.next=stack.pop();
                head=head.next;
            }
        }
        return node.next;
    }

}
