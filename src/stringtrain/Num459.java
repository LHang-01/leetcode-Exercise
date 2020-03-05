package stringtrain;

/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1: 输入: "abab" 输出: True 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 示例 2: 输入: "aba" 输出: False
 *
 * 示例 3: 输入: "abcabcabcabc" 输出: True 解释: 可由子字符串 "abc" 重复四次构
 */
public class Num459 {
    public static void main(String [] arrs){
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }

    /**
     * 执行用时 :10 ms, 在所有 java 提交中击败了93.72%的用户
     * 内存消耗 :37.7 MB , 在所有 java 提交中击败了96.30%的用户
     *
     * 方法：在0到half的范围内依次寻找与首位置相同的位置j，然后判断s是否由0-j的字符串重复构成
     */
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length()==1) return false;
        int half=s.length()/2;
        int j=0;
        for (int i= 0;i<=half;i=j){
            j = i+1;
            while (j<=half&&s.charAt(j)!=s.charAt(0)){
                j++;
            }
            if (j>half) return false;
            int length = j;
            if (s.length()%length==0){
                int temp = s.length()/length;
                int k = 1;
                for (;k<temp;k++){
                    if (!s.substring((k-1)*length,k*length).equals(s.substring(k*length,(k+1)*length))){
                        break;
                    }
                }
                if (k==temp){
                    return true;
                }
            }
        }
        return false;
    }
}
