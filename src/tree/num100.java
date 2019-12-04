package tree;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 */
public class num100 {
    /**
     * 执行用时 : 0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 : 34.3 MB, 在所有 java 提交中击败了83.99%的用户
     *
     * 思路：递归，先判断自己是否相等，再递归调用函数判断左右节点是否相等；
     * 当p或q的节点为空时则跳出循环；只有p==q=null的时候才返回true。
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        while (p!=null&&q!=null){
            //当前节点是否相等
            if (p.val!=q.val) return false;
            //左节点是否相等
            if (isSameTree(p.left,q.left)){
                //右节点是否相等
                if (isSameTree(p.right,q.right)){
                    return true;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if (p!=null) return false;
        if (q!=null) return false;
        return true;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
