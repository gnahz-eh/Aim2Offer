/**
 * Created by Administrator on 2017/3/6.
 */
public class MirrorOfBinaryTree {
    // leetcode 226
    public TreeNode mirror(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
        return root;
    }
}
