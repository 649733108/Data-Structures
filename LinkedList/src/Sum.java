
/*
 * Created by wxn
 * 2018/7/26 20:36
 */


public class Sum {

	public static  int sum(int[] arr){
		return sum(arr , 0);
	}

	/**
	 * 计算arr[l...n)这个区间内所有数字的和
	 */
	private static int sum(int [] arr , int l){
		if (l == arr.length){
			return 0;
		}
		else {
			return arr[l] + sum(arr , l+1);
		}
	}
}
