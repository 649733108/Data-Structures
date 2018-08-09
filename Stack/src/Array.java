
/*
 * Created by wxn
 * 2018/7/25 3:38
 */

/**
 * 二次封装自己的数组
 */

public class Array<E> {
	private E[] data;
	private int size;

	/**
	 * 构造函数
	 *
	 * @param capacity 数组容量
	 */
	Array(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	/**
	 * 无参构造函数 默认数组的容量capacity=10
	 */
	public Array() {
		this(10);
	}

	/**
	 * 获取数组中元素的个数
	 */
	int getSize() {
		return size;
	}

	/**
	 * 获取数组的容量
	 */
	public int getCapacity() {
		return data.length;
	}

	/**
	 * 返回数组是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 向数组末尾添加元素
	 */
	void addLast(E e) {
		add(size, e);
	}

	/**
	 * 向数组首部添加元素
	 */
	void addFirst(E e) {
		add(0, e);
	}

	/**
	 * 向数组指定位置插入元素
	 */
	void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("error! Required index>=0 and index<=size");
		}
		if (size == data.length) {
			resize(data.length * 2);
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}


	//	获取index索引位置的元素
	E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed.Index is illegal");
		}
		return data[index];
	}

	E getFirst(){
		return get(0);
	}

	E getLast(){
		return get(size-1);
	}

	//	设置index索引位置的元素
	void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Get failed.Index is illegal");
		}
		data[index] = e;
	}

	/**
	 * 查找数组中是否有元素e
	 */
	boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
	 */
	int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 从数组中删除指定索引的元素
	 */
	E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Delete failed, index is wrong!");
		}
		E ret = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		data[size] = null; //loitering objects != memory leak

		//防止复杂度震荡
		if (size <= data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}
		return ret;
	}

	/**
	 * 从数组中删除第一个元素
	 */
	E removeFirst() {
		return remove(0);
	}

	/**
	 * 从数组中删除最后一个元素
	 */
	E removeLast() {
		return remove(size - 1);
	}

	/**
	 * 从数组中删除元素e
	 */
	void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d \n", size, data.length));
		res.append('[');
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(", ");
			}
		}
		res.append(']');
		return res.toString();
	}

	/**
	 * 数组扩容
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
}
