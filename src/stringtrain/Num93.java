package stringtrain;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Num93 {
    public static void main(String [] arrs){
        restoreIpAddresses("25525511135");
    }
    //思路一:暴力法:我们把所有出现可能都列举出来,看是否满足条件.
    //执行用时 :3 ms, 在所有 java 提交中击败了74.98%的用户
    //内存消耗 :36.2 MB, 在所有 java 提交中击败了50.01%的用户
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0;i<3;i++){
            for (int j =i+1;j<i+4;j++){
                for (int k=j+1;k<j+4;k++){
                    if (i<s.length()&&j<s.length()&&k<s.length()){
                        String num1=s.substring(0,i+1);
                        String num2=s.substring(i+1,j+1);
                        String num3=s.substring(j+1,k+1);
                        String num4=s.substring(k+1,s.length());
                        if (valid(num1)&&valid(num2)&&valid(num3)&&valid(num4)){
                            list.add(num1+"."+num2+"."+num3+"."+num4);
                        }
                    }
                }
            }
        }
        return list;
    }
    private static boolean valid(String tmp) {
        if (tmp == null || tmp.length() == 0 || tmp.length() > 3 || (tmp.charAt(0) == '0' && tmp.length() > 1) || Integer.parseInt(tmp) > 255)
            return false;
        return true;
    }
}
