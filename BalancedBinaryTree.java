/**
 * Created by Administrator on 2017/3/10.
 */



public class BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
        return right > left ? right+1 : left+1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t5.left = t7;

        BalancedBinaryTree b = new BalancedBinaryTree();
        System.out.print(b.isBalanced(t1));

    }
}
