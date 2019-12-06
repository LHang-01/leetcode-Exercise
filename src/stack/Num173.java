package stack;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 方法：在构造函数时，根据传入的根节点就创建好栈，从小到大依次入栈；
 * 因为root是一棵二叉收搜树，因此，采用前序遍历就能够实现
 *
 * 执行用时 :
 * 27 ms
 * , 在所有 java 提交中击败了80.27%的用户
 * 内存消耗 :
 * 50.5 MB
 * , 在所有 java 提交中击败了 98.40%的用户
 */
public class Num173 {
    public  static void main(String [] arr){
        TreeNode root = new TreeNode(7);
        root.left= new TreeNode(3);
        root.right=new TreeNode(15);
        root.right.left= new TreeNode(9);
        root.right.right= new TreeNode(20);
        Num173 num173= new Num173(root);
        num173.next();
        num173.next();
        num173.hasNext();
        num173.next();
        num173.hasNext();
        num173.next();
        num173.hasNext();
        num173.next();
        num173.hasNext();
    }

    Stack<TreeNode> minStack;
    public Num173(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        minStack=new Stack<>();
        while (root!=null||!minStack.isEmpty()){
            while (root!=null){
                minStack.push(root);
                root=root.left;
            }
            TreeNode temp = minStack.pop();
            stack.add(temp);
            root=temp.right;
        }
        minStack.clear();
        while (!stack.isEmpty()){
            minStack.push(stack.pop());
        }
    }

    /** @return the next smallest number */
    public int next() {
        return minStack.pop().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !minStack.isEmpty();
    }
}
