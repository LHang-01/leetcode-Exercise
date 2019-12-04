package tree;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class num104 {
    /**
     * 执行用时 : 0 ms , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.5 MB , 在所有 java 提交中击败了 44.81%的用户
     *
     * 思路：如果当前节点为空，说明高度=0；
     * 如果当前节点不为空，说明高度=1，然后取左节点和右节点的最大深度+ 1=最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
