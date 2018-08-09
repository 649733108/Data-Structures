import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		BST1<Integer> bst = new BST1<Integer>();
//		Random random = new Random();
//
//		int n = 1000;
//		for (int i = 0; i < n; i++) {
//			bst.add(random.nextInt(10000));
//		}
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		while (!bst.isEmpty()) {
//			nums.add(bst.removeMax());
//		}
//		System.out.println(nums);
//
//		for (int i = 1 ; i < nums.size() ; i++){
//			if (nums.get(i-1)<nums.get(i)){
//				throw new IllegalArgumentException("ERROR!");
//			}
//		}
//		System.out.println("removeMax test completed");

		int[] nums = {6,7,2,4,1,3,5,9,8,10,11} ;
		for (int i = 0 ; i< nums.length ; i++){
			bst.add(nums[i]);
			System.out.print("add: " + nums[i]);
			System.out.println("  Size: "+bst.getSize());
		}
		bst.preOrder();
		System.out.println();

		System.out.println("remove: " + bst.removeMax());
		bst.preOrder();


	}
}
