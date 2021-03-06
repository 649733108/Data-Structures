
/*
 * Created by wxn
 * 2018/8/9 2:29
 */

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * LeetCode347
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 例如，
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 *
 * 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution2 {

	public List<Integer> topKFrequent(int[] nums, int k) {

		/**
		 * 先统计频次，用TreeMap
		 */
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();
		for (int i = 0 ; i<nums.length; i++){
			if (treeMap.containsKey(nums[i])){
				treeMap.put(nums[i],treeMap.get(nums[i])+1);
			}else {
				treeMap.put(nums[i],1);
			}
		}

		PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
		for (int key: treeMap.keySet()){
			if (pq.size()<k){
				pq.add(new Freq(key,treeMap.get(key)));
			}
			else if (treeMap.get(key)>pq.peek().freq){
				pq.remove();
				pq.add(new Freq(key,treeMap.get(key)));
			}
		}

		LinkedList<Integer> list = new LinkedList<Integer>();
		while (!pq.isEmpty()){
			list.add(pq.remove().e);
		}
		return list;
	}


	private class Freq implements Comparable<Freq> {
		private int e;
		private int freq;

		public Freq(int e, int freq){
			this.e = e;
			this.freq = freq;
		}

		@Override
		public int compareTo(Freq newFreq) {
			if (freq<newFreq.freq)
				return -1;
			else if (freq==newFreq.freq)
				return 0;
			else
				return 1;
		}
	}

	public static void main(String args[]) {
		Solution2 solution = new Solution2();

		int[]arr = {1,1,1,2,2,3};
		List<Integer> list;
		list = solution.topKFrequent(arr,2);
		System.out.println(list);
	}

}
