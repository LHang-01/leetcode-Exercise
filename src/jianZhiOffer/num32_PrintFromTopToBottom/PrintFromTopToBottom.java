package jianZhiOffer.num32_PrintFromTopToBottom;

import java.util.*;

/**
 * 剑指offer面试题32--从上到下打印二叉树(leetcode102. 二叉树的层次遍历)
 * 不分行，从上往下打印出二叉树的每个节点，同层节点从左至右打印。即层序遍历
 */
public class PrintFromTopToBottom {
    //1.不分行，层序遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left!=null) queue.offer(temp.left);
            if (temp.right!=null) queue.offer(temp.right);
        }
        return list;
    }

    //2.分行打印
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                root = queue.poll();
                list.add(root.val);
                if (root.left!=null) queue.offer(root.left);
                if (root.right!=null) queue.offer(root.right);
                size--;
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] arrs){
        //{8,6,10,5,7,9,11}
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right =new TreeNode(10);
        node.left.left=new TreeNode(5);
        node.left.right=new TreeNode(7);
        node.right.left=new TreeNode(9);
        node.right.right=new TreeNode(11);
        System.out.println(new PrintFromTopToBottom().printTreeZ(node));
    }
    //3.Z字形打印二叉树(在分行打印上改进)
    //根结点先被打印，然后从右往左打印第二行，接着从左往右打印第三行...以此类推
    //为了达到上述的交替效果，需要用到两个栈，一个栈stackOdd存奇数层的结点，另一个栈stackEven存偶数层的结点。
    //奇数层，其下层的结点按左到右的顺序入栈
    //偶数层，其下层的结点按右到左的顺序入栈
    //奇偶层顺序是固定的，即根结点是奇数层，则奇偶顺序是“奇偶奇偶....“
    public List<List<Integer>> printTreeZ(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null) return lists;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        // 只要还有一个栈不为空就继续
        while (!stack1.isEmpty()||!stack2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
            }
            lists.add(list);
        }
        return lists;
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
