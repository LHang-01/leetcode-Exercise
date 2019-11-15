package greedy;

import java.util.HashMap;

/**
 * 860. 柠檬水找零
 *
 */
public class num860 {
    public static void main(String[] arrs){
        int[] arr = new int[]{5,5,10};
        System.out.println(lemonadeChange(arr));
    }

    /**
     * 执行用时 : 21 ms , 在所有 java 提交中击败了 10.51% 的用户
     * 内存消耗 : 39.8 MB  , 在所有 java 提交中击败了 92.71% 的用户
     * @param bills
     * @return
     */
    public static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        int i;
        for(i =0;i<bills.length;i++){
            if (bills[i]==5){
                map.replace(5,map.get(5)+1);
            }else if(bills[i]==10){
                if(map.get(5)>0){
                    map.put(10,map.get(10)+1);
                    map.replace(5,map.get(5)-1);
                }else {
                    return false;
                }
            }else{
                if(map.get(10)>0 && map.get(5)>0){
                    map.replace(10,map.get(10)-1);
                    map.replace(5,map.get(5)-1);
                }else if(map.get(5)>=3){
                    map.replace(5,map.get(5)-3);
                }else {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * 执行用时 :  3 ms , 在所有 java 提交中击败了 55.76% 的用户
     * 内存消耗 : 40.3 MB , 在所有 java 提交中击败了  88.47% 的用户
     * @param bills
     * @return
     */
    public static boolean lemonadeChange1(int[] bills) {
        int five = 0;
        int ten = 0;
        int i;
        for(i =0;i<bills.length;i++){
            if (bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five>0){
                    ten++;
                    five--;
                }else {
                    return false;
                }
            }else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;

    }
}
