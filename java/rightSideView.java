/**
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:

Input: root = [1,null,3]
Output: [1,3]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100


**/

/**
There are two approaches, the one I did, that is BFS (Breadth-First Search), and the other one is 
DFS (Depth-First Search), this one is better
**/

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); 
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode current = null;
            
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if(i == 0){
                    list.add(current.val);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
            }
            
        }
        
        return list;
    }
}
