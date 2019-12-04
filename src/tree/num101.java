package tree;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class num101 {

    public boolean isSymmetric(TreeNode root) {
        return duiCheng(root,root);

    }

    /**
     * 执行用时 :1 ms , 在所有 java 提交中击败了 79.66% 的用户
     * 内存消耗 : 36.5 MB , 在所有 java 提交中击败了 77.84%的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean duiCheng(TreeNode a,TreeNode b){
        /*此方法可简化为：
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)&& isMirror(t1.right, t2.left)&& isMirror(t1.left, t2.right);
         */
        if (a==null&&b==null)  return true;
        if (a==null||b==null)  return false;
        if (a.val==b.val){
            if (duiCheng(a.left,b.right)){
                if (duiCheng(a.right,b.left)){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}