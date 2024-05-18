// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Had to learn

/*
 * Problem#102
 * The maximum width of the tree is n/2- at all leaf nodes.
 */

import java.util.*;

public class BinaryTreeTraversal {

    // BFS approach: Uses Queue; pop the element how do we know the number of
    // elements in a given level.. get the size of the queue at each iteration of
    // while loop   .
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // process elements of the level
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }

                li.add(temp.val);

            }

            result.add(li);
        }

        return result;

    }

    List<List<Integer>> response;

    // DFS
    public List<List<Integer>> levelOrder_DFS(TreeNode root) {
        response = new ArrayList<>();
        if (root == null)
            return response;
        helper(root, 0);
        return response;
    }

    private void helper(TreeNode root, int height) {
        if (root == null)
            return;
        if (height == response.size()) {
            response.add(new ArrayList<>());
        }

        response.get(height).add(root.val);

        helper(root.left, height + 1);
        helper(root.right, height + 1);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}