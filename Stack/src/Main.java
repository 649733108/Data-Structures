import java.util.Stack;

public class Main {

    public static void main(String[] args) {

//        ArrayStack<Integer> stack = new ArrayStack<Integer>();
//
//        for (int i = 0 ;i<5; i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        for (int i = 0 ;i<5; i++){
//            stack.pop();
//            System.out.println(stack);
//        }

        Solution solution = new Solution();
        String s = "({[()]}";
        System.out.println(solution.isValid(s));

    }



}
