package stringtrain;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Num415 {
    public static void main(String [] arrs){
        System.out.println(addStrings("9","99"));
    }

    /**
     * 执行用时 : 2 ms , 在所有 java 提交中击败了99.76%的用户
     * 内存消耗 : 36 MB, 在所有 java 提交中击败了86.61%的用户
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j= num2.length()-1;
        int k = Math.max(i, j);
        char[] ans = new char[k + 1];
        int temp = 0;
        while (i>=0||j>=0){
            int a = (i<0)?0:num1.charAt(i)-'0';
            int b=(j<0)?0:num2.charAt(j)-'0';
            int sum =a+b+temp;
            ans[k]=(char)(sum%10+'0');
            temp=sum/10;
            i--;
            j--;
            k--;
        }
        if (temp==0){
            return String.valueOf(ans);
        }else {
            return ""+temp+String.valueOf(ans);
        }
    }
}
