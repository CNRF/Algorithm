package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * @author mingxing.wang
 * @date 2022/3/14 16:43
 */
public class Code599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        //此处可以根据提议设置一个较大初始值 避免设置为0判断无法进入
        int min=3000;
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (min>i+map.get(list2[i])) {
                    strings.clear();
                    strings.add(list2[i]);
                    min=i+map.get(list2[i]);
                }else if (min==i+map.get(list2[i])){
                    strings.add(list2[i]);
                }
            }
        }
        return strings.toArray(new String[strings.size()]);
    }

    public static void main(String[] args) {
        String[] list1={"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2={"KFC","Shogun","Burger King"};
        String[] restaurant = findRestaurant(list1, list2);
        for (int i = 0; i < restaurant.length; i++) {
            System.out.println(restaurant[i]);
        }

    }
}
