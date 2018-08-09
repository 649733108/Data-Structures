
/*
 * Created by wxn
 * 2018/7/27 15:14
 */

/**
 * 单链表的递归实现
 */
public class LinkedListWithRecursion<E> {
	private class Node{
		E e;
		Node next;

		public Node(E e , Node next){
			this.e = e;
			this.next = next;
		}
		public Node(E e){
			this(e , null);
		}
		public Node(){
			this(null , null);
		}
		@Override
		public String toString(){
			return e.toString();
		}
	}

	private Node dummyNode;
	private int size;

	public LinkedListWithRecursion(){
		dummyNode = new Node();
		size = 0;
	}

	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}

	public void add(E e, int index){
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed.Illegal index");
		}
		addWithRecursion(e,dummyNode,index,0);
	}
	public void addFirst(E e){
		add(e, 0);
	}

	private void addWithRecursion(E e, Node prev, int index, int cur){
		if (cur == index){
			prev.next = new Node(e,prev.next);
			size++;
		}
		else {
			addWithRecursion(e,prev.next,index,cur+1);
		}
	}

	public E remove(int index){
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Set failed.Illegal index");
		}
		return removeWithRecursion(index,dummyNode,0);
	}
	public E removeFirst(){
		return remove(0);
	}
	public E removeLast(){
		return remove(size-1);
	}
	private E removeWithRecursion(int index , Node prev , int cur){
		if (cur == index){
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.e;
		}
		return removeWithRecursion(index,prev.next,cur+1);

	}

	public int find(E e){
		return findWithRecursion(e,dummyNode.next,0);
	}
	private int findWithRecursion(E e , Node head , int index){
		if (head == null){
			throw new IllegalArgumentException("NOT FIND!");
		}
		if (head.e==e){
			return index;
		}
		return findWithRecursion(e,head.next,index+1);
	}


	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Size: %d\n",size));
		Node cur = dummyNode.next;
		while (cur!=null){
			res.append(cur).append("->");
			cur = cur.next;
		}
		res.append("NULL");

		return res.toString();
	}

	public static void main(String args[]) {
		LinkedListWithRecursion<Integer> list = new LinkedListWithRecursion<Integer>();
		for (int i = 0 ; i<10 ; i++){
			list.addFirst(i);
			System.out.println(list);
		}


		System.out.println(list.find(11));
	}


}
