package jianZhiOffer.num28_mirrorRecur;

import java.util.*;

/**
 * 剑指offer面试题28--二叉树的镜像（leetcode226. 翻转二叉树）
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 这一题很重要，让我理解了层次遍历和深度遍历（非递归）
 */
public class MirrorRecur {
    //1.递归，自顶向下翻转（最先翻转的根节点的左右子节点，最后翻转的叶子结点）
    public void Mirror(TreeNode root) {
        if (root==null) return;
        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //2.递归，自底向上翻转（最先翻转的最底层的叶子结点，最后翻转的根节点的左右子节点）
    public void Mirror1(TreeNode root) {
        if (root==null) return;
        Mirror1(root.left);
        Mirror1(root.right);
        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;
    }

    //3.非递归，前序遍历(这里的旋转位置就是num144前序遍历中非递归代码打印到list中的位置，其他地方代码不变)
    public void Mirror3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 当前结点不为空，或者为空但有可以返回的父结点（可以进行pop操作）都可以进入循环
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                // 交换两个子结点
                if (root.left != null || root.right != null) {
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;
                }
                root=root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    //4.非递归，层序遍历(这里的旋转位置就是num102层序遍历中非递归代码打印到list中的位置，其他地方代码不变)
    //// (前序遍历是深度优先搜索，所以用到了栈；而层序遍历是广度优先搜索，用到队列。)
    public void Mirror4(TreeNode root){
        if (root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            // 交换两个子结点
            if (root.left != null || root.right != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            if (root.left!=null) queue.offer(root.left);
            if (root.right!=null) queue.offer(root.right);
        }
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
