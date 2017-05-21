/*
 * @author squast2s
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class FeldUtil {
	public static <T> void zipGeordnet(Feld<? super Paar<T, T>> ziel, Feld<? extends T> quelle1,
			Feld<? extends T> quelle2, Comparator<? super T> comp) throws ArrayIndexOutOfBoundsException {
		List<Paar<T, T>> tmpFeld = new ArrayList<Paar<T, T>>();
		T o1;
		T o2;
		for (int i = 0; i < ziel.size(); i++) {
			o1 = quelle1.get(i);
			o2 = quelle2.get(i);
			Paar<T, T> tmpPaar = new Paar<>(o1, o1);
			if (comp.compare(o1, o2) <= 0)
				tmpPaar.setZweites(o2);
			else
				tmpPaar.setErstes(o2);
			tmpFeld.add(tmpPaar);
		}
		for (int i = 0; i < ziel.size(); i++) {
			Paar<T, T> pt = tmpFeld.get(i);
			ziel.set(i, pt);
		}
	}
}
