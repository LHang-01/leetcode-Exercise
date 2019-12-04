package tree;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */
public class num235 {
    /**
     * 执行用时 :7 ms, 在所有 java 提交中击败了97.85%的用户
     * 内存消耗 :35.9 MB, 在所有 java 提交中击败了82.46%的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //两个节点都在左子树,继续收搜
        if (p.val<root.val&&q.val<root.val) return lowestCommonAncestor(root.left,p,q);
        //两个节点都在右子树,继续收搜
        if (p.val>root.val&&q.val>root.val) return lowestCommonAncestor(root.right,p,q);
        //某一个节点就是根节点,或者一个节点在左边一个节点在右边，则根节点root就是最近公共祖先
        return root;
    }
}
