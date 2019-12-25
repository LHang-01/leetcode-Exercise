package array;

import java.util.HashMap;

/**
 * 树、深度优先搜索、数组
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Num105 {
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> map;
    //思路：递归
    // 先在前序遍历中找到父节点，然后利用该节点到中序遍历数组中找到左子树和右子树（中序），根据中序左子树的节点数在前序数组中划分出前序左子树和前序右子树。
    // 再继续调用递归函数（传入左子树的中序和前序数组，传入右子树的中序和前序数组）
    //执行用时 :14 ms, 在所有 java 提交中击败了47.43%的用户
    //内存消耗 :42.7 MB, 在所有 java 提交中击败了23.23%的用户
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||preorder.length==0) return null;
        this.preorder=preorder;
        this.inorder=inorder;
        return dfs(0,preorder.length,0,inorder.length);
    }

    private TreeNode dfs(int p_start, int p_end, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        //1.先在前序遍历中找到父节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //2.在中序遍历中找到根节点的位置
        int i = i_start;
        for (;i<i_end;i++){
            if (inorder[i]==root_val){
                break;
            }
        }
        int leftNum = i - i_start;
        //3.递归的构造左子树
        root.left = dfs(p_start + 1, p_start + 1+ leftNum, i_start, i);
        //4.递归的构造右子树
        root.right = dfs(p_start + leftNum + 1, p_end,i + 1, i_end);
        return root;
    }
    //递归改进：在中序遍历中找到根节点的位置每次都得遍历中序遍历的数组去寻找，参考这里 ，我们可以用一个HashMap把中序遍历数组的每个元素的值和下标存起来
    //执行用时 :3 ms, 在所有 java 提交中击败了95.40%的用户
    //内存消耗 :38.4 MB, 在所有 java 提交中击败了60.16%的用户
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder==null||preorder.length==0) return null;
        this.preorder=preorder;
        this.inorder=inorder;
        map = new HashMap<>();
        for (int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs1(0,preorder.length,0,inorder.length);
    }

    private TreeNode dfs1(int p_start, int p_end, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        //1.先在前序遍历中找到父节点
        TreeNode root = new TreeNode(preorder[p_start]);
        //2.在中序遍历中找到根节点的位置
        int i = map.get(preorder[p_start]);
        int leftNum = i - i_start;
        //3.递归的构造左子树
        root.left = dfs1(p_start + 1, p_start + 1+ leftNum, i_start, i);
        //4.递归的构造右子树
        root.right = dfs1(p_start + leftNum + 1, p_end,i + 1, i_end);
        return root;
    }
}
