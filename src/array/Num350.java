package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Num350 {
    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 java 提交中击败了
     * 77.05%
     * 的用户
     * 内存消耗 :
     * 37 MB
     * , 在所有 java 提交中击败了
     * 38.73%
     * 的用户
     * 这里用map的key元素，value存相同元素的个数
     * 先遍历一个数组，将所有数保存到map中，
     * 然后遍历另一个数组，当另一个数组的值与map的key相同时，并且判断key对应的value是否>1：当value>1,从map中的value减一，并且添加到list中；
     *                                                                                 当value<1,从map中移除该元素。
     * 最后list保存的就是交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<nums1.length;i++){
            if (map.containsKey(nums1[i])){
                map.replace(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }
        for (int i=0;i<nums2.length;i++){
            if (map.containsKey(nums2[i])){
                if (map.get(nums2[i])>1){
                    map.replace(nums2[i],map.get(nums2[i])-1);
                }else {
                    map.remove(nums2[i]);
                }
                list.add(nums2[i]);
            }
        }
        int[] ints = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        int i=0;
        while (it.hasNext()){
            ints[i]=it.next();
            i++;
        }
        return ints;
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 java 提交中击败了
     * 99.78%
     * 的用户
     * 内存消耗 :
     * 36.6 MB
     * , 在所有 java 提交中击败了
     * 50.07%
     * 的用户
     *
     * 双指针
     * 首先对两个数组进行排序，然后双指针，p1指向nums1，p2指向nums2：
     * 如果nums1[p1] == nums2[p2]，说明俩数组中都有这个数，是其交集，所以将它丢入list中。
     * 如果不等，则移动小的那个指针。
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int i =0;
        int j = 0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]>nums2[j]){
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ints = new int[list.size()];
        Iterator<Integer> it = list.iterator();
        i=0;
        while (it.hasNext()){
            ints[i]=it.next();
            i++;
        }
        return ints;
    }

}
