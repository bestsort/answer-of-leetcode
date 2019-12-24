//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法
  
package cn.bestsort.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Id_39_CombinationSum{
        public static void main(String[] args) {
            Solution solution = new Id_39_CombinationSum()
                              .new Solution();
            int[] candidates = {2, 3, 5};
            int target = 8;
            solution.combinationSum(candidates,target);
            List<List<Integer>> res = solution.res;
            for (List<Integer> item : res) {
                for(Integer i : item){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> res = new LinkedList<>();
    public LinkedList<Integer> buffer = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        depthFirstSearch(candidates,target,0);
        return this.res;
    }
    public void depthFirstSearch(int[] candidates, int target, int index){
        if (target <= 0){
            if (target == 0) {
                res.add(new LinkedList<>(buffer));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            buffer.add(candidates[i]);
            depthFirstSearch(candidates, target - candidates[i], i);
            buffer.removeLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}