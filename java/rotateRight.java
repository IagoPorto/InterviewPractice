/**
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

 

Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 109


**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        List<ListNode>  l = new ArrayList<>();
        if(head == null || k == 0){
            return head;
        }

        ListNode head2 = head;
        
        while(head != null){
            l.add(head);
            head = head.next;
        }

        if(l.size() == 1){
            return head2;
        }
        k = k % l.size();
        for(int  i = 0; i < k; i++){
            ListNode ln = l.remove(l.size() - 1);
            l.add(0, ln);
            l.get(l.size()  - 1).next = null;
            l.get(0).next = l.get(1);
        }

        return l.get(0);
    }
}
