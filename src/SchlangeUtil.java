/*
 * @author squast2s
 */

public class SchlangeUtil {

	public static <T> void sortMerge(Schlange<T> s, java.util.Comparator<? super T> comp) {
		if (s.isEmpty()) {
			return;
		}

		T e = s.remove();
		if (s.isEmpty()) {
			s.insert(e);
			return;
		}
		
		SchlangeAlsEVL<T> stmp1 = new SchlangeAlsEVL<T>();
		SchlangeAlsEVL<T> stmp2 = new SchlangeAlsEVL<T>();
		stmp1.insert(e);

		while (!s.isEmpty()) {
			stmp2.insert(s.remove());
			if (!s.isEmpty()) {
				stmp1.insert(s.remove());
			}
		}
		sortMerge(stmp1, comp);
		sortMerge(stmp2, comp);

		while (!stmp1.isEmpty() && !stmp2.isEmpty()) {
			if (comp.compare(stmp1.element(), stmp2.element()) <= 0) {
				s.insert(stmp1.remove());
			} else {
				s.insert(stmp2.remove());
			}
		}

		while (!stmp1.isEmpty()) {
			s.insert(stmp1.remove());
		}
		
		while (!stmp2.isEmpty()) {
			s.insert(stmp2.remove());
		}
	}

}