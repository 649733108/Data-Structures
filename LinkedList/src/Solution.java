
/*
 * Created by wxn
 * 2018/7/26 19:37
 */

/**
 * LeetCode 203
 */
public class Solution {
	public ListNode removeElements(ListNode head , int val){
		while (head!=null && head.val==val){
			ListNode delNode = head;
			head = head.next;
			delNode.next = null;
		}
		if (head==null){
			return null;
		}
		else {
			ListNode prev = head;
			while (prev.next!=null ){
				if (prev.next.val==val){
					ListNode delNode = prev.next;
					prev.next = delNode.next;
					delNode.next = null;
				}
				else {
					prev = prev.next;
				}
			}
		}
		return head;
	}

	public static void main(String args[]) {
		int[] nums = {1,2,3,4,5,6,4,4,2,1};
		ListNode node = new ListNode(nums);
		System.out.println(node);
		System.out.println(new Solution().removeElements(node,4));

		System.out.println(Sum.sum(nums));
	}

}
