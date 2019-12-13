package stringtrain;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Num67 {
    public static void main(String [] arrs){
        System.out.println(addBinary("1010","101"));
    }

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00% 的用户
     * 内存消耗 :36.1 MB , 在所有 java 提交中击败了55.19%的用户
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int k = Math.max(i, j);
        char[] chars = new char[k+1];
        int pre =0;
        while (i>=0||j>=0){
            int numa=(i<0)?0:a.charAt(i)- '0';
            int numb=(j<0)?0:b.charAt(j)- '0';
            int sum= numa+numb+pre;
            chars[k]= (char)(sum%2+'0');
            pre=sum/2;
            i--;
            j--;
            k--;
        }
        if (pre==0){
            return String.valueOf(chars);
        }else {
            return "1"+String.valueOf(chars);
        }
    }
}
