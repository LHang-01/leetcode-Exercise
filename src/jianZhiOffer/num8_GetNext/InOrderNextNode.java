package jianZhiOffer.num8_GetNext;

/**
 * 剑指offer面试题8--二叉树中序遍历的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 给的节点node分三种情况：
 * 1.node有右节点，则下一个结点就是node.right子树中的最左边的结点，也就是从node.right开始找左子节点，直到左子节点为null就找了。
 * 2.node无右节点，又分为两种情况：2.1 node是父节点的左子节点，则下一个结点就是父节点；
 *                               2.2 node是父节点的右子节点，则需要不断地找父节点，记为node=node.next，直到父节点不再是右子节点，而是左子节点，即node==node.next.left,下一节点就是node.next。
 *                               注意：2.1和2.2可以合为一种情况。
 */
public class InOrderNextNode {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // next指向父结点
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode node) {
        //1.node有右节点
        if (node.right!=null){
            //下一个结点是node.right子树中的最左子节点
            node=node.right;
            while (node.left!=null){
                node = node.left;
            }
            return node;
        }
        //2.node无右节点，直到找到该节点的父节点是左子节点（前提是该节点有父节点才能找父节点），就找到了下一节点就是该节点的父节点。
        while (node.next!=null&&node.next.right==node){
            node=node.next;
        }
        //3.两种情况会跳出循环：
        //3.1.node.next==null，说明node是根节点，则下一节点就是null（=node.next）；
        //3.2.node.next.left=node，说明找到了node的父节点是左子节点的情况，则下一节点就是node.next。
        return node.next;
    }

}
