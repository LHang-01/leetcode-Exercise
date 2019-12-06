package linkedList;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 执行用时 :
 * 1 ms
 * , 在所有 java 提交中击败了99.69%的用户
 * 内存消耗 :
 * 41.7 MB
 * , 在所有 java 提交中击败了 96.70%的用户
 *
 * 这题需要206. 反转链表的基础，反转过程中：先判断前节点last是否等于后节点pre，等则遍历last和pre；{1,2,2,2，1}
 * 若不等则再判断前节点last是否等于当前节点head，若等遍历last和head.{1,2,2，1}
 */
public class Num234 {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null) return true;
        ListNode last =head;
        head=head.next;
        last.next=null;
        while (head!=null){
            ListNode pre=head.next;
            if(pre!=null&&last.val==pre.val){
                head=pre;
                break;
            }else {
                if(head.val!=last.val){
                    head.next=last;
                    last=head;
                    head=pre;
                }else{
                    break;
                }
            }
        }
        if (head==null) return false;
        while (head!=null||last!=null){
            if (head==null||last==null) return false;
            if (head.val!=last.val) return false;
            head=head.next;
            last=last.next;
        }
        return true;
    }
}
