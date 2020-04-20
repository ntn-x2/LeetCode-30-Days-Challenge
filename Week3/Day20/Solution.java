/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for (int i = 1; i < preorder.length; i++) {
            addNextNode(root, preorder[i]);
        }
        
        return root;
    }
    
    private void addNextNode(TreeNode n, int value) {
        if (value > n.val) {
            if (n.right == null) {
                n.right = new TreeNode(value);
            } else {
                addNextNode(n.right, value);
            }
        } else {
            if (n.left == null) {
                n.left = new TreeNode(value);
            } else {
                addNextNode(n.left, value);
            }
        }
    }
}