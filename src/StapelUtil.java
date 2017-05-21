/*
 * @author squast2s
 */

public class StapelUtil<T> {

	static <T> int size(Stapel<T> s) {
		int size = 0;
		final Stapel<T> w1 = new StapelAlsFeldFix<T>();
		while (!s.isEmpty()) {
			size++;
			w1.insert(s.remove());
		}
		while (!w1.isEmpty()) {
			s.insert(w1.remove());
		}
		return size;
	}

	public static <T> void revert(Stapel<T> s) {

		Schlange<T> s1 = new SchlangeAlsFeldFix<T>();

		while (!s.isEmpty())
			s1.insert(s.remove());

		while (!s1.isEmpty())
			s.insert(s1.remove());

	}

	static <T> void append(Stapel<? super T> ziel, Stapel<T> quelle) {
		final Stapel<T> temp = new StapelAlsFeldFix<T>();

		while (!quelle.isEmpty()) {
			temp.insert(quelle.remove());
		}

		while (!temp.isEmpty()) {
			T elem = temp.remove();
			quelle.insert(elem);
			ziel.insert(elem);

		}
	}

}
