//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划
  
package cn.bestsort.leetcode.editor.cn;
public class Id_5_LongestPalindromicSubstring{
        public static void main(String[] args) {
            Solution solution = new Id_5_LongestPalindromicSubstring()
                              .new Solution();
            String s = "acbab";
            System.out.println(solution.longestPalindrome(s));
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        int left = 0, length = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = 0; j < i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j)
                        && (i-j<2 || 0 != dp[j+1][i-1]))? 1 : 0;
                if (dp[j][i] != 0 && length < i - j + 1){
                    length = i - j + 1;
                    left = j;
                }
            }
        }
        return s.substring(left, Math.min(s.length(),left+length));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}