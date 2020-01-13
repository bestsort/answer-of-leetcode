//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 示例 1: 
//
// 输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释: 
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2: 
//
// 输入: word1 = "intention", word2 = "execution"
//输出: 5
//解释: 
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划
  
package cn.bestsort.leetcode.editor.cn;
public class Id_72_EditDistance{
        public static void main(String[] args) {
            Solution solution = new Id_72_EditDistance()
                              .new Solution();
            String word1 = "intention";
            String word2 = "execution";
            System.out.println(solution.minDistance(word1,word2));

        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()){
            return Math.abs(word1.length() - word2.length());
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= word1.length() ;i++) {
            dp[i][0] = i;
        }
        String s;
        StringBuffer stringBuffer;
        StringBuilder stringBuilder;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}