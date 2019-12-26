package jianZhiOffer.num3_LookupInTwoDimensionalArray;

/**
 * 剑指offer面试题4--二维数组中的查找(leetcode240. 搜索二维矩阵 II)
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 */
public class FindIn2DArray {
    //1.对每一行二分查找
    // 对于一个M*N的二维数组，一次二分查找的时间复杂度为O(lg N), M行就是O(Mlg N)。
    public boolean searchMatrix1(int[][] matrix, int target) {
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
    public static void main(String [] arrs){
        FindIn2DArray findIn2DArray = new FindIn2DArray();
        int[][] ints = new int[5][];
        ints[0]=new int[]{2,3,8,11,15,19,20,20};
        ints[1]=new int[]{4,8,12,15,18,21,25,28};
        ints[2]=new int[]{5,8,17,20,22,23,30,34};
        ints[3]=new int[]{6,12,18,20,25,25,34,34};
        ints[4]=new int[]{9,14,21,24,25,29,39,40};
        findIn2DArray.searchMatrix2(ints,12);
    }
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
    //3.从右往左，从上往下不断缩小范围（剑指offer解法）
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
