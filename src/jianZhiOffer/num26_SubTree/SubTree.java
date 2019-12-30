package jianZhiOffer.num26_SubTree;

/**
 * 剑指offer面试题26--树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class SubTree {
    //1.递归
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return dfs(root1,root2,root1,root2);
    }

    /**
     *
     * @param root1 当前A需要匹配的节点
     * @param root2 当前B需要匹配的节点
     * @param node 当A树和B树匹配失败时，A树的回退点，即回退到A树与B树匹配的根节点的左右节点继续匹配
     * @param root 当A树和B树匹配失败时，B树的回退点，即B的根节点
     * @return
     */
    private boolean dfs(TreeNode root1, TreeNode root2, TreeNode node, TreeNode root) {
        //当对比的root2节点为null时，返回true；
        if (root2 == null) return true;
        //当root1为空，但root2不为空，则返回false；
        if (root1 == null&&root2!= null) return false;
        //当对比的两个节点都不是null时：
        if (root1.val==root2.val){
            //值相等，则进一步比较左右节点
            if (!(dfs(root1.left,root2.left, node, root)&&dfs(root1.right,root2.right, node, root))){
                //尽管根节点能匹配，但是不能全部匹配上，A树的下一个节点需要回退到此次匹配的根节点的左子节点和右子节点与B树的回退点（根节点）重新匹配
                return dfs(node.left,root,node.left,root)||dfs(node.right,root,node.right,root);
            }else {
                //完全匹配，返回true
                return true;
            }
        }else {
            //值不相等，说明此条匹配路径失败
            return false;
        }
    }
    public static void main(String [] arrs){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        TreeNode left = root1.left;
        root1.right = new TreeNode(7);
        left.left=new TreeNode(9);
        left.right=new TreeNode(2);
        left=left.right;
        left.left=new TreeNode(4);
        left.right=new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left=new TreeNode(9);
        root2.right= new TreeNode(2);

        System.out.println(new SubTree().hasSubtree(root1,root2));
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
