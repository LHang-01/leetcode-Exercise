package tree;

/**
 *226. 翻转二叉树
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class num226 {
    /**
     * 执行用时 : 0 ms , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :34.1 MB , 在所有 java 提交中击败了 41.13%的用户
     *
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //如果当前节点是空节点，则不再递归这棵树
        if (root == null) {
            return null;
        }
        //交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //翻转左子树
        invertTree(root.left);
        //翻转右子树
        invertTree(root.right);
        return root;
    }
}
