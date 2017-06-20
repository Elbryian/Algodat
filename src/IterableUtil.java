/*
 * @author squast2s
 */

public class IterableUtil {

	public static <T> int sucheLinear(java.lang.Iterable<T> it, T e) {

		java.util.Iterator<T> iter = (it.iterator());
		int pos = 0;
		while (iter.hasNext()) {
			if (iter.next().equals(e)) {
				return pos;
			}
			pos++;

		}
		return -1;
	}

}