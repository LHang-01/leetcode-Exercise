package jianZhiOffer.num38_Permutation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指offer面试题38--字符串的排列(太难了，没懂)
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        //避免出现相同的字符串
        Arrays.sort(chars);
        collect(chars, 0,"",list);
        return list;
    }

    private void collect(char[] chars, int begin, String s, ArrayList<String> list) {
        s=s+chars[begin];
        if (begin == chars.length - 1) {
            list.add(s);
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            swap(chars,i,begin);
            collect(chars, begin + 1, s, list);
            swap(chars,i,begin);
        }
    }

    //第一个字符和其后的所有字符依次交换位置可以用一个for循环完成，
    //对于循环中的每一次交换：在交换位置后要对除第一个字符外的字符序列进行递归。
    // 这里一定要注意，第一个字符首先要和自己交换一下。一次递归调用结束后，需要将之前的交换复原，以保证下次交换依然是和第一个字符交换。
    // 比如abcd，第一个字符和第二个字符交换后变成bacd，此后固定b对acd递归，递归结束后，需要将bacd复原成abcd，以便下次a和c交换位置变成cbad......
    private void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }
}
