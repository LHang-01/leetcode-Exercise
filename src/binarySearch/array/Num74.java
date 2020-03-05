package binarySearch.array;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 */
public class Num74 {
    /**
     * 执行用时 :0 ms , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 :40.9 MB, 在所有 java 提交中击败了68.31%的用户
     * 矩阵的二分查找算法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix==null||matrix[0]==null||matrix[0].length==0) return false;
        int start=0;
        int end=(matrix.length)*(matrix[0].length)-1;
        int shang=matrix[0].length;
        int mid;
        while (start<=end){
            mid=(start+end)/2;
            if (matrix[mid/shang][mid%shang]==target){
                return true;
            }else if (matrix[mid/shang][mid%shang]>target){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return false;
    }
}
