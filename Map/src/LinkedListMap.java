
/*
 * Created by wxn
 * 2018/8/7 3:24
 */


import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

	private class Node {
		private K key;
		private V value;
		private Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key) {
			this(key, null, null);
		}

		public Node() {
			this(null, null, null);
		}

		@Override
		public String toString() {
			return key.toString() + " : " + value.toString();
		}
	}

	private Node dummyNode;
	private int size;

	public LinkedListMap() {
		dummyNode = new Node();
		size = 0;
	}


	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		if (node == null){
			dummyNode.next = new Node(key,value,dummyNode.next);
			size++;
		}
		else {
			node.value = value;
		}
	}

	@Override
	public V remove(K key) {
		Node prev = dummyNode;
		while (prev.next!=null){
			if (prev.next.key.equals(key))
				break;
			prev = prev.next;
		}
		if (prev.next!=null){
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(key);
		if (node!=null){
			node.value = value;
		}
		else {
			add(key,value);
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private Node getNode(K key) {
		Node cur = dummyNode.next;
		while (cur != null) {
			if (cur.key.equals(key))
				return cur;
			cur = cur.next;
		}
		return null;
	}

	public static void main(String args[]) {
		System.out.println("pride and prejudice");
		ArrayList<String>words = new ArrayList<String>();
		if (FileOperation.readFile("pride-and-prejudice.txt",words)){
			System.out.println("Total words : " + words.size());
			LinkedListMap<String ,Integer> map = new LinkedListMap<String, Integer>();
			for (String word :words){
				if (map.contains(word)){
					map.set(word,map.get(word)+1);
				}
				else {
					map.add(word,1);
				}
			}
			while (map.dummyNode.next!=null){
				System.out.println(map.dummyNode.next.key + ": " + map.dummyNode.next.value);
				map.dummyNode = map.dummyNode.next;
			}
		}

	}


}
