//根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表
  
package cn.bestsort.leetcode.editor.cn;

import java.util.Stack;

public class Id_739_DailyTemperatures{
        public static void main(String[] args) {
            Solution solution = new Id_739_DailyTemperatures()
                              .new Solution();
            int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
            int[] res = solution.dailyTemperatures(temperatures);
            for (int i : res) {
                System.out.print(i + " ");
            }
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int index = T.length - 1;
        Stack<Integer> stack = new Stack<>();

        int res[] = new int[T.length];
        for(int i = T.length - 1; i >= 0; i--){
            int cnt = 0;
            if (!stack.isEmpty() && T[stack.peek()] <= T[i]){
                while (!stack.isEmpty() && T[stack.peek()] <= T[i]){
                    cnt++;
                    stack.pop();
                }
            }
            cnt = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
            res[i] = cnt;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}