//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针

  
package cn.bestsort.leetcode.editor.cn;

public class Id_75_SortColors{
        public static void main(String[] args) {
            Solution solution = new Id_75_SortColors()
                              .new Solution();
            int[] nums = {2,0,2,1,1,0};
            solution.sortColors(nums);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
            }
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int leftIndex, rightIndex;
        leftIndex = 0;
        rightIndex = nums.length - 1;
        int midIndex = 0;
        while (midIndex <= rightIndex){
            if (nums[midIndex] == 0){
                swap(midIndex, leftIndex, nums);
                leftIndex++;
                midIndex++;
            }else if(nums[midIndex] == 2){
                swap(midIndex, rightIndex, nums);
                rightIndex--;
            }
            else {
                midIndex++;
            }
        }
    }
    void swap(int i, int j, int[] nums){
        int buffer = nums[i];
        nums[i] = nums[j];
        nums[j] = buffer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}