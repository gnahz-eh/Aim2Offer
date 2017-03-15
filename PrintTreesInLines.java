import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode() {
		this.val = 0;
		this.left = null;
		this.right = null;
	}
	
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class PrintTreesInLines {

	public void print(TreeNode root) {
		
		if (root == null)
			return;
		
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.addLast(root);
		int nextLevel = 0;
		int toBePrinted = 1;
		while (!queue.isEmpty()) {
			TreeNode node = queue.getFirst();
			System.out.print(node.val + " ");
			if (node.left != null) {
				queue.addLast(node.left);
				++nextLevel;
			}
			if (node.right != null) {
				queue.addLast(node.right);
				++nextLevel;
			}
			
			queue.pop();
			--toBePrinted;
			if (toBePrinted == 0) {
				System.out.println();
				toBePrinted = nextLevel;
				nextLevel = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode t8 = new TreeNode(8);
		TreeNode t6 = new TreeNode(6);
		TreeNode t10 = new TreeNode(10);
		TreeNode t5 = new TreeNode(5);
		TreeNode t7 = new TreeNode(7);
		TreeNode t9 = new TreeNode(9);
		TreeNode t11 = new TreeNode(11);
		
		t8.left = t6;
		t8.right = t10;
		t6.left = t5;
		t6.right = t7;
		t10.left = t9;
		t10.right = t11;
		
		PrintTreesInLines p = new PrintTreesInLines();
		p.print(t8);
		
	}
	
}
