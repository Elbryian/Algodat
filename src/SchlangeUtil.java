/*
 * @author squast2s
 */

public class SchlangeUtil {
	
	static <T> int size(Schlange<T> w0){
        int size = 0;
        Schlange<T> w1 = new SchlangeAlsFeldFix<T>();
        while(!w0.isEmpty()){
                size++;
                w1.insert(w0.remove());
        }
        while (!w1.isEmpty())
                w0.insert(w1.remove());
        return size;
	}

	static <T> void revert(Schlange<T> s) {
	        if(s.isEmpty())
	                return;
	        revert(s, s.remove());
	        }
	
	private static <T> void revert(Schlange<T> s, T e) {
	        if(s.isEmpty()) {
	                s.insert(e);
	                return;
	        }
	        revert(s, s.remove());
	        s.insert(e);
	}
	
	static <T> void append(Schlange<? super T> ziel, Schlange<T> quelle) {
	        Schlange<T> temp =  new SchlangeAlsFeldFix<T>();
	        T e = null;
	        while(!quelle.isEmpty()) {
	                e = quelle.remove();
	                ziel.insert(e);
	                temp.insert(e);
	        }
	        while(!temp.isEmpty())
	                quelle.insert(temp.remove());
	}

}