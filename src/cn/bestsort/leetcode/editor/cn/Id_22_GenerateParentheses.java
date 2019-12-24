  //给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法
package cn.bestsort.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

  /**
   * @author bestsort
   */
public class Id_22_GenerateParentheses{
public static void main(String[] args) {
   Solution solution = new Id_22_GenerateParentheses().new Solution();
   List<String> res = solution.generateParenthesis(3);
    for (String re : res) {
        System.out.println(re);
    }
}
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }
    public void dfs(String s,int cnLeft, int cnRight){
        if (cnLeft == 0 && cnRight == 0){
            ans.add(s);
            return;
        }
        if (cnLeft != 0){
            dfs(s + '(', cnLeft - 1, cnRight);
        }
        if (cnRight > cnLeft){
            dfs(s + ')', cnLeft, cnRight-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}