package stringtrain;

/**
 * 443. 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 */
public class Num443 {
    public static void main(String [] arrs){
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.9 MB , 在所有 java 提交中击败了77.55%的用户
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int ans = 0;
        for (int i = 0;i<chars.length;i++){
            chars[ans]=chars[i];
            ans++;
            int j = i;
            while (j+1<chars.length&&chars[j+1]==chars[j]){
                j++;
            }
            int count = j-i+1;
            if (count>1){
                String s = String.valueOf(count);
                for (int k = 0;k<s.length();k++){
                    chars[ans]=s.charAt(k);
                    ans++;
                }
            }
            i=j;
        }
        return ans;
    }
}
