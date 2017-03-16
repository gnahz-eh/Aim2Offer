import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindow {

//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int len = nums.length;
//         if (len == 0) return nums;
//         int[] res = new int[len - k + 1];
        
//         Deque<Integer> dq = new LinkedList<Integer>();
//         for (int i = 0; i < len; i++) {
//         	if (!dq.isEmpty() && dq.peek() < i - k + 1)
//         		dq.poll();
        	
//         	while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
//         		dq.pollLast();
        	
//         	dq.offer(i);
//         	if (i - k + 1 >= 0) 
//         		res[i - k + 1] = nums[dq.peek()];
//         }
        
//         return res;
//     }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] res = new int[len - k + 1];
        
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
        	while (!dq.isEmpty() && dq.peekLast() < nums[i])
        		dq.pollLast();
        	
        	dq.offer(nums[i]);
        	
        	if (i >= k - 1) {
        		res[i - k + 1] = dq.peek();
        		if (nums[i - k + 1] == dq.peek())
        			dq.pollFirst();
        	}
        }
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,3,4,2,6,2,5,1};
    	MaxInSlidingWindow m = new MaxInSlidingWindow();
    	int[] res = m.maxSlidingWindow(nums, 3);
    	for (int i : res)
    		System.out.print(i + " ");
    }
}
