package cn.bestsort.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @author bestsort
 * @version 1.0
 * @date 2/17/20 11:01 AM
 */
public class QuickSort {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap();
        HashSet<String> strings = new HashSet<>();
        ConcurrentHashMap<String, String> hashMap1 = new ConcurrentHashMap<>();
        System.out.println(        hashMap.put("123","1231234"));
    }
    public static void sort(int[] arr,int left, int right){
        // 边界相交时不需要进行排序了
        if (left >= right){
            return;
        }
        int indexLeft = left;
        int indexRight = right;
        int partition = arr[left];
        while (indexLeft < indexRight){
            while (indexLeft < indexRight && arr[indexLeft] < partition){
                indexLeft++;
            }
            
        }
    }
}
