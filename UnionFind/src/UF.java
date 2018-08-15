
/*
 * Created by wxn
 * 2018/8/15 8:02
 */


public interface UF {
	int getSize();
	boolean isConnected(int p , int q);
	void unionElement(int p, int q);
}
