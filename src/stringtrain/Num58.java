package stringtrain;

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class Num58 {
    public static void main(String [] arrs){
        System.out.println(lengthOfLastWord("a"));
    }

    /**
     * 执行用时 :0 ms , 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36.1 MB, 在所有 java 提交中击败了62.35%的用户
     *
     * 双指针
     * 方法：先把字符串末尾的" "删除；
     *      然后从后往前记录非零个数的位数。
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int i = s.length()-1;
        //先把字符串末尾的" "删除；
        while (i>=0&&s.substring(i,i+1).equals(" ")){
            i--;
        }
        if (i<0){
            return 0;
        }else {
            s=s.substring(0,i+1);
            i = s.length()-1;
        }
        //然后从后往前记录非零个数的位数。
        while (i>=0&&!s.substring(i,i+1).equals(" ")){
            i--;
        }
        if (i<0){
            return s.length();
        }else {
            return s.length()-i-1;
        }
    }

}
