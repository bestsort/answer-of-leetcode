  //实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组
package cn.bestsort.leetcode.editor.cn;

  import java.util.Arrays;

  public class Id_31_NextPermutation{
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};

        Solution solution = new Id_31_NextPermutation().new Solution();
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1){
            return;
        }
        int l = 0, r = nums.length;
        int index;
        boolean swapped = false;
        for (int i = nums.length - 2;!swapped && i >= 0 ; i--) {
            if (nums[i] < nums[i + 1]){
                index = i + 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i] && nums[j] <= nums[index]){
                        index = j;
                    }
                }
                if (index != -1){
                    int buf = nums[index];
                    nums[index] = nums[i];
                    nums[i] = buf;
                    l = i + 1;
                    swapped = true;
                }
            }
        }
        Arrays.sort(nums, l, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}