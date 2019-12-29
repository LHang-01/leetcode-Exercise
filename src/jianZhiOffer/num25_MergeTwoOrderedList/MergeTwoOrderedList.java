package jianZhiOffer.num25_MergeTwoOrderedList;

import java.util.List;

/**
 * 剑指offer面试题25--合并两个有序链表(leetcode21. 合并两个有序链表)
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 */
public class MergeTwoOrderedList {
    //1.非递归
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null||list2==null){
            return list1==null?list2:list1;
        }
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                pre.next = list1;
                pre=pre.next;
                list1 = list1.next;
            }else {
                pre.next = list2;
                pre=pre.next;
                list2 = list2.next;
            }
        }
        if (list1==null){
            pre.next=list2;
        }else {
            pre.next=list1;
        }
        return ans.next;
    }

    //2.递归实现
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode mergedHead = null;
        if (list1.val < list2.val) {
            mergedHead = list1;
            mergedHead.next = Merge(list1.next, list2);
        } else {
            mergedHead = list2;
            mergedHead.next = Merge(list1, list2.next);
        }
        return mergedHead;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}