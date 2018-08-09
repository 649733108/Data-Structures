
/*
 * Created by wxn
 * 2018/7/26 19:37
 */

/**
 * LeetCode 203
 */
public class Solution5 {
	public ListNode removeElements(ListNode head , int val){
		if (head==null)
			return null;
		head.next = removeElements(head.next,val);
		if (head.val==val)
			return head.next;
		else
			return head;

	}

	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5,6,4,4,2,1};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		System.out.println(new Solution5().removeElements(node,4));

		System.out.println(Sum.sum(nums));
	}

}
