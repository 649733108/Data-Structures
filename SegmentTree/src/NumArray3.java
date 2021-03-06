
/*
 * Created by wxn
 * 2018/8/10 2:43
 */

/**
 * 307. 区域和检索 - 数组可修改
 * <p>
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 示例:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 * <p>
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
class NumArray3 {

	private Integer[] nums;
	private SegmentTree<Integer> segmentTree;

	public NumArray3(int[] nums) {
		if (nums.length==0)
			return;
		this.nums = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			this.nums[i] = nums[i];
		}
		segmentTree = new SegmentTree<>(this.nums, (a, b) -> (a + b));
	}

	public void update(int i, int val) {
		nums[i] = val;
		segmentTree.set(i,val);
	}

	public int sumRange(int i, int j) {
		if (segmentTree==null){
			throw new IllegalArgumentException("error!");
		}
		return segmentTree.query(i, j);
	}


	public static void main(String args[]) {
		int[] nums = {};
		NumArray3 numArray = new NumArray3(nums);
		System.out.println(numArray.sumRange(0, 2));
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2));
	}

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */