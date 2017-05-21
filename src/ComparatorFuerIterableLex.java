/*
 * @author squast2s
 */

import java.util.Comparator;
import java.util.Iterator;

public class ComparatorFuerIterableLex<T extends Comparable<T>> implements Comparator<Iterable<? extends T>> {
	
	public int compare(Iterable<? extends T> o1, Iterable<? extends T> o2) {
			int result = 0;
		Iterator<? extends T> i1 = o1.iterator();
		Iterator<? extends T> i2 = o2.iterator();

		while (i1.hasNext() && i2.hasNext()) {
			result = i1.next().compareTo(i2.next());
			if (result != 0)
				return result;
		}
		if (i1.hasNext())
			return 1;
		if (i2.hasNext())
			return -1;
		return result;
	}

}
