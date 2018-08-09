
/*
 * Created by wxn
 * 2018/8/9 2:12
 */


public interface Queue<E> {

	int getSize();
	boolean isEmpty();
	void enqueue(E e);
	E dequeue();
	E getFront();
}
