
/*
 * Created by wxn
 * 2018/8/15 8:07
 */

/**
 * Quick Find
 */
public class UnionFind1 implements UF {

	private int[] id;

	public UnionFind1(int size){
		id = new int[size];

		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	@Override
	public int getSize() {
		return id.length;
	}

	/**
	 * O(1)复杂度
	 **/
	@Override
	public boolean isConnected(int p, int q) {
		return find(p)==find(q);
	}

	/**
	 * O(n)复杂度
	 **/
	@Override
	public void unionElement(int p, int q) {

		int pId = find(p);
		int qId = find(q);

		if (pId==qId) {
			return;
		}
		for (int i = 0; i < id.length; i++) {
			if (id[i]==pId)
				id[i] = qId;
		}
	}

	/**
	 * 查找元素p对应的集合编号
	 */
	private int find(int p){
		if (p<0 || p>=id.length){
			throw new IllegalArgumentException("p is out of bound!");
		}
		return id[p];
	}
}
