
import java.util.ArrayList;
import java.util.List;

public class Jess {
	public static boolean member (String atm, List<String> lizt) {
		if (lizt == null || lizt.isEmpty()) { //checks if the list is empty and returns false 
			return false;
		}

		if (atm.equals(lizt.get(0))) { // checks if element at index zero is equal to the value of atm and will return true if met 
			return true;
		}

		return member(atm, lizt.subList(1, lizt.size())); // returns call call to member with a sub list of lizt with the first element removed 
	}

	public static List<Object> intersect (List<String> lizt1, List<String> lizt2) {
		List<Object> listReturn = new ArrayList<Object>(); // creates a new list to be returned 

		if (lizt1 == null || lizt1.isEmpty()) { //checks if the list is empty and returns new list
			return listReturn;
		}

		Object first = lizt1.get(0); // gets the object from lizt1 at index zero

		if (lizt2.contains(first)) { // will add the Object first to the returning list if lizt2 contains the first element in lizt1 
			listReturn.add(first);
		}
		
		listReturn.addAll(intersect(lizt1.subList(1, lizt1.size()), lizt2)); // will add all the intersecting elements that remain in lizt1 recursively 
		return listReturn;
	}
}
