//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法
  
package cn.bestsort.leetcode.editor.cn;

import java.util.*;

public class Id_40_CombinationSumIi{
        public static void main(String[] args) {
            Solution solution = new Id_40_CombinationSumIi()
                              .new Solution();
            int[] candidates = {10,1,2,7,6,1,5};
            int target = 8;
            List<List<Integer>> res = solution.combinationSum2(candidates,target);
            for (List<Integer> item : res) {
                for(Integer i : item){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> buffer = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        depthFirstSearch(candidates, target, -1);
        return this.res;
    }
    public void depthFirstSearch(int[] candidates, int target, int index){
        if (target <= 0){
            if (target == 0) {
                List<Integer> ans = new LinkedList<>(buffer);
                if(!res.contains(ans)) {
                    res.add(ans);
                }
            }
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            buffer.add(candidates[i]);
            depthFirstSearch(candidates, target - candidates[i], i);
            buffer.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}