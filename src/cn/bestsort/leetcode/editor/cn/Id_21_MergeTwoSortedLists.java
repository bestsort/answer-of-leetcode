  //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表
package cn.bestsort.leetcode.editor.cn;

  public class Id_21_MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new Id_21_MergeTwoSortedLists().new Solution();
        ListNode node = new Id_21_MergeTwoSortedLists().new ListNode(1);
        node.add(4).add(2);
        ListNode node1 = new Id_21_MergeTwoSortedLists().new ListNode(1);
        node1.add(4).add(3);
        node = solution.mergeTwoLists(node,node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
    public ListNode add(int x){
        ListNode buf = this.next;
        ListNode now = new Id_21_MergeTwoSortedLists().new ListNode(x);
        this.next = now;
        now.next = buf;
        return this;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return  l2;
        }
        if (l2 == null){
            return  l1;
        }
        ListNode res = null;
        ListNode now = null;
        while (l1 != null || l2 != null){
            ListNode buf;
            if(l2 == null || (l1 != null && l1.val < l2.val)){
                buf = l1;
                l1 = l1.next;
            }
            else {
                buf = l2;
                l2 = l2.next;
            }
            if (res == null){
                res = buf;
                now = buf;
            }else {
                now.next = buf;
                now = now.next;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}