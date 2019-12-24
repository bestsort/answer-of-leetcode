  //给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法
package cn.bestsort.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.stream.Collectors;

  public class Id_46_Permutations{
    public static void main(String[] args) {
        Solution solution = new Id_46_Permutations().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.permute(nums);
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<int[]> buffer = new LinkedList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums,int index){
        if (index == nums.length){
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(nums, index + 1);
            swap(nums, i, index);
        }
    }
    public void swap(int[] nums,int a,int b){
        int buf = nums[a];
        nums[a] = nums[b];
        nums[b] = buf;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}