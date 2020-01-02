package jianZhiOffer.num39_MoreThanHalf;

import java.util.HashMap;

/**
 * 剑指offer面试题39--数组中出现次数超过一半的数字(leetcode169. 多数元素)
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalf {

    //法1：切分法，时间复杂度O(n)（没看懂）
    //如果数组中存在某个数字超过数组长度的一半，那么数组中间的数字必然就是那个出现次数超过一半的数字。
    // 这就将问题转化成了求数组的中位数，快速排序使用的切分算法可以方便地找出中位数，且时间复杂度为O(n)，
    // 找出中位数后还需要再遍历一边数组，检查该中位数是否出现次数超过数组长度的一半。
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;

        int mid = select(array, array.length / 2);
        return checkMoreThanHalf(array, mid);
    }

    /**
     * 选择排名为k的元素,只是部分排序，时间复杂度为O(N)
     */
    private int select(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        // high==low时只有一个元素，不切分
        while (high > low) {
            int j = partition(array, low, high);
            if (j == k) return array[k];
            else if (j > k) high = j - 1;
            else if (j < k) low = j + 1;
        }

        return array[k];
    }

    /**
     * 快速排序的切分方法
     */
    private int partition(int[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = array[low];
        while (true) {
            while (array[++i] < v) if (i == high) break;
            while (array[--j] > v) if (j == low) break;
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //法2：数组中有一个数字出现次数超过了一半，说明这个数字的出现次数比其他所有数字的出现次数之和加起来还要多。
    // 于是可以考虑下面的方法：使用两个变量，result表示当前数字，count表示当前数字的计数值。
    // 在遍历到一个新的数字时候，计数为1，将该数字赋值给result，之后遇到的数字如果和result相同，那么count加1,；
    // 遇到不一样的count减1，直到count等于0，此时需要重新初始化，即将新的数字赋值给result并令count为1......这样遍历完所有数字时，
    // 最后result表示的数值就可能是我们要找的值，注意是可能，因为输入数组可能本身就不满足里面有某个数字出现次数超过一半。
    // 因此和上面的找中位数方法一样，得到的result还需要进一步检验。
    public int moreThanHalfNum_Solution1(int [] array) {
        if (array.length==0) return 0;
        int count=1;
        int result =array[0];
        for (int i = 1;i<array.length;i++){
            if (count == 0) {
                result = array[i];
                count = 1;
            }else if (array[i]==result){
                count++;
            }else {
                count--;
            }
        }
        return checkMoreThanHalf(array, result);
    }

    /**
     * 统计中位数是否超过数组元素个数的一半，若没有默认返回0
     */
    private int checkMoreThanHalf(int[] array, int result) {
        int count = 0;
        for (int a : array) {
            if (a == result) count++;
        }
        return count > array.length / 2 ? result : 0;
    }

    public static void main(String [] arrs){
        new MoreThanHalf().moreThanHalfNum_Solution2(new int[]{1,2,3,2,2,2,5,4,2});
    }
    //法3.哈希表
    public int moreThanHalfNum_Solution2(int [] array) {
        if (array.length==0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num :array){
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                map.replace(num,map.get(num)+1);
            }
            if (map.get(num)>array.length/2) return num;
        }
        return 0;
    }


}
