package dynamicPlanning;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例:
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class num304 {

    private int[][] sum;

    /**
     * 执行用时 :20 ms , 在所有 java 提交中击败了82.14% 的用户
     * 内存消耗 : 43.1 MB , 在所有 java 提交中击败了99.04%的用户
     *
     * sum[i][j]存储的是i行j列的数据，这里主要用了集合中的交集。
     * @param matrix
     */
    public num304(int[][] matrix) {
        if (matrix.length==0||matrix==null){
            sum=null;
        }else {
            sum=new int[matrix.length][matrix[0].length];
            sum[0][0]=matrix[0][0];
            //计算第一行
            for (int i=1;i<matrix[0].length;i++){
                sum[0][i]=sum[0][i-1]+matrix[0][i];
            }
            //计算第一列
            for (int i=1;i<matrix.length;i++){
                sum[i][0]=sum[i-1][0]+matrix[i][0];
            }
            //计算其他行
            for (int i=1;i<matrix.length;i++){
                for (int j=1;j<matrix[0].length;j++){
                    sum[i][j]=matrix[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum==null){
            return 0;
        }
        if (row1==0&&col1==0){
            return sum[row2][col2];
        }
        if (row1==0){
            return sum[row2][col2]-sum[row2][col1-1];
        }
        if (col1==0){
            return sum[row2][col2]-sum[row1-1][col2];
        }
        return sum[row2][col2]-(sum[row2][col1-1]+sum[row1-1][col2]-sum[row1-1][col1-1]);
    }
}
