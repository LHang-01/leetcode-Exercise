package jianZhiOffer.num44_ADigitInNumberSeq;

/**
 * 剑指offer面试题44--数字序列中的某一位数字
 * 数字以0123456789101112131415....的格式序列化得到一个字符序列中，在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字
 */
public class ADigitInNumberSeq {

    public static void main(String [] arrs){
        System.out.println(new ADigitInNumberSeq().numAtSeq(10));
    }
    /**
     * 方法1：逐个列举
     */
    public int numAtSeq(int index) {
        if (index < 0) return -1;

        int i = 0;
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        while (true) {
            sum += countDigits(i);
            // 一定不要包含=
            if (sum > index) break;
            i++;
        }
        // sum - n是超出的部分，减去1是因为下标从0开始
        return String.valueOf(i).charAt(index-1);
    }

    /**
     * 计算某数有多少位
     */
    private int countDigits(int num) {
        if (num == 0) return 1;

        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    /*****************************************
     * 方法2
     */

}
