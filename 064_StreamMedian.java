import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedian {
	
	private int count = 0;
	// 优先队列集合实现了堆，默认实现的小根堆
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	// 定义大根堆，更改比较方式
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i2 - i1;
		}
	});
	
	public void insert(Integer num) {
		if ((count & 1) != 0) {
            // 当数据总数为奇数时，新加入的元素，应当进入小根堆
            // （注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            // 1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
			maxHeap.offer(num);
			int filteredMaxNum = maxHeap.poll();
			minHeap.offer(filteredMaxNum);
		} else {
            // 当数据总数为偶数时，新加入的元素，应当进入大根堆
            // （注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            // 1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
			minHeap.offer(num);
			int filteredMinNum = minHeap.poll();
			maxHeap.offer(filteredMinNum);
		}
		count++;
	}
	
	public double getMedian() {
		if ((count & 1) == 0)
			return (new Double(minHeap.peek() + maxHeap.peek())) / 2;
		else 
			return maxHeap.peek();
	}
	
	public static void main(String[] args) {
		StreamMedian s = new StreamMedian();
		s.insert(6);//
		s.insert(9);//
		s.insert(3);//
		s.insert(0);//
		s.insert(11);//
		s.insert(345);//
		s.insert(78);//
		s.insert(2);//
//		s.insert(36);//
		
		System.out.println(s.getMedian());
	
		
	}

}
