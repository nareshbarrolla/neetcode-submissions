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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> inputQueue = new ArrayDeque<>();
        inputQueue.offer(root);
        TreeNode initialRoot = root;
        while(!inputQueue.isEmpty()){
            root = inputQueue.poll();
            TreeNode temp =  root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null){                
                inputQueue.offer(root.left);
            }
            if(root.right != null){                
                inputQueue.offer(root.right);
            }            
        } 
        return initialRoot;       
    }
}
