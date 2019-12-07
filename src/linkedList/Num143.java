package linkedList;

import java.util.Stack;

public class Num143 {
    /**
     * 执行用时 :
     * 7 ms
     * , 在所有 java 提交中击败了
     * 14.66%
     * 的用户
     * 内存消耗 :
     * 38.8 MB
     * , 在所有 java 提交中击败了
     * 95.53%
     * 的用户
     *
     *用栈存链表，并记录总的链表个数，计半数=总个数%2
     * 先依次把栈顶和链表的元素作为下一个节点，循环半数-1次
     * 当偶数节点时，再把栈顶元素添加到下一个节点，并把该节点的next=null;
     * 当基数节点时，再把栈顶元素和链表元素依次添加到下一个节点，一轮，并把最后加入的链表节点的next=null；
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode root =head;
        int sum = 0;
        while (head!=null){
            stack.push(head);
            head=head.next;
            sum++;
        }
        head=root;
        int ans = sum%2;
        sum=sum/2;
        ListNode pre;
        while (sum>1){
            pre =head.next;
            head.next=stack.pop();
            head=head.next;
            head.next=pre;
            head=head.next;
            sum--;
        }
        if (ans!=0){
            pre =head.next;
            head.next=stack.pop();
            head=head.next;
            head.next=pre;
            pre.next=null;
        }else {
            head.next=stack.pop();
            head=head.next;
            head.next=null;
        }
        head=root;
    }

    /**
     * //找中点，链表分成两个
     * //第二个链表倒置
     * //链表节点依次连接
     *
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39.3 MB
     * , 在所有 java 提交中击败了
     * 95.21%
     * 的用户
     */
    public void reorderList1(ListNode head) {
        if (head==null||head.next==null) return;
        //找中点，链表分成两个
        ListNode slow =head;
        ListNode fast = head;
        ListNode root =head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //第二个链表倒置
        fast=slow.next;
        slow.next = null;
        slow =null;
        while (fast!=null){
            ListNode pre= fast.next;
            fast.next=slow;
            slow=fast;
            fast=pre;
        }

        //链表节点依次连接
        while (head!=null&&slow!=null){
            ListNode temp = head.next;
            head.next=slow;
            slow=slow.next;
            head.next.next=temp;
            head=head.next.next;
        }
        if (slow!=null) head.next=slow;
        head=root;
    }
}
