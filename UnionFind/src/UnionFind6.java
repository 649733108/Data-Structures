
/*
 * Created by wxn
 * 2018/8/15 8:52
 */


public class UnionFind6 implements UF {

	private int[] parent;
	private int[] rank; //rank[i]表示以i为根的集合所表示的树的深度

	public UnionFind6(int size) {
		parent = new int[size];
		rank = new int[size];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	@Override
	public int getSize() {
		return parent.length;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	/**
	 * 合并p，q
	 * 复杂度O（h）
	 */
	@Override
	public void unionElement(int p, int q) {

		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot) {
			return;
		}

		if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot;
		} else if (rank[qRoot] < rank[pRoot]) {
			parent[qRoot] = pRoot;
		} else {
			parent[pRoot] = qRoot;
			rank[qRoot] += 1;
		}


	}

	/**
	 * 查找过程，查找元素p所对应的集合编号
	 * O（h）复杂度，h为树的高度
	 */
	private int find(int p) {
		if (p < 0 || p >= parent.length) {
			throw new IllegalArgumentException("p is out of bound!");
		}
		if (p != parent[p]) {
			parent[p] = find(parent[p]);
		}
		return parent[p];
	}
}
