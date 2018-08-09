import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        int n = 1000;
//
//        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
//        Random random = new Random();
//
//        for (int i = 0 ; i <n ; i++){
//            maxHeap.add(random.nextInt(1000));
//        }
//
//        int [] arr = new int[n];
//
//        for (int i = 0; i<n; i++){
//            arr[i] = maxHeap.extractMax();
//            System.out.println(arr[i]);
//        }
//
//        for (int i = 1 ; i<n; i++){
//            if (arr[i-1]<arr[i])
//                throw new IllegalArgumentException("Error!");
//        }
//        System.out.println("Test MaxHeap completed");

        Integer[] arr = {1,2,3,4,5,6,7,8,9};

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(arr);

        for (int i = 0 ; i<arr.length; i++){
            System.out.println(maxHeap.extractMax());
        }




    }
}
