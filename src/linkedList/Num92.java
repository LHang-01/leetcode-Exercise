package linkedList;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Num92 {

    public  static  void main(String[] arrs){
        ListNode node =new ListNode(1);
        node.next=new ListNode(2);
        ListNode last=node.next;
        last.next=new ListNode(3);
        last=last.next;
        last.next=new ListNode(4);
        last=last.next;
        last.next=new ListNode(5);
        reverseBetween(node,2,4);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 34.1 MB
     * , 在所有 java 提交中击败了
     * 87.49%
     * 的用户
     *
     * 用pre标记节点位置m-1，用temp2记节点位置m,对m到n范围内的节点反转链表，并用last标记n的位置，temp1标记n+1的位置
     * 则结果就是pre.next=last;temp2.next=temp1
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int num =1;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre =root;
        while (num<m){
            pre=head;
            head=head.next;
            num++;
        }
        ListNode temp2 = head;
        ListNode last =null;
        ListNode temp1 = null;
        while (num<=n&&head!=null){
            temp1=head.next;
            head.next=last;
            last=head;
            head=temp1;
            num++;
        }
        pre.next = last;
        if (head!=null){
            temp2.next=temp1;
        }
        return root.next;
    }

}
