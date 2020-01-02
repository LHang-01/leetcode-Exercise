package jianZhiOffer.num33_VerifySquenceOfBST;

/**
 * 剑指offer面试题33--二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 注意是二叉搜索（查找）树，特点是父结点的左子树都比父结点小，父结点的右子树都比父结点大。因此其后序遍历的序列有一定的规律：
 * 序列最后一位必然是树的根结点；
 * 序列前部分是根结点的左子树，后部分是根结点的右子树；具体来说：将序列各个元素和和序列最后一位的根结点比较，序列前部分都小于根结点的值，这部分子序列是左子树；序列后部分的值都大于根结点，这部分子序列是右子树；
 * 根据二叉树的递归结构，可以将树分成左子树、根结点、右子树，对于每棵子树可以继续按照上面的方式分下去。于是原序列可被划分为若干个子序列，每个子序列表示一棵子树。
 *
 * 因此解决本题：首先要从序列中获得根结点，然后找到序列中左右子树的分界线，由此将序列分成三部分：左子树、根结点、右子树。再对左右子树进行递归操作。
 */
public class VerifySquenceOfBST {
    public static void main(String[] arrs){
        System.out.println(new VerifySquenceOfBST().verifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
    }
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0) return false;
        return dfs(0,sequence.length-1,sequence);
    }

    private boolean dfs(int start, int end, int[] sequence) {
        int root = sequence[end];
        int nextRootIndex = start;
        //1从序列中获得根结点，找到序列中左右子树的分界线
        for (;nextRootIndex<end;nextRootIndex++){
            if (sequence[nextRootIndex]>root){
                break;
            }
        }
        //2.检查右子树是否全大于根节点
        for (int i = nextRootIndex;i<end;i++){
            if (sequence[i]<root){
                return false;
            }
        }
        //3.将序列分成三部分：左子树、根结点、右子树。再对左右子树进行递归操作。
        if (start<nextRootIndex&&nextRootIndex<end-1) return dfs(start,nextRootIndex-1,sequence)&&dfs(nextRootIndex,end-1,sequence);
        if (start<nextRootIndex) return dfs(start,nextRootIndex-1,sequence);
        if (nextRootIndex<end-1) return dfs(nextRootIndex,end-1,sequence);
        return true;
    }
    //2.leetcode98. 验证二叉搜索树

}
