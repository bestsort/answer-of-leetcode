//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串
  
package cn.bestsort.leetcode.editor.cn;

import java.util.*;

public class Id_49_GroupAnagrams{
        public static void main(String[] args) {
            Solution solution = new Id_49_GroupAnagrams()
                              .new Solution();
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> res = solution.groupAnagrams(strs);
            for (List<String> re : res) {
                for (String s : re) {
                    System.out.print(s + ", ");
                }
                System.out.println();
            }
        }
        

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> hashMap = new HashMap<>(strs.length);
        List<List<String>> res = new ArrayList<>();
        for (String i : strs){
            char[] ch = i.toCharArray();
            Arrays.sort(ch);
            String buffer = new String(ch);
            if (hashMap.containsKey(buffer)){
                res.get(hashMap.get(buffer)).add(i);
            }else {
                List<String> list = new LinkedList<>();
                list.add(i);
                res.add(list);
                hashMap.put(buffer, res.size() - 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}