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
    
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[] {Integer.MIN_VALUE};
        maxPathSumInternal(root, maxValue);
        
        return maxValue[0];
    }
    
    private int maxPathSumInternal(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        
        int leftMax = maxPathSumInternal(node.left, max);
        int rightMax = maxPathSumInternal(node.right, max);
        
        int maxSubtree = Math.max(Math.max(leftMax, rightMax)+node.val, node.val);
        int maxLeftRight = Math.max(maxSubtree, leftMax+rightMax+node.val);
        max[0] = Math.max(max[0], maxLeftRight);
        
        return maxSubtree;
    }
}