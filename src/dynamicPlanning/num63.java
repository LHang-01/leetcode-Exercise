package dynamicPlanning;

import java.util.Arrays;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class num63 {

    public static void main(String[] arrs){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 93.89% 的用户
     * 内存消耗 : 36.5 MB , 在所有 java 提交中击败了 39.70% 的用户
     *
     * 方法思路：
     * 1.对第0行，从路障i的位置开始，全部取0，路障前的值都取1
     * 2.对第0列，从路障i的位置开始，全部取0，路障前的值都取1
     * 3.遍历二维数组，当当前点就是路障即obstacleGrid[i][j]=1时，results[i][j]=0;
     * 否则，当前点的值应该等于results[i][j]=results[i-1][j]+results[i][j-1];
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] results = new int[m][n];
        for (int i=0;i<m;i++){
            Arrays.fill(results[i],0);
        }

        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==0){
                results[0][i]=1;
            }else {
                break;
            }
        }

        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==0){
                results[i][0]=1;
            }else {
                break;
            }
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    results[i][j]=0;
                    continue;
                }else {
                    results[i][j]=results[i-1][j]+results[i][j-1];
                }
            }
        }

        return results[m-1][n-1];
    }
}
