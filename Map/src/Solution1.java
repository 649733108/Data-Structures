import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution1 {
	public int[] intersection(int[] nums1, int[] nums2) {
		TreeMap<Integer,Integer> map1 = new TreeMap<Integer, Integer>();
		for (int num : nums1){
			if (map1.containsKey(num)){
				map1.put(num,map1.get(num)+1);
			}
			else {
				map1.put(num,1);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num: nums2){
			if (map1.containsKey(num) && map1.get(num)!=0){
				list.add(num);
				map1.put(num,map1.get(num)-1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0 ; i<list.size(); i++){
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String args[]) {
		int[] num1 = {2,2,4};
		int[] num2 = {2,2,2,3,4};

		int[] res = new Solution1().intersection(num1,num2);

		for (int num:res){
			System.out.println(num);
		}

	}

}