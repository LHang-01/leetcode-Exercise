package stringtrain;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Num151 {
    public static void main(String [] arrs){

        reverseWords2("a good   example");
    }

    /**
     * ①先去掉首位空格，
     * ②倒叙遍历字符串数组
     * ③如果数组元素包含空格则去掉所有空格，只添加不包含空格的字符串元素；
     * ④除了最后一位每添加一个不包含空格的字符串元素，手动添加一个空格
     *
     * reverseWords和reverseWords1两个方法一个用的String，一个用的StringBuilder，从结果来看StringBuilder运行快得多；
     */

    //执行用时 :2 ms, 在所有 java 提交中击败了99.07%的用户
    //内存消耗 :40.8 MB, 在所有 java 提交中击败了5.04%的用户
    //最简单的代码
    public static String reverseWords2(String s) {
        StringBuilder builder = new StringBuilder();
        String[] s1 = s.trim().split(" ");
        for (int i = s1.length-1;i>0;i--){
            if (!(s1[i].equals(""))){
                builder.append(s1[i]).append(" ");
            }
        }
        return builder.append(s1[0]).toString();
    }

    // 执行用时 :63 ms, 在所有 java 提交中击败了5.10%的用户
    // 内存消耗 :38.9 MB, 在所有 java 提交中击败了89.19%的用户
    public static String reverseWords(String s) {
        String s1 = s.trim();
        String[] s2 = s1.split(" ");
        String ans = "";
        for (int i = s2.length-1;i>=0;i--){
            int j =0;
            while (j<s2[i].length()&&s2[i].charAt(j)==' '){
                j++;
            }
            if (j==s2[i].length()){
                continue;
            }else {
                ans+=s2[i].substring(j);
                if (i!=0){
                    ans+=" ";
                }
            }
        }
        return ans;
    }

    // 执行用时 :2 ms, 在所有 java 提交中击败了99.24%的用户
    // 内存消耗 :37.8 MB, 在所有 java 提交中击败了94.49%的用户
    public static String reverseWords1(String s) {
        String[] s2 = s.trim().split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = s2.length-1;i>=0;i--){
            int j =0;
            while (j<s2[i].length()&&s2[i].charAt(j)==' '){
                j++;
            }
            if (j==s2[i].length()){
                continue;
            }else {
                ans.append(s2[i].substring(j));
                if (i!=0){
                    ans.append(" ");
                }
            }
        }
        return ans.toString();
    }
}
