//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法
  
package cn.bestsort.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 分段进行DFS即可
 * @author bestsort
 */
public class Id_17_LetterCombinationsOfAPhoneNumber{
        public static void main(String[] args) {
            Solution solution = new Id_17_LetterCombinationsOfAPhoneNumber()
                              .new Solution();
            List<String> res = solution.letterCombinations("");
            for (String i : res) {
                System.out.println(i);
            }
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new LinkedList<>();
    final String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int[] nums = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            nums[i] = digits.charAt(i) - '0';
        }
        getAns("", nums, 0);
        return res;
    }
    public void getAns(String ans,int[] nums, int index){
        if (index == nums.length){
            if (!ans.isEmpty()) {
                res.add(ans);
            }
            return;
        }
        for (int i = 0; i < dic[nums[index]].length(); i++) {
            getAns(ans + dic[nums[index]].charAt(i),nums, index + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}