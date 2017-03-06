import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Administrator on 2017/3/6.
 */
public class BinaryTreeInRowOrder {

    public void printFromTopToBottom(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
        }
    }

    public void inOrder (TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        BinaryTreeInRowOrder b = new BinaryTreeInRowOrder();
        b.inOrder(t1);
        System.out.println();
        b.printFromTopToBottom(t1);
    }
}
