package tree;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class num98 {
    //负无穷
    double pre = Double.NEGATIVE_INFINITY;

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 92.41%的用户
     * 内存消耗 :36.8 MB, 在所有 java 提交中击败了92.22%的用户
     * 利用搜索树的中序遍历一定是递增的，来解决这个问题。
     * 方法：递归
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        //中序遍历(左中右），并记录上一个值，当前值若小于上一个值，则说明不是搜索树
        if (isValidBST(root.left)){
            if (root.val>pre){
                pre=root.val;
                return isValidBST(root.right);
            }else {
                return false;
            }
        }
        return false;
    }
}
