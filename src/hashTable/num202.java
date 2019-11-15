package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 解题思路：
 * 使用字典 Map 来记录循环过程中各个位置上的数字的平方和
 * 若平方和的值为 1, 则跳出循环, 这个数是快乐数;
 * 若平方和的值不为 1, 则判断字典 Map 中是否已有该值;
 * 若字典 Map 中已有该值, 则这个数不是快乐数;
 */
public class num202 {
    public static void main(String[] arrs){
        int n =19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        //若平方和的值不为 1, 则判断字典 Map 中是否已有该值;若字典 Map 中已有该值, 则这个数不是快乐数;
        while (true){
            int sum = 0;
            //各个位置上的数字的平方和
            while (n!=0){
                sum= (int) (sum+Math.pow( n%10,2));
                n=n/10;
            }
            n=sum;
            //若平方和的值为 1, 则跳出循环, 这个数是快乐数
            if (sum==1){
                return true;
            }
            //若平方和的值不为 1, 则判断字典 Map 中是否已有该值
            if (set.contains(sum)){
                break;
            }
            set.add(sum);
        }
        return false;
    }
}
