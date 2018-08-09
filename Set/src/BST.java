
/*
 * Created by wxn
 * 2018/7/27 16:25
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * 不包含重复元素
 * 递归实现
 */
public class BST<E extends Comparable<E>> {

	private class Node {
		public E e;
		public Node left;
		public Node right;

		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 二分搜索树添加新元素
	 */
	public void add(E e) {
		root = add(root, e);
	}

	/**
	 * 向以node为根的BST中插入元素e，递归算法
	 * 返回插入新节点后BST的根
	 */
	private Node add(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		} else if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		} else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}
		return node;
	}


	/**
	 * 看BST中是否包含元素e
	 */
	public boolean contains(E e) {
		return contains(root, e);
	}

	/**
	 * 看以node为根的BST是否包含元素e 递归算法
	 */
	private boolean contains(Node node, E e) {
		if (node == null)
			return false;
		if (e.compareTo(node.e) == 0)
			return true;
		else if (e.compareTo(node.e) < 0)
			return contains(node.left, e);
		else
			return contains(node.right, e);
	}

	/**
	 * BST前序遍历
	 */
	public void preOrder() {
		preOrder(root);
	}

	/**
	 * 前序遍历以node为根的BST
	 */
	private void preOrder(Node node) {

//		if (node==null)
//			return;

		if (node != null) {
			System.out.println(node.e);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	/**
	 * BST非递归前序遍历
	 */
	public void preOrderNR(){
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()){
			Node cur = stack.pop();
			System.out.println(cur.e);

			if (cur.right!=null)
				stack.push(cur.right);
			if (cur.left!=null)
				stack.push(cur.left);
		}
	}

	/**
	 * BST 中序遍历
	 */
	public void inOrder() {
		inOrder(root);
	}

	/**
	 * 中序遍历以node为根的BST
	 */
	private void inOrder(Node node) {

		if (node == null)
			return;

		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);

	}

	/**
	 * BST 后序遍历
	 */
	public void postOrder() {
		postOrder(root);
	}

	/**
	 * 后序遍历以node为根的BST
	 */
	private void postOrder(Node node) {

		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	/**
	 * BST层序遍历
	 */
	public void levelOrder(){
		Queue<Node>queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()){
			Node cur = queue.remove();
			System.out.println(cur.e);
			if (cur.left!=null)
				queue.add(cur.left);
			if (cur.right!=null)
				queue.add(cur.right);
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	/**
	 * 生成以node为根节点，深度为depth的描述二叉树的字符串
	 */
	private void generateBSTString(Node node, int depth, StringBuilder res) {

		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}
		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	/**
	 * 删除BST的最小值非递归算法
	 */
	public E removeMinNR(){
		if (root==null){
			return null;
		}
		if (root.left==null){
			E res = root.e;
			root = root.right;
			size--;
			return res;
		}
		Node cur = root;
		Node prev = null;
		while (cur.left!=null){
			prev = cur;
			cur = cur.left;
		}
		if (prev!=null) {
			prev.left = cur.right;
			size--;
		}
		cur.right = null;
		return cur.e;
	}
	/**
	 * 删除BST最小值递归算法
	 */
	public E removeMin(){
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}

	/**
	 * 删除以node为根的BST的最小节点
	 * 返回新BST的根
	 */
	private Node removeMin(Node node) {
		if (node.left==null){
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		else {
			node.left = removeMin(node.left);
			return node;
		}
	}

	/**
	 * 删除BST最大值递归算法
	 */
	public E removeMax(){
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}

	/**
	 * 删除以node为根的BST的最大节点
	 * 返回新BST的根
	 */
	private Node removeMax(Node node) {
		if (node.right==null){
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		else {
			node.right = removeMax(node.right);
			return node;
		}
	}

	/**
	 * 寻找BST的最小元素
	 */
	public E minimum(){
		if (size==0){
			throw new IllegalArgumentException("BST is empty!");
		}
		return minimum(root).e;
	}

	/**
	 * 返回以node为根的BST的最小值所在节点
	 */
	private Node minimum(Node node) {
		if (node.left==null)
			return node;
		else
			return minimum(node.left);
	}
	/**
	 * 寻找BST的最大元素
	 */
	public E maximum(){
		if (size==0){
			throw new IllegalArgumentException("BST is empty!");
		}
		return maximum(root).e;
	}

	/**
	 * 返回以node为根的BST的最大值所在节点
	 */
	private Node maximum(Node node) {
		if (node.right==null)
			return node;
		else
			return maximum(node.right);
	}

	/**
	 * 从BST中删除元素为e的节点
	 */
	public void remove(E e){
		if (!this.contains(e)){
			System.out.println("There is no element '" + e +"'");
		}
		root = remove1(root , e);
	}

	/**
	 * 删除以node为根的BST中值为e的节点， 递归算法
	 * 返回新的BST的根
	 */
	private Node remove(Node node, E e) {

		if (node == null){
			return null;
		}
		if (e.compareTo(node.e)<0){
			node.left = remove(node.left ,e);
		}
		else if (e.compareTo(node.e)>0){
			node.right = remove(node.right , e);
		}
		else{ //e == node.e
			if (node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size-- ;
				return rightNode;
			}
			if (node.right == null){
				Node leftNode = node.left;
				node.left = null;
				size-- ;
				return leftNode;
			}
			//待删除节点左右子树均不为空的情况
			//找到比待删除节点大的最小节点
			//用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left = node.right = null;

			return successor;

		}
		return node;
	}

	/**
	 * 删除以node为根的BST中值为e的节点， 递归算法
	 * 返回新的BST的根
	 */
	private Node remove1(Node node, E e){
		if (node == null){
			return null;
		}
		if (e.compareTo(node.e)<0){
			node.left = remove1(node.left , e);
			return node;
		}
		if (e.compareTo(node.e)>0){
			node.right = remove1(node.right ,e);
			return node;
		}
		else {
			if (node.left == null){
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			if (node.right == null){
				Node leftNode = node.left;
				node.left=null;
				size--;
				return leftNode;
			}
			else {
				Node precursor = maximum(node.left);
				precursor.left = removeMax(node.left);
				precursor.right = node.right;
				node.left = node.right =null;
				return precursor;
			}
		}
	}


	private String generateDepthString(int depth) {

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}
}
