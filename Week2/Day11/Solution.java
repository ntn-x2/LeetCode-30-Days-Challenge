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
    
    class IntermediateResult {
        int subtreeDiameter;
        int subtreeDepth;

        IntermediateResult(int subtreeDiameter, int subtreeDepth) {
            this.subtreeDiameter = subtreeDiameter;
            this.subtreeDepth = subtreeDepth;
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeInternal(root).subtreeDiameter;
    }

    private IntermediateResult diameterOfBinaryTreeInternal(TreeNode node) {
        if (node == null) {
            return new IntermediateResult(0, 0);
        }

        IntermediateResult leftSubtreeResult = diameterOfBinaryTreeInternal(node.left);
        IntermediateResult rightSubtreeResult = diameterOfBinaryTreeInternal(node.right);

        return new IntermediateResult(Math.max(Math.max(leftSubtreeResult.subtreeDiameter, rightSubtreeResult.subtreeDiameter), leftSubtreeResult.subtreeDepth + rightSubtreeResult.subtreeDepth), Math.max(leftSubtreeResult.subtreeDepth, rightSubtreeResult.subtreeDepth) + 1);
    }
}