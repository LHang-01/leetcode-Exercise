package stringtrain;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Num125 {
    public static void main(String [] arrs){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    /**
     * 执行用时 :5 ms, 在所有 java 提交中击败了81.87%的用户
     * 内存消耗 :37.5 MB , 在所有 java 提交中击败了92.49%的用户
     *
     * 双指针
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;
        char[] chars = new char[s.length()];
        // 过滤非字符、数字的字符
        while (i<n){
            if (('0'<=s.charAt(i)&&s.charAt(i)<='9')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                chars[count]=s.charAt(i);
                count++;
            }
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                chars[count]=(char)(s.charAt(i)-'A'+'a');
                count++;
            }
            i++;
        }
        i = 0;
        n=count-1;
        while (i<n){
            if (chars[i]==chars[n]){
                i++;
                n--;
            }else {
                return false;
            }
        }
        return true;
    }
}
