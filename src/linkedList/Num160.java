package linkedList;

import java.util.HashSet;

/**
 * 160. 相交链表
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，
 * 链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class Num160 {
    /**
     * 执行用时 :
     * 18 ms
     * , 在所有 java 提交中击败了
     * 11.21%
     * 的用户
     * 内存消耗 :
     * 46.8 MB
     * , 在所有 java 提交中击败了
     * 33.37%
     * 的用户
     *
     * 哈希表法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA!=null||headB!=null){
            if (headA!=null){
                if (set.contains(headA)){
                    return headA;
                }else {
                    set.add(headA);
                    headA=headA.next;
                }
            }
            if (headB!=null){
                if (set.contains(headB)){
                    return headB;
                }else {
                    set.add(headB);
                    headB=headB.next;
                }
            }
        }
        return null;
    }

    /**
     * 方法3初看很难理解，但是细想就会发现很简单很巧妙
     * A和B两个链表长度可能不同，但是A+B和B+A的长度是相同的，所以遍历A+B和遍历B+A一定是同时结束。
     * 如果A,B相交的话A和B有一段尾巴是相同的，所以两个遍历的指针一定会同时到达交点 如果A,B不相交的话两个指针就会同时到达A+B（B+A）的尾节点
     *
     * 执行用时 :
     * 1 ms
     * , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :
     * 39.1 MB
     * , 在所有 java 提交中击败了83.71%的用户
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB=headB;

        while (nodeA!=null||nodeB!=null){
            if (nodeA==null){
                nodeA=headB;
            }
            if (nodeB==null){
                nodeB=headA;
            }
            if (nodeA==nodeB){
                return nodeA;
            }else {
                nodeA=nodeA.next;
                nodeB=nodeB.next;
            }
        }
        return null;
    }

}
