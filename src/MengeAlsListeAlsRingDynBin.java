/*
 * @author squast2s
 */

public class MengeAlsListeAlsRingDynBin<T extends Comparable<T>> implements Menge<T> {

	ListeAlsRingDyn<T> list = new ListeAlsRingDyn<T>();

	public int total() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public T element() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return list.getFirst();
	}

	@Override
	public boolean contains(T e) {
		for (T value : list) {
			if (e.equals(value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insert(T e) {
		if (contains(e)) {
			return false;
		}
		list.insert(FeldUtil.sucheBinaerPos(list, e), e);
		return true;
	}

	@Override
	public boolean remove(T e) {
		if (contains(e)) {
			list.remove(FeldUtil.sucheBinaerPos(list, e));
			return true;
		}
		return false;
	}
}
