//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找
  
package cn.bestsort.leetcode.editor.cn;
public class Id_33_SearchInRotatedSortedArray{
        public static void main(String[] args) {
            Solution solution = new Id_33_SearchInRotatedSortedArray()
                              .new Solution();
            int[] nums = {1,3,5};
            System.out.println(solution.search(nums,3));
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return  -1;
        int left = 0;
        int right = nums.length - 1;
        if (target < nums[0]){
            left = findIndex(nums) + 1;
        }else if (nums[0] > nums[nums.length - 1]){
            right = findIndex(nums);
        }

        while (left < right){
            if (nums[mid(left,right)] < target){
                left = mid(left, right) + 1;
            }else if (nums[mid(left,right)] > target){
                right = mid(left, right) - 1;
            }else {
                break;
            }
        }
        return nums[mid(left,right)] == target? mid(left,right) : -1;
    }
    private int findIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right){
            int buf = mid(left, right);
            if (Math.abs(nums[left] - nums[buf]) > Math.abs(nums[right] - nums[buf])){
                right = buf;
            }else {
                left = buf;
            }
        }
        return left;
    }
    public int mid(int a, int b){return (a + b)/2;}
}
//leetcode submit region end(Prohibit modification and deletion)

}