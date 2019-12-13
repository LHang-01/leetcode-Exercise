package stringtrain;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Num28 {
    public static void main(String[] arrs){
        String s1 = "mississippi";
        String s2 = "issipi";
        System.out.println(strStr(s1,s2));
    }

    /**
     * 执行用时 :14 ms, 在所有 java 提交中击败了12.73%的用户
     * 内存消耗 :37.8 MB , 在所有 java 提交中击败了36.18%的用户
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack==null||needle==null||haystack.length()<needle.length()) return -1;
        if (needle.length()==0) return 0;
        //构建next数组
        int[] next = new int[needle.length()];
        findNext(next,needle);
        //匹配数组
        int i=0;
        int j=0;
        while (i<haystack.length()&&j<needle.length()){
            //如果haystack第i位字符等于needle第j位字符，则i++、j++;
            if (haystack.substring(i,i+1).equals(needle.substring(j,j+1))){
                i++;
                j++;
            }else {
                //如果haystack第i位字符!=needle第j位字符，则;
                if (j==0){
                    i++;
                }else {
                    j=next[j];
                }
            }
        }
        if (j==needle.length()){
            return i-j;
        }else {
            return -1;
        }
    }

    //构建next数组，即求最大相同前后缀的长度
    private static void findNext(int[] next,String needle) {
        next[0]=-1;
        if (needle.length()==1) return;
        next[1]=0;
        int maxLength = 0;
        int i = 2;
        while (i<needle.length()){
            //如果当前字符等于上一个前缀的下一个字符，则本次的最长相同前后缀长度加一，并把第i位的最长相同前后缀长度记录到next[i+1]中，i往后移动一位
            //注意：当下次查找字符位置i对应的最长相同前后缀长度的时候，查找next[i+1]
            if (needle.substring(i-1,i).equals(needle.substring(maxLength,maxLength+1))){
                maxLength++;
                next[i]=maxLength;
                i++;
            }else if (maxLength>0) {
                //如果当前字符！=上一个前缀的下一个字符，判断maxLength>0：若maxLength>0，则取上一个前缀对应的最长相同前后缀长度next[maxLength]作为下一个比较对象，判断maxLength==-1：若=，则说明没匹配上，因此该位的最长相同前后缀长度next[i]=0；
                maxLength = next[maxLength];
            }else {
                //若maxLength<=0，则上一个前缀没有相同的前后缀,因此，next[i] = maxLength;
                maxLength=0;
                next[i] = maxLength;
                i++;
            }
        }
    }
}
