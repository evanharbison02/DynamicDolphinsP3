
import java.util.ArrayList;
import java.util.List;

public class Jess {
	public static boolean member (String atm, List<String> lizt) {
		if (lizt == null || lizt.isEmpty()) {
			return false;
		}

		if (atm.equals(lizt.get(0))) {
			return true;
		}

		return member(atm, lizt.subList(1, lizt.size()));
	}

	public static List<Object> intersect (List<String> lizt1, List<String> lizt2) {
		List<Object> listReturn = new ArrayList<Object>();

		if (lizt1 == null || lizt1.isEmpty()) {
			return listReturn;
		}

		Object first = lizt1.get(0);

		if (lizt2.contains(first)) {
			listReturn.add(first);
		}
		
		listReturn.addAll(intersect(lizt1.subList(1, lizt1.size()), lizt2));
		return listReturn;
	}
}
