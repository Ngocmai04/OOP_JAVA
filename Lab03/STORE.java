package Lab03;

import java.util.LinkedList;

public class STORE {

	public class Store {
		private LinkedList<DigitalVdDisc> itemsInStore = new LinkedList<DigitalVdDisc>();

	public boolean checkDVDs(DigitalVdDisc disc) {
		for(DigitalVdDisc digitalVdDisc: itemsInStore){
			if(digitalVdDisc.equals(disc)) return true;
		}
		return false;
	}

	public void removeDVD(DigitalVdDisc disc) {
		if(checkDVDs(disc)){
			itemsInStore.remove(disc);
			System.out.println("have deleted");
		}
		else {
			System.out.println("Not found");
		}
	}

	public void addDVDs(DigitalVdDisc disc) {
		if(checkDVDs(disc)){
			itemsInStore.add(disc);
			System.out.println("have added");
		}
		else{
			System.out.print("Exists!!!");
		}
	}
}
}


