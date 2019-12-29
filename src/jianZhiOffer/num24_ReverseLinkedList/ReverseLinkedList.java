package jianZhiOffer.num24_ReverseLinkedList;

import java.util.Stack;

/**
 * 剑指offer面试题24--反转链表
 * 输入一个链表的头结点，反转链表后，并返回反转链表的头结点。
 */
public class ReverseLinkedList {
    //1.用栈，空间复杂度为O(N)不推荐
    public ListNode reverseList1(ListNode head) {
        if (head==null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        head=stack.pop();
        ListNode ans =head;
        while (!stack.isEmpty()){
            head.next= stack.pop();
            head=head.next;
        }
        //注意：一定要把最后一个节点的next设为null
        head.next = null;
        return ans;
    }

    //2.设置三个指针，分别指向前一结点、当前结点、后一结点。
    // 当前结点的next本来是指向它的后一结点的，现在让其指向它的前一个结点，就实现了链表的反转。
    // 但是当前结点与它后一个结点链接断开了，因此在反转链表之前需要保存当前结点的下一个结点的指针。以便链表反转的过程向前推进（当前指针和前一指针前移）。
    public ListNode reverseList2(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode pre = null;
        ListNode now = head;
        while (now!=null){
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    //3递归解法(不是很理解)
    //如果链表为空，就返回null；如果链表只有一个结点，就返回该结点。链表长度大于等于2时思路时，先递归到倒数第一个结点处。
    // 即下面代码中的revHead，然后返回它，递归调用的返回中逐层返回的都是这个revHead，这保证了最后返回的是反转后的头结点。
    // 接着递归调用返回到上一层。nextNode就是最后一个结点，而head是倒数第二个结点，让nextNode.next 指向head就实现了链表的反转，之后倒数第二个结点的next要指向null，因为它原先是指向nextNode的，同时也保证了最后一个结点的next也指向null的正确性。
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode revHead = reverseList3(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return revHead;

    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}