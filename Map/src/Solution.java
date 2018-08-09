import java.util.TreeSet;

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		TreeSet<Integer>set = new TreeSet<Integer>();

		for (int num :nums1){
			set.add(num);
		}
		TreeSet<Integer>set1 = new TreeSet<Integer>();
		for (int num: nums2){
			if (set.contains(num)){
				set1.add(num);
			}
		}
		int [] res = new int[set1.size()];
		int size = set1.size();
		for (int i = 0 ; i <size; i++){
			res[i] = set1.first();
			set1.remove(set1.first());
		}
		return res;
	}


	/**
	 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
	 *
	 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
	 *
	 * 输入: J = "aA", S = "aAAbbbb"
	 * 输出: 3
	 *
	 * 输入: J = "z", S = "ZZ"
	 * 输出: 0
	 *
	 * S 和 J 最多含有50个字母。
	 * J 中的字符不重复。
	 */

	public int numJewelsInStones(String J, String S) {
		TreeSet<Character> set = new TreeSet<Character>();
		for (int i = 0 ; i<J.length() ; i++){
			set.add(J.charAt(i));
		}
		int res = 0;
		for (int i = 0 ; i<S.length() ; i++){
			if (set.contains(S.charAt(i)))
				res++;
		}
		return res;
	}






	public static void main(String args[]) {
		int[] num1 = {1,2};
		int[] num2 = {2,1};

		int[] res = new Solution().intersection(num1,num2);

		for (int num:res){
			System.out.println(num);
		}

	}

}