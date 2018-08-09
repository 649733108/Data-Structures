
/*
 * Created by wxn
 * 2018/7/26 19:53
 */


public class Solution2 {
	public ListNode removeElements(ListNode head , int val){
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		while (prev.next!=null){
			if (prev.next.val==val){
				prev.next = prev.next.next;
			}
			else {
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}
}
