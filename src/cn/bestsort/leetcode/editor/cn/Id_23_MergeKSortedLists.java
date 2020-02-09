  //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法
package cn.bestsort.leetcode.editor.cn;

public class Id_23_MergeKSortedLists{
    public static void main(String[] args) {

        Solution solution = new Id_23_MergeKSortedLists().new Solution();
        ListNode[] node = new ListNode[20];

        node[1] = new Id_23_MergeKSortedLists().new ListNode(1).add(4).add(2);
        node[0] = new Id_23_MergeKSortedLists().new ListNode(3).add(10).add(9);
        node[2] = new Id_23_MergeKSortedLists().new ListNode(4).add(44).add(22);
        node[3] = new Id_23_MergeKSortedLists().new ListNode(6).add(90).add(11);

        ListNode node1 = solution.mergeKLists(node);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
        public ListNode add(int x){
            ListNode buf = this.next;
            ListNode now = new Id_23_MergeKSortedLists().new ListNode(x);
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return merge(0,lists.length - 1,lists);

    }

    public ListNode merge(int l, int r, ListNode[] listNodes){
        if (l == r){
            return listNodes[l];
        }
        return mergeTwoLists(
                merge(l, (l + r) / 2, listNodes),
                merge((l + r ) / 2 + 1, r, listNodes)
        );
    }
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