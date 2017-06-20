/*
 * @author squast2s
 */

public class FeldUtil<T> {

	static <T> void sortMerge(Feld<T> feld, java.util.Comparator<? super T> comp) {
		sortMerge(feld, comp, 0, feld.size());
	}

	static <T> void sortMerge(Feld<T> feld, java.util.Comparator<? super T> comp, int l, int r) {
		if (r - l <= 1) {
			return;
		}

		int m = (l + r) / 2;
		sortMerge(feld, comp, l, m);
		sortMerge(feld, comp, m, r);
		
		FeldFix<T> tfix = new FeldFix<T>(r-l);
		FeldCount<T> tcount = new FeldCount<T>(tfix);
		
		int i = 0;
		int jl = l;
		int jr = m;

		while (jl < m && jr < r) {
			if (comp.compare(feld.get(jl), feld.get(jr)) <= 0) {
				tcount.set(i++, feld.get(jl++));
			} else {
				tcount.set(i++, feld.get(jr++));
			}
		}

		while (jl < m) {
			tcount.set(i++, feld.get(jl++));
		}
		while (jr < r) {
			tcount.set(i++, feld.get(jr++));
		}
		for (int k = 0; k < tcount.size(); ++k) {
			feld.set(l + k, tcount.get(k));
		}
	}

}
