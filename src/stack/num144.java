package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class num144 {

    /**
     *执行用时 :
     * 1 ms
     * 内存消耗 :
     * 34.6 MB
     * 法一：递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root!=null){
            list.add(root.val);
            list.addAll(preorderTraversal1(root.left));
            list.addAll(preorderTraversal1(root.right));
        }
        return list;
    }

    /**
     *执行用时 : 1 ms, 在所有 java 提交中击败了84.09%的用户
     * 内存消耗 :34.6 MB , 在所有 java 提交中击败了 41.65%的用户
     *
     * 这个前序遍历和中序遍历的不同点是
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                list.add(root.val);
                stack.add(root);
                root=root.left;
            }
            TreeNode temp=stack.pop();
            root=temp.right;

        }
        return list;
    }
}
