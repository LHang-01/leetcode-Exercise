package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class num94 {
    /**
     * 法一：递归实现
     * 执行用时 :
     * 1 ms
     * 内存消耗 :
     * 34.7 MB
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root!=null){
            list.addAll(inorderTraversal1(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal1(root.right));
        }
        return list;
    }

    /**
     * 法二：迭代实现
     * 执行用时 :1 ms, 在所有 java 提交中击败了83.33%的用户
     * 内存消耗 :34.7 MB, 在所有 java 提交中击败了 39.82%的用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            root=temp.right;
        }
        return list;
    }
}
