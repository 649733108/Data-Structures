
/*
 * Created by wxn
 * 2018/7/26 19:36
 */


public class ListNode {
	int val;
	ListNode next;

	ListNode(int x){
		val = x;
	}

	public ListNode(int[] arr){
		if (arr == null || arr.length==0){
			throw new IllegalArgumentException("arr cannot be empty!");
		}
		this.val = arr[0];
		ListNode cur = this;
		for (int i = 1 ; i<arr.length ; i++){
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("LinkedList: ");
		ListNode cur = this;
		while (cur!=null){
			res.append(cur.val).append("->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
}
