package stringtrain;

/**
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class Num434 {
    /**
     * 执行用时 :
     * 0 ms, 在所有 java 提交中击败了 100.00%的用户
     * 内存消耗 :
     * 34.1 MB, 在所有 java 提交中击败了 63.33%的用户
     * @param s
     * @return
     */
    public int countSegments(String s) {
        //1.确定左边非空格的首字母位置
        int start = 0;
        int end = s.length()-1;
        while (start<=end&&s.charAt(start)==' '){
            start++;
        }
        //2.确定右边非空格的尾字母位置
        while (start<=end&&s.charAt(end)==' '){
            end--;
        }

        if (start>end){
            return 0;
        }
        //3.数中间的空格个数
        int count = 0;
        for (start=start+1;start<end;start++){
            if (s.charAt(start)==' '){
                count++;
                while (start<end&&s.charAt(start+1)==' '){
                    start++;
                }
            }
        }
        //4.返回结果
        return count+1;
    }
}
