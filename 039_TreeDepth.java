/**
 * Created by Administrator on 2017/3/10.
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }
}

public class TreeDepth {

    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }
}
