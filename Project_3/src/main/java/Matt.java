
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Matt {
	public static List<Object> append (List<String> lizt1, List<String> lizt2) {
		if (lizt1 == null || lizt2 == null) return null;
		List<Object> listReturn = new ArrayList<Object>();
		for (Object obj: lizt1) listReturn.add(obj);
		for (Object obj: lizt2) listReturn.add(obj);
		return listReturn;
	}

	public static List<Object> map (Function<Integer,Integer> function, List<Integer> lizt) {
		if (function == null || lizt == null) return null;
		List<Object> listReturn = new ArrayList<Object>();
		for (Integer num: lizt) { listReturn.add(function.apply(num)); }
		return listReturn;
	}

	public static boolean same (List<Integer> liztA, List<Integer> liztB) {
		if (liztA == null || liztB == null) { 
			if (liztA == null && liztB == null) return true;
			return false;
		}
		if (liztA.size() != liztB.size()) return false;
		for (int i = 0; i < liztA.size(); i++) {
			if (liztA.get(i) != (liztB.get(i))) return false;
		}
		return true;
	}
	
}
