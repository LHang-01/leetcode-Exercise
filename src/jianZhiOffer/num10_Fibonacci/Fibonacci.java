package jianZhiOffer.num10_Fibonacci;

/**
 * 剑指offer面试题10--斐波那契数列
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Fibonacci {
    //1.迭代，用三个变量，其中用两个变量存储n-1和n-2
    public int fib11(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int temp1 = 0;
        int temp2 = 1;
        int sum = 0;
        for (int i = 2 ; i<=n;i++){
            sum = temp1+temp2;
            temp1 = temp2;
            temp2 = sum;
        }
        return sum;
    }
    //1.迭代，用两个变量，其中一个存储n-2，另一个存储即n-2，又是存的返回值。
    // 推荐，时间复杂度O（n）
    public int fib12(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int temp1 = 0;
        int sum = 1;
        for (int i = 2 ; i<=n;i++){
            sum = temp1+sum;
            temp1 = sum-temp1;
        }
        return sum;
    }

    //2.递归，时空开销较大，不推荐。
    public int fib2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib2(n-1) +fib2(n-2);
    }
}
