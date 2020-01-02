package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class num113 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        dfs(lists,target,root,list);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, int target, TreeNode root, List<Integer> list) {
        //如果当前节点是根节点
        if(root.left==null&&root.right==null){
            if (target==root.val){
                //节点的值==target
                list.add(root.val);
                lists.add(list);
            }
            return;
        }
        //如果当前节点不是根节点
        target = target - root.val;
        //复制一份，递归完左节点后list已经改变，因此为避免这种问题复制一份在递归左右节点时用
        list.add(root.val);
        List<Integer> list1 = new ArrayList<>(list);
        if (root.left!=null) dfs(lists,target,root.left,list);
        if (root.right!=null) dfs(lists,target,root.right,list1);
    }
}
