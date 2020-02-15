//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

  
package cn.bestsort.leetcode.editor.cn;
public class Id_64_MinimumPathSum{
        public static void main(String[] args) {
            Solution solution = new Id_64_MinimumPathSum()
                              .new Solution();
            int[][] grid = {{1, 3, 1},
                            {1, 5, 1},
                            {4, 2, 1}};
            System.out.println(solution.minPathSum(grid));
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = grid.clone();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] += getMin(grid, i, j);
            }
        }
        return grid.length > 0 ?
                dp[grid.length - 1][grid[0].length - 1] :
                0;
    }
    int getMin(int[][] grid, int i, int j){
        int min = Integer.MAX_VALUE;
        if (i - 1 >= 0){
            min = Math.min(grid[i - 1][j], min);
        }
        if (j - 1 >= 0){
            min = Math.min(grid[i][j - 1], min);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}