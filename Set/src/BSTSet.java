
/*
 * Created by wxn
 * 2018/8/6 22:26
 */


import java.util.ArrayList;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

	private BST<E> bst;

	public BSTSet(){
		bst = new BST<E>();
	}


	@Override
	public void add(E e) {
		bst.add(e);
	}

	@Override
	public void remove(E e) {
		bst.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}

	@Override
	public int getSize() {
		return bst.getSize();
	}

	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}




	public static void main(String[] args) {

		System.out.println("Pride and Prejudice");

		ArrayList<String> words1 = new ArrayList<String>();
		if (FileOperation.readFile("pride-and-prejudice.txt", words1)){
			System.out.println("Total words: " + words1.size());

			BSTSet<String> set1 = new BSTSet<String>();
			for (String word : words1){
				set1.add(word);
			}
			System.out.println("Total different words: " + set1.getSize());

		}
		System.out.println();

		System.out.println("a tale of two cities");
		ArrayList<String> words2 = new ArrayList<String>();
		if (FileOperation.readFile("a-tale-of-two-cities.txt" , words2)){
			System.out.println("Total words: " + words2.size());
			BSTSet<String> set2 = new BSTSet<String>();
			for (String word :words2){
				set2.add(word);
			}
			System.out.println("Total different words: " + set2.getSize());
		}
	}
}
