package jianZhiOffer.num17_PrintFrom1ToMaxOfNDigit;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * 剑指offer面试题17--打印从1到最大的n位十进制数
 * 输入数字n，按顺序打印处1到最大的n位十进制数，比如输入3，则打印1~999之间的数
 */
public class PrintFrom1ToMaxOfNDigit {
    //这是一道大数问题，牵涉到大数问题我们可以将其转化为字符串表示。因为字符串任意长度都行。
    //1.非递归
    public void printFrom1ToMaxOfNDigit(int n) {
        if (n <= 0) return;
        StringBuilder sb = new StringBuilder();
        //初始化
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        //遍历所有可能,即每次循环后增加1，然后打印这个数，直到进位溢出字符串时，就遍历完成，跳出循环。
        while (function(n,sb)){
            printfun(sb);
        }
    }

    private boolean function(int n, StringBuilder sb) {
        // 进位,应该要给下一位相加，所以设置在循环外
        int toTen = 0;
        // 从个位开始加，如果有进位就看十位...如果到最高位还有进位，说明溢出；
        for (int i = n - 1; i >= 0; i--){
            //取到第i位的字符转换为数字 +进位符
            int sum = sb.charAt(i) - '0' + toTen;
            //末尾自加1
            if (i == n - 1) {
                sum++;
            }
            if (sum == 10){
                if (i == 0) {
                    // 进位溢出，遍历完成
                    return false;
                } else {
                    // 需要进位，当前位设为0
                    sb.setCharAt(i, '0');
                    // 进位了
                    toTen = 1;
                }
            }else {
                // 在某位上自增后不再进位，自增完成立即退出循环
                sb.setCharAt(i, (char) (sum + '0'));
                break;
            }
        }
        return true;
    }

    private void printfun(StringBuilder sb) {
        int start = sb.length();
        // 找到第一个不为0的索引
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        // 如果全是0，就不会打印
        if (start < sb.length()) {
            System.out.print(sb.substring(start) + " ");
        }
    }

    //2.递归
    public void printFrom1ToMaxOfNDigitRecur1(int n) {
        if (n <= 0) return;
        StringBuilder sb = new StringBuilder();
        //初始化
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        // 递归中的方法为了对下一位排列，所以是index + 1，为了对最高位排列应该传入-1
        printRecur(sb, n, -1);
        System.out.println();
    }
    //从最高位开始全排列，直到递归到最后一位结束
    //即,第一层      0000、1000、2000、3000、4000、5000、6000、7000、8000、9000、
    //第二层         0000、0100...0900，       ......       ,9000、9100...9900，
    //其实就是一棵树，1)自上向下：第一次遍历最高位，第二层在第一层的基础上，遍历第二高位...，直到遍历到最低位数（个位），
    //               2）然后全部打印出来（也就是自下向上的过程）。
    private void printRecur(StringBuilder sb, int len, int index) {
        if (index == len - 1) {
            print(sb);
            return;
        }
        for (int i = 0; i < 10; i++) {
            // 一定是先设置了字符，然后再递归
            sb.setCharAt(index + 1, (char) (i + '0'));
            printRecur(sb, len, index + 1);
        }
    }
}
