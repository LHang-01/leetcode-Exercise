package jianZhiOffer.num16_Power;

/**
 * 剑指offer面试题16--数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Power {
    //1.算法采用了连乘，时间复杂度是O(n)
    public double Power1(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        int positiveExponent = Math.abs(exponent);
        double ans =1;
        while (positiveExponent!=0){
            ans*=base;
            positiveExponent--;
        }
        return exponent>0?ans:1/ans;
    }

    //2 .非递归（推荐）—— 不是很理解
    // 我们要求a^n，分n为奇数和偶数两种情况，如下
    //a^n = a ^{n /2} * a ^{n /2} ，n为偶数
    //a^n = a ^{(n-1) /2} * a ^{(n-1) /2} * a，n为奇数
    //假如要求$2^{32}$，按照上面连乘的思路，需要进行31次乘法；采用上面的公式，只需要5次：先求平方，然后求四次方、八次方、十六次方，最后三十二次方。将时间复杂度降到了O(lg n)。
    public double Power2(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);
        while (positiveExponent != 0) {
            //注意偶数的二进制为位中只有最高位是1，其余低位都是0；奇数二进制为中除最高位和最低位都为1，其他位也可能为1。
            //因此判断奇偶时,如果一个数&1后的值为1，则说明这个数是奇数
            if ((positiveExponent&1)==1){
                result *= base;
            }
            base *= base;
            // 右移1位等于除以2
            positiveExponent = positiveExponent >> 1;
        }
        return exponent < 0 ? 1 / result : result;
    }

    //3.递归
    public double Power3(double base, int exponent) {
        if (base == 0) return 0;
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);
        result = dfs(base,positiveExponent,result);
        return exponent < 0 ? 1 / result : result;
    }

    private double dfs(double base, int positiveExponent, double result) {
        if (positiveExponent == 0) return 1;
        if (positiveExponent==1) return base;
        result = dfs(base, positiveExponent >> 1,result);
        result *= result;
        if ((positiveExponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}
