
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Matt {
	public static List<Object> append (List<String> lizt1, List<String> lizt2) {
		if (lizt1 == null || lizt2 == null) return null; //checks if both lists are empty and will return null 
		
		List<Object> listReturn = new ArrayList<Object>(); // create a new list to be returned 
		
		for (Object obj: lizt1) listReturn.add(obj); // loops though each object in the list and adds each to the new list
		for (Object obj: lizt2) listReturn.add(obj);
		
		return listReturn;
	}

	public static List<Object> map (Function<Integer,Integer> function, List<Integer> lizt) {
		if (function == null || lizt == null) return null; // checks if both are empty
		
		List<Object> listReturn = new ArrayList<Object>(); // creates a new list to be returned 
		
		for (Integer num: lizt) { // loops though the elements in lizt and adds the element applied by function the returned list
			listReturn.add(function.apply(num)); 
		} 
		return listReturn;
	}

	public static boolean same (List<Integer> liztA, List<Integer> liztB) {
		if (liztA == null || liztB == null) { //checks if one of the lists are empty 
			if (liztA == null && liztB == null) return true; // checks if both are empty and will return true or false if condition is not met
			return false;
		}
		
		if (liztA.size() != liztB.size()) return false; // checks if both lists are not the same size and returns false 
		
		for (int i = 0; i < liztA.size(); i++) { // loops though each element in both list and checks if they are the same
			if (liztA.get(i) != (liztB.get(i))) return false;
		}
		return true; // returns true if both lists are the same 
	}
	
}
