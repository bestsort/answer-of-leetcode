//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

  
package cn.bestsort.leetcode.editor.cn;

import java.util.Arrays;

public class Id_56_MergeIntervals{
        public static void main(String[] args) {
            Solution solution = new Id_56_MergeIntervals()
                              .new Solution();
            int[][] intervals = {{1,3},
                    {2,6},
                    {8,10},{15,18}};
            int[][] res = solution.merge(intervals);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    System.out.print(String.format("%3d", res[i][j]));
                }
                System.out.println();
            }
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][0];
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int cnt = 0;
        int[][] res = new int[intervals.length][2];
        int start =intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end){
                int[] buf = {start, end};
                res[cnt][0] = start;
                res[cnt][1] = end;
                cnt++;
                start = intervals[i][0];
                end = intervals[i][1];
            }
            end = Math.max(end, intervals[i][1]);
        }
        res[cnt][0] = start;
        res[cnt][1] = end;
        cnt++;
        int[][] ans = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            ans[i] = res[i].clone();
        }
        return ans;
    }
    class Pair{
        int start;
        int end;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}