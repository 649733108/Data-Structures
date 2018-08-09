public class Main {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<Integer>();
        for (int i = 0 ; i<10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.addLast(10);
        System.out.println(arr);

        arr.addFirst(-123);
        System.out.println(arr);

        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        System.out.println(arr);

        arr.addFirst(1);
        System.out.println(arr);
        arr.addFirst(1);
        System.out.println(arr);
    }
}
