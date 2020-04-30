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
    
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0);
    }
    
    private boolean isValidSequence(TreeNode node, int[] arr, int index) {
        if (index == arr.length-1) {
            return isLeaf(node) && node.val == arr[index];
        }
        
        return node != null && node.val == arr[index] && (isValidSequence(node.left, arr, index+1) || isValidSequence(node.right, arr, index+1));
    }
    
    private boolean isLeaf(TreeNode n) {
        return n != null && n.left == null && n.right == null;
    }
}