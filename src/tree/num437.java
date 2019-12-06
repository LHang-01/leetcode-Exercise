package tree;

public class num437 {
    /**
     * 执行用时 :25 ms, 在所有 java 提交中击败了 8.58%的用户
     * 内存消耗 :38.2 MB, 在所有 java 提交中击败了82.38%的用户
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        //计算当前节点为开始、以当前节点的左节点为开始、以当前节点的右节点为开始的所有满足条件的总和
        return fun(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int fun(TreeNode root, int sum) {
        //如果当前节点为空，说明这条路径一直没找到，此时返回0
        if (root==null) {
            return 0;
        }
        int res = 0;
        //如果当前节点的值=sum，则说明和=sum的路径又增加一条
        if (root.val == sum) {
            res += 1;
        }
        //继续遍历左右节点，蓝海有没有其他更深的路径满足要求
        res+=fun(root.left,sum-root.val);
        res+=fun(root.right,sum-root.val);
        return res;
    }
}
