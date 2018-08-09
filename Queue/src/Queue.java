
/*
 * Created by wxn
 * 2018/7/26 9:54
 */


public interface Queue<E> {

	int getSize();
	boolean isEmpty();
	void enqueue(E e);
	E dequeue();
	E getFront();
}
