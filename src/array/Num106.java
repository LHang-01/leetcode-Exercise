package array;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Num106 {
    private int[] postorder;
    private int[] inorder;
    private HashMap<Integer, Integer> map;
    public static void main(String [] arrs){
        Num106 num106 = new Num106();
        num106.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
    }
    //思路：递归
    //先在后序遍历中找到父节点，然后利用该节点到中序遍历数组中找到左子树和右子树（中序），根据中序左子树的节点数在后序数组中划分出后序左子树和后序右子树。
    //再继续调用递归函数（传入左子树的中序和后序数组，传入右子树的中序和后序数组）
    //执行用时 :3 ms, 在所有 java 提交中击败了92.58%的用户
    //内存消耗 :40.1 MB, 在所有 java 提交中击败了33.41%的用户
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder==null||postorder.length==0) return null;
        this.postorder=postorder;
        this.inorder=inorder;
        map = new HashMap<>();
        for (int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs1(0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode dfs1(int i_start, int i_end,int p_start, int p_end) {
        // postorder 为空，直接返回 null
        if (p_start>p_end&&i_start>i_end||p_end<0||i_end<0) {
            return null;
        }
        //1.先在后序遍历中找到父节点
        TreeNode root = new TreeNode(postorder[p_end]);
        //2.在中序遍历中找到根节点的位置
        int i = map.get(postorder[p_end]);
        //3.递归的构造左子树
        root.left = dfs1(i_start, i-1,p_start, p_end-i_end+i-1);
        //4.递归的构造右子树
        root.right = dfs1(i + 1, i_end,p_end-i_end + i, p_end-1);
        return root;
    }
}
