  //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针
package cn.bestsort.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.LinkedList;
  import java.util.List;

  public class Id_15_ThreeSum{
    public static void main(String[] args) {
        int[] array = {-1, 0, 0, 0, 1, 2, -1, -4};
        Solution solution = new Id_15_ThreeSum().new Solution();
        System.out.println(solution.threeSum(array));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1,r = nums.length - 1;
            while (l < r){
                // equals
                if (nums[i] + nums[r] + nums[l] == 0){
                    ArrayList<Integer> buf = new ArrayList<>();
                    buf.add(nums[i]);
                    buf.add(nums[l]);
                    buf.add(nums[r]);
                    res.add(buf);
                    l ++;
                    r --;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l ++;
                    }
                    while (r > l && nums[r] == nums[r + 1]){
                        r --;
                    }
                }
                else if (nums[l] + nums[r] + nums[i] > 0){
                   r --;

                }else {
                    l ++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}