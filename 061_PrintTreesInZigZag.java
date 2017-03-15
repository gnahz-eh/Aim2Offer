import java.util.*;

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

public class PrintTreesInZigZag {
	
	public ArrayList<ArrayList<Integer>> print(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		
		queue.addLast(null);
		queue.addLast(root);
		boolean leftToRight = true;
		
		while (queue.size() != 1) {
			TreeNode node = queue.removeFirst();
			if (node == null) {
				Iterator<TreeNode> iter = queue.iterator();
				if (leftToRight)
					iter = queue.iterator();
				else 
					iter = queue.descendingIterator();
				
				leftToRight = !leftToRight;
				while (iter.hasNext()) {
					TreeNode temp = iter.next();
					list.add(temp.val);
				}
				res.add(new ArrayList<Integer>(list));
				list.clear();
				queue.addLast(null);
				continue;
			}
			
			if (node.left != null) 
				queue.addLast(node.left);
			if (node.right != null)
				queue.addLast(node.right);
		}
		return res;
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
		
		PrintTreesInZigZag p = new PrintTreesInZigZag();
		ArrayList<ArrayList<Integer>> res = p.print(t8);
		
		for (ArrayList<Integer> list : res) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();	
		}
	}
}
