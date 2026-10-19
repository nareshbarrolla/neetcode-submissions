/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxDepth = 0;
        Deque<TreeNode> inputStack = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();        
        inputStack.push(root);
        depth.push(1);        
        while(!inputStack.isEmpty()){
            TreeNode node = inputStack.pop();
            int currentDepth = depth.pop();
            maxDepth = Math.max(maxDepth, currentDepth);
            if(node.right != null){
                inputStack.push(node.right);
                depth.push(currentDepth+1);
            }
            if(node.left != null){
                inputStack.push(node.left); 
                depth.push(currentDepth+1);                           
            }            
        }
        return maxDepth;
    }    
}
