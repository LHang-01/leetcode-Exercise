package jianZhiOffer.num18_DeleteNode;

/**
 * 剑指offer面试题18——删除链表的结点
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间内删除该结点。假设要删除的结点确实在链表中。
 * 两种情况：1）如果删除的结点既是最后一个结点又是头结点（只有一个结点的链表），那么直接将头结点置空即可。
 *          2）当前节点为尾巴节点，则需要从头节点遍历到其前节点，然后删除尾结点；
 *          3）当前节点不是尾巴节点，则把下一节点的内容复制到当前节点，然后让当前节点指向下一节点的下一节点。
 */
public class DeleteNode {
    //题目一：删除链表的结点——给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间内删除该结点。假设要删除的结点确实在链表中。
    //leetcode237. 删除链表中的节点
    public void deleteNode(ListNode first, ListNode toBeDel) {
        if (first == null || toBeDel == null) {
            return;
        }
        //1.结点既是最后一个结点又是头结点
        if (first==toBeDel&&toBeDel.next==null){
            first=null;
        }else if (toBeDel.next==null){
           //2）当前节点为尾巴节点
            ListNode cur = first;
            while (cur.next!=toBeDel){
                cur=cur.next;
            }
            cur.next=null;
        }else {
            //3）当前节点不是头尾节点
            toBeDel.val=toBeDel.next.val;
            toBeDel.next=toBeDel.next.next;
        }
    }

    //题目二：删除链表中的重复结点：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    //leetcode82. 删除排序链表中的重复元素 II
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead==null) return null;
        //这样当头节点也是重复值时，很方便
        ListNode node = new ListNode(Integer.MAX_VALUE);
        node.next=pHead;
        //重复节点开始位置的前一个节点
        ListNode pre = node;
        //相当于i，用于遍历节点，记录重复节点的最后位置
        ListNode end = pHead;
        while (end!=null){
            //若果当前节点的下一节点是尾结点
            if (end.next==null){
                break;
            }
            //若果当前节点的值与next节点的值不同时，pre.next=end。
            if (end.next.val!=end.val){
                pre.next= end;
                pre=pre.next;
                end=end.next;
            }else{
                //当前节点的值与next节点的值相同
                while (end.next!=null&&end.val==end.next.val){
                    end=end.next;
                }
                //将与当前节点值不同的节点置为当前节点
                end = end.next;
            }
        }
        pre.next= end;
        return node.next;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
