package tree;

public class num111 {
    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36.6 MB, 在所有 java 提交中击败了92.07%的用户
     *
     * 重点是叶子节点：没有左节点和右节点。
     * 这道题很容易在这里出问题，【1，2】
     *      1
     *    /
     *  2
     *  这一颗树的最小深度，应该是2（当初眼瞎以为是1），因为1不是叶子结点，而2才是叶子结点。
     *  深度是某一叶子节点到根节点的距离。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //判断是不是空节点
        if (root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            //判断是不是叶子节点（没有左右节点的就是叶子节点）
            return 1;
        }else if (root.left==null){
            //若左子树为空，右子树不空，则最小深度=1+右子树最小深度
            return minDepth(root.right)+1;
        }else if (root.right==null){
            //若右子树为空，左子树不空，则最小深度=1+左子树最小深度
            return minDepth(root.left)+1;
        }else {
            // 该节点下面还有左子树和右子树时取左右子树中的最小深度加上+1=最小深度。
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
    }
}
