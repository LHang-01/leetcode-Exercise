package jianZhiOffer.num7_buildTree;

import java.util.HashMap;

/**
 * 剑指offer面试题7--重建二叉树
 * leetcode105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class BuildTree {
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] arrs){
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree1(new  int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
    //思路：递归
    // 先在前序遍历中找到父节点，然后利用该节点到中序遍历数组中找到左子树和右子树（中序），根据中序左子树的节点数在前序数组中划分出前序左子树和前序右子树。
    // 再继续调用递归函数（传入左子树的中序和前序数组，传入右子树的中序和前序数组）
    // 递归改进：在中序遍历中找到根节点的位置每次都得遍历中序遍历的数组去寻找，参考这里 ，我们可以用一个HashMap把中序遍历数组的每个元素的值和下标存起来
    //执行用时 :3 ms, 在所有 java 提交中击败了95.40%的用户
    //内存消耗 :38.4 MB, 在所有 java 提交中击败了60.16%的用户
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length==0) return null;
        this.inorder=inorder;
        this.preorder=preorder;
        //用一个HashMap把中序遍历数组的每个元素的值和下标存起来,方便查找根节点的位置
        for (int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(0,preorder.length-1,0,inorder.length-1);
    }

    /**
     * @param pre1  子树在preorder中的前序数组的起始位置
     * @param pre2  子树在preorder中的前序数组的结束位置
     * @param in1   子树在inorder中的中序数组的起始位置
     * @param in2   子树在inorder中的中序数组的结束位置
     * @return
     */
    private TreeNode dfs(int pre1, int pre2, int in1, int in2) {
        //1.建立根节点，并计算根节点的左子树长度和右子树长度
        TreeNode node = new TreeNode(preorder[pre1]);
        int leftlen=map.get(preorder[pre1])-in1;
        //2.构建左子树
        if (leftlen>0){
            //2.1左子树长度不为零，递归调用dfs函数以构造这个左子树
            node.left=dfs(pre1+1,pre1+leftlen,in1,leftlen+in1-1);
        }else {
            //2.2左子树长度=零
            node.left= null;
        }
        int rightlen=pre2-pre1-leftlen;
        //3.构建右子树
        if (rightlen>0){
            //3.1右子树长度不为零，递归调用dfs函数以构造这个右子树
            node.right=dfs(pre1+leftlen+1,pre2,leftlen+in1+1,in2);
        }else {
            //3.2右子树长度=零
            node.right=null;
        }
        //4.返回根节点
        return node;
    }


}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
