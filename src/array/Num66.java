package array;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1: 输入: [1,2,3] 输出: [1,2,4] 。解释: 输入数组表示数字 123。
 */
public class Num66 {
    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :35.2 MB, 在所有 java 提交中击败了37.39%的用户
     */
    public int[] plusOne(int[] digits) {
        int num = 1;
        for (int i= digits.length-1;i>=0;i--){
            if (digits[i]+num==10){
                digits[i]=0;
                num=1;
            }else {
                digits[i]=digits[i]+1;
                return digits;
            }
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for (int i = 1;i<ans.length;i++){
            ans[i]=digits[i-1];
        }
        return ans;
    }

    /**
     * 此方法很巧妙： 当最高位9也进位时，比如999+1=1000，99+1=100，此时需要增加一位存一，此为之后的其他位都是0.
     * 执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     * 内存消耗 : 35.1 MB , 在所有 java 提交中击败了 37.74% 的用户
     */
    public int[] plusOne1(int[] digits) {
        int num = 1;
        for (int i= digits.length-1;i>=0;i--){
            if (digits[i]+num==10){
                digits[i]=0;
                num=1;
            }else {
                digits[i]=digits[i]+1;
                return digits;
            }
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
