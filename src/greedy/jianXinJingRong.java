package greedy;

import java.util.Scanner;

/**
 * 建信金融（类似于392. 判断子序列）
 * 输入两个字符串（忽略大小写）
 * CAD
 * ccD
 * 判断删除多少个字符时，两个字符串相等。
 *
 * 例如：
 * CAD
 * cxd
 * 答案为2，分别删除a、x后，两个字符串都为CD。
 */
public class jianXinJingRong {
    public static void main(String[] arr){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next().toUpperCase();
        String str2 = scanner.next().toUpperCase();
        int num=0;
        int index=-1;
        for (int i=0;i<str1.length();i++){
            int j=index+1;
            while (j<str2.length()&&!str1.substring(i,i+1).equals(str2.substring(j,j+1))){
                j++;
            }
            if(j<str1.length()){
                num++;
                index=j;
            }
        }
        System.out.println(num);
        System.out.println(str1.length()+str2.length()-2*num);
    }
}
