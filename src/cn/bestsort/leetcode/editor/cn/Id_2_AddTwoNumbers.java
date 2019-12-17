//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学
  
package cn.bestsort.leetcode.editor.cn;
public class Id_2_AddTwoNumbers{
        public static void main(String[] args) {
            Solution solution = new Id_2_AddTwoNumbers()
                              .new Solution();
            int[] a = {0};
            int[] b = {5,6,4};
            ListNode l1 = buildNum(a);
            ListNode l2 = buildNum(b);
            ListNode result = solution.addTwoNumbers(l1,l2);
            while (null != result){
                System.out.print(result.val + "->");
                result = result.next;
            }
        }
        private static ListNode buildNum(int[] nums){
            ListNode listNode = new Id_2_AddTwoNumbers().new ListNode(nums[0]);
            ListNode tail = listNode;
            for (int i = 1; i < nums.length; i++) {
                tail.next = new Id_2_AddTwoNumbers().new ListNode(nums[i]);
                tail = tail.next;
            }
            return  listNode;
        }
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int buffer = 0;
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        while (l1 != null || l2 != null){
            int add = 0;
            if (l1 != null && l2 == null){
                add = l1.val;
            }else if (l1 == null){
                add = l2.val;
            }else {
                add = l1.val + l2.val;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            listNode.next = new ListNode((add + buffer)%10);
            buffer = (add + buffer) / 10;
            listNode = listNode.next;
        }
        if (buffer != 0){
            listNode.next = new ListNode(buffer);
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}