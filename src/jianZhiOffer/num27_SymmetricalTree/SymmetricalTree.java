package jianZhiOffer.num27_SymmetricalTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指offer面试题27--对称的二叉树(leetcode101. 对称二叉树)
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalTree {
    //1.递归
    public boolean isSymmetric1(TreeNode root) {
        return duiCheng(root,root);
    }

    private boolean duiCheng(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null) return true;
        if (root1==null||root2==null) return false;
        if (root1.val==root2.val){
            return duiCheng(root1.left,root2.right)&&duiCheng(root1.right,root2.left);
        }else {
            return false;
        }
    }
    //2.非递归
    //需要用到两个栈。A专门存入根节点的左子树，B专门存入根节点的右子树。
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root.left);
        stack2.push(root.right);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode pop1 = stack1.pop();
            TreeNode pop2 = stack2.pop();
            // 两个都空跳过
            if (pop1==null&&pop2==null) continue;
            if (pop1==null||pop2==null) return false;
            if (pop1.val == pop2.val){
                //注意栈1先进左节点再进右节点，栈2先进右节点，再进左节点；
                //这样才能在弹栈的时候进行对比。
                stack1.push(pop1.left);
                stack1.push(pop1.right);
                stack2.push(pop2.right);
                stack2.push(pop2.left);
            }else {
                return false;
            }
        }
        return stack1.isEmpty()&&stack2.isEmpty();
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
