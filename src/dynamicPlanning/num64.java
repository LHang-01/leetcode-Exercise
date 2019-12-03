package dynamicPlanning;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class num64 {
    public static void main(String[] arrs){
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    /**
     * 方法：采用62题的uniquePaths方法
     * 1.对第0行，当前节点i的路径和最小=前面的i-1个节点和+当前节点的值；
     * 对第0列，也是相同的道理。
     * 2.遍历二维数组，当前点[i][j]的路径和最小=min([i-1][j],[i][j-1]）+ 当前节点的值。
     *
     * 执行用时 :3 ms, 在所有 java 提交中击败了88.86%的用户
     * 内存消耗 : 40.6 MB , 在所有 java 提交中击败了77.13%的用户
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] nums = new int[m][n];
        nums[0][0]=grid[0][0];
        for (int i = 1; i < n; i++){
            nums[0][i] = grid[0][i]+nums[0][i-1];
        }
        for (int i = 1; i < m; i++){
            nums[i][0] = grid[i][0]+nums[i-1][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                nums[i][j] = Math.min(nums[i-1][j],nums[i][j-1]) + grid[i][j];
            }
        }
        return nums[m-1][n-1];
    }
}
