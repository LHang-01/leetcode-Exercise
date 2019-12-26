package array;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 */
public class Num240 {
    //1.对每一行二分查找
    // 对于一个M*N的二维数组，一次二分查找的时间复杂度为O(lg N), M行就是O(Mlg N)。
    //执行用时 :7 ms, 在所有 java 提交中击败了96.34%的用户
    //内存消耗 :45.4 MB, 在所有 java 提交中击败了85.63%的用户
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix==null||matrix[0]==null||matrix[0].length==0) return false;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        for (int i = 0;i<=m;i++){
            if (target==matrix[i][0]||target==matrix[i][n]){
                return true;
            }else if (target>matrix[i][0]&&target<matrix[i][n]){
                int start = 0;
                int end = n;
                int mid ;
                while (start<=end){
                    mid=(start+end)/2;
                    if (matrix[i][mid]==target){
                        return true;
                    }else if (matrix[i][mid]>target){
                        end = mid-1;
                    }else {
                        start=mid+1;
                    }
                }
            }
        }
        return false;
    }

    //2.优化1
    // [1,   4,  7, 11, 15],
    // [2,   5,  8, 12, 19],
    // [3,   6,  9, 16, 22],
    // [10, 13, 14, 17, 24],
    // [18, 21, 23, 26, 30]
    //如果target=8，那么在二分第一行结束时mid=3(11的位置),那么在下一行遍历的时候，就可以缩小遍历范围只用遍历0-2就行了
    //执行用时 :7 ms, 在所有 java 提交中击败了96.34%的用户
    //内存消耗 :42.1 MB, 在所有 java 提交中击败了99.09%的用户
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length==0||matrix==null||matrix[0]==null||matrix[0].length==0) return false;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int end = n;
        int mid ;
        for (int i = 0;i<=m;i++){
            int start = 0;
            if (target==matrix[i][0]||target==matrix[i][end]){
                return true;
            }else if (target>matrix[i][0]&&target<matrix[i][end]){
                while (start<=end){
                    mid=(start+end)/2;
                    if (matrix[i][mid]==target){
                        return true;
                    }else if (matrix[i][mid]>target){
                        end = mid-1;
                    }else {
                        start=mid+1;
                    }
                }
            }
        }
        return false;
    }

    //从右往左，从上往下不断缩小范围（剑指offer解法）
    //执行用时 :7 ms, 在所有 java 提交中击败了96.34%的用户
    //内存消耗 :44.1 MB, 在所有 java 提交中击败了94.86%的用户
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix.length==0||matrix==null||matrix[0]==null||matrix[0].length==0) return false;
        int m = matrix.length;
        int row = 0;
        int colunmn = matrix[0].length-1;
        while (row<m&&colunmn>-1){
            if (matrix[row][colunmn]==target){
                return true;
            }else if (matrix[row][colunmn]>target){
                colunmn--;
            }else {
                row++;
            }
        }
        return false;
    }

}
