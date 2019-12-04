package tree;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class num112 {

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 : 37.5 MB, 在所有 java 提交中击败了53.89%的用户
     *
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        //如果当前节点空节点，则false
        if(root==null) return false;
        sum=sum-root.val;
        //如果当前节点是叶子，检查 sum 值是否为 0，也就是是否找到了给定的目标和
        if (sum==0&&root.left==null&&root.right==null) return true;
        //当没有找到了给定的目标和时，递归调用左节点和右节点，只要有一条路径满足就行。
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }


}
