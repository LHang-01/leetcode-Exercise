package jianZhiOffer.num37_SerializeBT;

/**
 * 剑指offer面试题37--序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过某种符号表示空节点（#），以！表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 遇到空指针可以也用一个特殊的字符表示，比如“#”，这样前序遍历序列就可以表示唯一的一棵二叉树了。对于空指针也用一个字符表示，可称这样的序列为扩展序列。
 * 而二叉树的建立，必须先要建立根结点再建立左右子树（root为空怎么调用root.left是吧），所以必须前序建立二叉树，那么序列化时也应该用前序遍历，保证了根结点在序列前面。
 */
public class SerializeBT {
    // 结点值用String[] seq保存，index是seq的索引
    private int index = -1;
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();

    }
    // 前序遍历
    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("# ");
            return;
        }
        sb.append(node.val).append(" ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] seq = str.split("\\s");
        return reconstructBST(seq);
    }

    private TreeNode reconstructBST(String[] seq) {
        index++;
        if (seq[index].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(seq[index]));
        root.left=reconstructBST(seq);
        //先恢复左子树，为了让index所以在运行完这一句后，改变后的index值指向的是左子节点的值，为了让这个值能让右子树看见，因此采用的全局变量，相当于引用传递
        root.right = reconstructBST(seq);
        return root;
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
