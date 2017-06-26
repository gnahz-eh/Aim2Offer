/**
 * Created by Administrator on 2017/3/6.
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode () {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SubstructureInTree {

    // root->left->right
    public boolean hasSubTree(TreeNode t1, TreeNode t2) {
        boolean res = false;
        if (t1 != null && t1 != null) {
            if (t1.val == t2.val)
                res = doesTreeOneHaveTreeTwo(t1, t2);
            if (!res)
                res = hasSubTree(t1.left, t2) || hasSubTree(t1.right, t2);
        }
        return res;
    }

    public boolean doesTreeOneHaveTreeTwo(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (t1.val != t2.val) return false;
        return doesTreeOneHaveTreeTwo(t1.left, t1.left) && doesTreeOneHaveTreeTwo(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode l = new TreeNode(8);
        TreeNode r = new TreeNode(7);
        TreeNode ll = new TreeNode(9);
        TreeNode lr = new TreeNode(2);
        TreeNode lrl = new TreeNode(4);
        TreeNode lrr = new TreeNode(7);
        root1.left = l;
        root1.right = r;
        l.left = ll;
        l.right = lr;
        lr.left = lrl;
        lr.right = lrr;

        TreeNode root2 = new TreeNode(8);
        TreeNode l2 = new TreeNode(9);
        TreeNode r2 = new TreeNode(3);
        root2.left = l2;
        root2.right = r2;

        SubstructureInTree s = new SubstructureInTree();
        System.out.println(s.hasSubTree(root1, root2));
    }
}
