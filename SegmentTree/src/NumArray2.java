
/*
 * Created by wxn
 * 2018/8/10 2:43
 */

/**
 * 307. 区域和检索 - 数组可修改
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
class NumArray2 {

	//sums[i]数组存储前i个数字之和
	private int[]sums;
	private int[]nums;

	public NumArray2(int[] nums) {
		sums = new int[nums.length+1];
		this.nums = new int[nums.length];
		sums[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sums[i+1] = sums[i] + nums[i];
			this.nums[i] = nums[i];
		}
	}

	public void update(int i, int val) {
		nums[i] = val;
		for (int a = 0; a < nums.length; a++) {
			sums[a+1] = sums[a] + nums[a];
			this.nums[a] = nums[a];
		}
	}

	public int sumRange(int i, int j) {
		return sums[j+1]-sums[i];
	}


	public static void main(String args[]) {
		int[]nums = {1,3,5};
		NumArray2 numArray = new NumArray2(nums);
		System.out.println(numArray.sumRange(0,2));
		numArray.update(1,2);
		System.out.println(numArray.sumRange(0,2));
	}

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */