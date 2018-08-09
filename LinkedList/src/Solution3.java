
/*
 * Created by wxn
 * 2018/7/26 22:17
 */


public class Solution3 {

	public String largestNumber(int[] nums) {
		for (int i = 1 ; i<nums.length ; i++){
			for (int j = 0 ; j<i ; j++){
				if(compare(String.valueOf(nums[i]),String.valueOf(nums[j]))){
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0 ; i<nums.length ; i++) {
			if (nums[0]==0){
				res.append("0");
				break;
			}
			res.append(nums[i]);
		}
		return res.toString();
	}






	public boolean compare(String a , String b){
		String n1 = a+b;
		String n2 = b+a;

		if (Long.valueOf(n1)>Long.valueOf(n2)){
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String args[]) {
		int[] nums = new int[]{999999998,999999997,999999999};
		System.out.println(new Solution3().largestNumber(nums));
	}

}
