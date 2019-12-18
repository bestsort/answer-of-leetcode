//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window
  
package cn.bestsort.leetcode.editor.cn;

import java.util.HashMap;

public class Id_3_LongestSubstringWithoutRepeatingCharacters{
        public static void main(String[] args) {
            Solution solution = new Id_3_LongestSubstringWithoutRepeatingCharacters()
                              .new Solution();
            String s = "abba";
            System.out.println(solution.lengthOfLongestSubstring(s));
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); cnt++,i++) {
            if (hashMap.containsKey(s.charAt(i))){
                res = Math.max(res,cnt);
                cnt = Math.min(cnt,i - hashMap.get(s.charAt(i)) - 1);
            }
            hashMap.put(s.charAt(i),i);
        }
        return Math.max(cnt,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}