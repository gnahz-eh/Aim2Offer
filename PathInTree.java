import java.util.*;

/**
 * Created by Administrator on 2017/3/7.
 */
public class PathInTree {
    void findPath(TreeNode root, int expectedSum) {

        if (root == null)
            return;

        List<Integer> path = new ArrayList<>();
        int currentSum = 0;
        findPath(root, expectedSum, path, currentSum);
    }

    void findPath(TreeNode root, int expectedSum, List<Integer> path, int currentSum) {
        currentSum += root.val;
        path.add(root.val);
        boolean isLeaf = (root.left == null) && (root.right == null);
        if (currentSum == expectedSum && isLeaf) {
            System.out.print("A path has been found : ");
            for (int e : path)
                System.out.print(e + "->");
            System.out.println();
        }
        if (root.left != null)
            findPath(root.left, expectedSum, path, currentSum);
        if (root.right != null)
            findPath(root.right, expectedSum, path, currentSum);

        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        PathInTree p = new PathInTree();
        p.findPath(t1, 22);

    }
}
