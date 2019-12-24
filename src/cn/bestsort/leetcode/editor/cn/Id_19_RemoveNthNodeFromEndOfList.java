//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针
  
package cn.bestsort.leetcode.editor.cn;
public class Id_19_RemoveNthNodeFromEndOfList{
        public static void main(String[] args) {
            Solution solution = new Id_19_RemoveNthNodeFromEndOfList()
                              .new Solution();
            int[] digits = {1,2,3,4,5};
            ListNode head = new Id_19_RemoveNthNodeFromEndOfList().new ListNode(digits[0]);
            ListNode buffer = head;
            for (int i = 1; i < digits.length; i++) {
                buffer.next = new Id_19_RemoveNthNodeFromEndOfList().new ListNode(digits[i]);
                buffer = buffer.next;
            }
            head = solution.removeNthFromEnd(head, 2);
            while (head != null){
                System.out.print(head.val);
                head = head.next;
            }
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
    boolean isDelete = false;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        findNode(head, n);
        if (!isDelete){
            return head.next;
        }
        return head;
    }
    public int findNode(ListNode now, int kth){
        if (now == null){
            return 0;
        }
        int nowIndex = findNode(now.next, kth) + 1;
        if (nowIndex == kth + 1){
            isDelete = true;
            now.next = now.next.next;
        }
        return nowIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}