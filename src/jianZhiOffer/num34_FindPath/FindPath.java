package jianZhiOffer.num34_FindPath;

import java.util.ArrayList;

/**
 * 剑指off面试题34--二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 类似题目：leetcode112. 路径总和  给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *          leetcode113. 路径总和 II  给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *          leetcode437. 路径总和 III  给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
 *          路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *          leetcode257. 二叉树的所有路径 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class FindPath {
    //leetcode112. 路径总和  给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        //如果当前节点空节点，且和=0，则true;
        if(root==null&&sum==0) return true;
        //如果当前节点空节点，且和!=0，则false;
        if(root==null&&sum!=0) return false;
        sum = sum - root.val;
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);

    }
    //leetcode113. 路径总和 II  给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(lists,target,root,list);
        return lists;
    }

    private void dfs( ArrayList<ArrayList<Integer>> lists, int target, TreeNode root, ArrayList<Integer> list) {
        //如果当前节点是根节点
        if(root.left==null&&root.right==null){
            if (target==root.val){
                //节点的值==target
                list.add(root.val);
                lists.add(list);
            }
            return;
        }
        target = target - root.val;
        list.add(root.val);
        ArrayList<Integer> list1 = new ArrayList<>(list);
        if (root.left!=null) dfs(lists,target,root.left,list);
        if (root.right!=null) dfs(lists,target,root.right,list1);
    }

    //leetcode437. 路径总和 III  给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
    //1.求总路径数量
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        //计算当前节点为开始、以当前节点的左节点为开始、以当前节点的右节点为开始的所有满足条件的总和
        return fun(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int fun(TreeNode root, int target) {
        //如果当前节点为空，说明这条路径一直没找到，此时返回0
        if (root==null) return 0;
        //如果当前节点的值=sum，则说明和=target的路径又增加一条
        int res = 0;
        if (target==root.val) res=1;
        //继续遍历左右节点，看有没有其他更深的路径满足要求
        return res+fun(root.left,target - root.val)+fun(root.right,target - root.val);
    }

    //leetcode437. 路径总和 III  给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
    //2.求总路径集合

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
