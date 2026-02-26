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
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val < p.val && root.val < q.val) {
            return LCA(root.right, p, q);
        }

        if(root.val > p.val && root.val > q.val) {
            return LCA(root.left, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }
}