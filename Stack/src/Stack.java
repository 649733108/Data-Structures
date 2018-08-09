
/*
 * Created by wxn
 * 2018/7/26 8:28
 */


public interface Stack<E> {

	int getSize();
	boolean isEmpty();
	void push(E e);
	E pop();
	E peek();
}
