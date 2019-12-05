package tree;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */

public class num404 {
    public static void main(String[] arrs){
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        return leftSun(root.left,root.right,0);
    }

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :35 MB , 在所有 java 提交中击败了 79.79%的用户
     *
     * 思路：传入左右节点，
     * 判断左节点是否为空，不空则继续判断左节点是否是叶子结点，是则做假发，不是则继续递归左节点的左右节点；
     * 判断右节点是否为空，不为空则继续递归右节点的左右节点；
     * 当左节点和右节点都为空时，则计算完毕，返回结果。
     * @param left
     * @param right
     * @param sum
     * @return
     */
    public static int leftSun(TreeNode left,TreeNode right,int sum) {
        if (left!=null){
            //左节点不为空
            if (left.right==null&&left.left==null){
                //并且左节点是叶子结点
                sum+=left.val;
            }else {
                sum=leftSun(left.left,left.right,sum);
            }
        }
        if (right!=null){
            //右节点不为空，则继续递归
            sum=leftSun(right.left,right.right,sum);
        }
        return sum;
    }


}
