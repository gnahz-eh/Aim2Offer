/**
 * Created by Administrator on 2017/3/15.
 */
public class SymmetricalBinaryTree {

    public boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;

        return isSymmetrical(root1.left, root2.right) &&
               isSymmetrical(root1.right, root2.left);
    }
}
