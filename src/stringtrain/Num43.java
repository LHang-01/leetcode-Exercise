package stringtrain;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Num43 {
    //执行用时 :5 ms, 在所有 java 提交中击败了86.51%的用户
    //内存消耗 :36.9 MB, 在所有 java 提交中击败了88.70%的用户
    //该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。具体规律如下：
    //乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
    //num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] ans = new int[chars1.length + chars2.length];
        for (int i = chars1.length-1;i>=0;i--){
            for (int j = chars2.length-1;j>=0;j--){
                int sum =(chars1[i]-'0')*(chars2[j]-'0')+ans[i+j+1];
                ans[i+j+1]=sum%10;
                ans[i+j]=ans[i+j]+sum/10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<ans.length;i++){
            if (i==0&&ans[i]==0){
                continue;
            }
            builder.append(ans[i]);
        }
        return builder.toString();
    }
}
