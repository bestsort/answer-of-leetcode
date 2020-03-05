//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表

  
package cn.bestsort.leetcode.editor.cn;

import java.util.HashMap;

public class Id_560_SubarraySumEqualsK{
        public static void main(String[] args) {
            Solution solution = new Id_560_SubarraySumEqualsK()
                              .new Solution();
            int[] nums = {1,1,1};
            System.out.println(solution.subarraySum(nums, 2));
        }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int subarraySum(int[] nums, int k) {

                HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
                hashMap.put(0, 1);
                int sum = 0, res = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum += nums[i];
                    res += hashMap.getOrDefault(sum - k, 0);
                    hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}