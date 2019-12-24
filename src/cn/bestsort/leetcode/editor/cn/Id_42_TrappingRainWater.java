  //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针
package cn.bestsort.leetcode.editor.cn;

public class Id_42_TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new Id_42_TrappingRainWater().new Solution();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(nums));

    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int[] prefix = height.clone();
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], prefix[i]);
        }
        int right = 0;
        int res = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            right = Math.max(height[i], right);
            res += Math.min(prefix[i], right) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}