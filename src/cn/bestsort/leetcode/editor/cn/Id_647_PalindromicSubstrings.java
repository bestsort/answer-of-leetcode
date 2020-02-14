//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划

  
package cn.bestsort.leetcode.editor.cn;

public class Id_647_PalindromicSubstrings{
        public static void main(String[] args) {
            Solution solution = new Id_647_PalindromicSubstrings()
                              .new Solution();
            String s = "xkjkqlajprjwefilxgpdpebieswu";
            System.out.println(solution.countSubstrings(s));
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        for(int i=0; i < s.length(); i++){
            boolean sing = false;
            boolean doub = false;
            for (int j = 0; i - j >= 0 && i + j <s.length(); j++) {
                if (!sing && s.charAt(i + j) == s.charAt(i - j)) {
                    cnt ++;
                }else {
                    sing = true;
                }
                if (!doub && i + j + 1 < s.length() &&
                    s.charAt(i + j + 1) == s.charAt(i - j)){
                    cnt ++;
                }else{
                    doub = true;
                }
                if (doub && sing){
                    break;
                }
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}