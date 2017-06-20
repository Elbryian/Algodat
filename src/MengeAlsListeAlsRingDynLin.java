/*
 * @author squast2s
 */

import java.util.NoSuchElementException;

public class MengeAlsListeAlsRingDynLin<T> implements Menge<T> {

	ListeAlsRingDyn<T> list = new ListeAlsRingDyn<T>();

	public int total() {
		return list.total();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public int size() {
		return list.size();

	}

	@Override
	public T element() {
		T v = null;
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		while (v == null) {
			try {
				v = list.get(Math.round((float) (Math.random() * size())));
			} catch (IndexOutOfBoundsException e) {

			}
		}
		return v;
	}

	@Override
	public boolean contains(T e) {
		return IterableUtil.sucheLinear(list, e) >= 0 ? true : false;
	}

	@Override
	public boolean insert(T e) {
		if (contains(e)) {
			return false;
		} else {
			list.insert(size(), e);
		}
		return true;
	}

	@Override
	public boolean remove(T e) {
		if (contains(e)) {
			list.remove(IterableUtil.sucheLinear(list, e));
			return true;
		}
		return false;
	}

}
