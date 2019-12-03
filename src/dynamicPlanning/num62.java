package dynamicPlanning;

public class num62 {

    public static void main(String[] arrs){
        int m=3;
        int n=2;
        System.out.println(uniquePaths(m,n));
        System.out.println(uniquePaths1(m,n));
    }

    /**
     * 我们令 dp[i][j] 是到达 i, j 最多路径
     * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
     *
     * 运行结果：
     * 执行用时 :1 ms, 在所有 java 提交中击败了67.26%的用户
     * 内存消耗 :32.9 MB, 在所有 java 提交中击败了16.03%的用户
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < n; i++){
            nums[0][i] = 1;
        }
        for (int i = 0; i < m; i++){
            nums[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m-1][n-1];
    }

    /**
     * 优化2：空间复杂度 O(n)
     * uniquePaths是把所有的求解值都记录了下来，但实际上，计算第i排的时候只需要第i-1排的值，
     * 前面i-2、i-3...1,0的值都用不到了，因此不需要保存，这样可以将空间从n^2节省至n。
     *
     * 执行用时 : 0 ms , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :32.9 MB, 在所有 java 提交中击败了 14.69%的用户
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths1(int m, int n) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i]=1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                nums[j]=nums[j-1]+nums[j];
            }
        }
        return nums[n-1];

    }
}
