package termProject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EventDatabase {
	private static EventDatabase instance;
	private List<Event> events;
	private List<Leave> leaves;
	private List<Integer> retires;
	
	private EventDatabase() {
		this.events = new LinkedList<Event>();
		this.leaves = new LinkedList<Leave>();
		this.retires = new LinkedList<Integer>();
	}
	
	// Singleton pattern
	public static EventDatabase getInstance() {
		if (instance == null)
			instance = new EventDatabase();
		return instance;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	public List<Leave> getLeaves() {
		return leaves;
	}
	
	public List<Leave> getLeaveByEmployee (Employee emp) {
		LinkedList<Leave> result = new LinkedList<Leave>();
		Iterator<Leave> it = leaves.iterator();
		while (it.hasNext()) {
			Leave tmp = it.next();
			if ((tmp.getEmp()).equals(emp)) result.add(tmp);
		}
		return result;
	}
	
	public void addEvent (Event event) {
		events.add(event);
	}
	
	public void addLeave (Leave leave) {
		leaves.add(leave);
	}
	
	public void delLeave (Employee emp) {
		Iterator<Leave> it = leaves.iterator();
		while (it.hasNext()) {
			Leave tmp = it.next();
			if ((tmp.getEmp()).equals(emp)) it.remove();
		}
	}
	
	public boolean setRetire (Integer empid) {
		if (retires.contains(empid)) return false;
		retires.add(empid);
		return true;
	}
	
	public List<Integer> getRetires () {
		return retires;
	}
	
	public void delRetire (Integer empid) {
		retires.remove(empid);
	}
}
