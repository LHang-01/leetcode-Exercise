package dynamicPlanning;

/**
 * 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class num357 {

    public static void main(String[] arrs){
        System.out.println(countNumbersWithUniqueDigits(8));
    }

    /**
     * n=1: res=10
     * n=2: res=9*9+10=91 # 两位数第一位只能为1-9，第二位只能为非第一位的数，加上一位数的所有结果
     * n=3: res=9 * 9 * 8+91=739 # 三位数第一位只能为1-9，第二位只能为非第一位的数，第三位只能为非前两位的数，加上两位数的所有结果
     * n=4: res=9 * 9 * 8 * 7+739=5275 # 同上推法
     * n>10以后答案都不变了，因为11位数不可能各个位数都不同，因此 i 遍历1到min(n, 10)即可
     * @param n
     * @return
     */
    public static int countNumbersWithUniqueDigits(int n) {
        if (n==0) return 1;
        if (n==1) return 10;
        if (n>10) n=11;
        int[] nums = new int[n+1];
        nums[0]=1;
        nums[1]=10;
        for (int i=2;i<n+1;i++){
            int chengJi=9;
            int j=i-1;
            while (j>0){
                chengJi=chengJi*(10-j);
                j--;
            }
            nums[i]=nums[i-1]+chengJi;
        }
        return nums[n];

    }

    /**
     * 从countNumbersWithUniqueDigits发现计算nums[i]只需要保存前一个数nums[i-1]就行，因此用临时变量保存nums[i-1]就行，这样就节省了空间。
     * (但实际上没有提高多少，内存从13提高到12%，执行时间几乎不变)
     * 执行用时 : 0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :32.8 MB , 在所有 java 提交中击败了 15.24%的用户
     * @param n
     * @return
     */
    public static int countNumbersWithUniqueDigits1(int n) {
        if (n==0) return 1;
        if (n==1) return 10;
        if (n>10) n=11;
        int pre=10;
        for (int i=2;i<n+1;i++){
            int chengJi=9;
            int j=i-1;
            while (j>0){
                chengJi=chengJi*(10-j);
                j--;
            }
            pre=pre+chengJi;
        }
        return pre;

    }
}
