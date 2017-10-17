import java.util.Comparator;

public class CmpByAddress implements Comparator<Person> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Person o1, Person o2) {
		int retVal = o1.getAddress().compareTo(o2.getAddress());
//		if (retVal != 0) 
		return retVal;
//		return o1.getName().compareTo(o2.getName());
		
	}

}
