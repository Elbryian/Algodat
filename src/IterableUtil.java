/*
 * @author squast2s
 */

import java.util.Comparator;

public class IterableUtil {
	public static <T> T max2(Iterable<T> seq, Comparator<T> comp) throws IllegalArgumentException {

		try {
			java.util.Iterator<T> iter = seq.iterator();

			T max;
			T max2;
			T tmp;
			max = iter.next();
			max2 = iter.next();

			if (comp.compare(max, max2) < 0) {
				tmp = max;
				max = max2;
				max2 = tmp;
			}

			while (iter.hasNext()) {
				tmp = iter.next();
				if (comp.compare(max, tmp) < 0) {
					max2 = max;
					max = tmp;
				} else if (comp.compare(max2, tmp) < 0) {
					max2 = tmp;
				}
			}

			return max2;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}