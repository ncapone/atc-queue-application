package atc.model;

import java.util.Comparator;

/**
 * Custom comparator used for the PriorityQueue. The values 
 * for each aircraft priority are used as basis for comparison.
 * Returns values in descending order.
 * @author Nick Capone
 *
 */
public class DequeueComparator implements Comparator<QueueItem> {

	@Override
	public int compare(QueueItem o1, QueueItem o2) {
		// if aircraft has general higher type priority
		if ((o1.getAircraft().getType().priority > o2.getAircraft().getType().priority)) {
			return -1;
		} 
		else if ((o2.getAircraft().getType().priority > o1.getAircraft().getType().priority)) {
			return 1;
		} 
		
		// if aircraft are the same type, check if the size priority is higher
		else if ((o1.getAircraft().getType() == o2.getAircraft().getType())
				&& (o1.getAircraft().getSize().priority > o2.getAircraft().getSize().priority)) {
			return -1;
		} 
		else if ((o2.getAircraft().getType() == o1.getAircraft().getType())
				&& (o2.getAircraft().getSize().priority > o1.getAircraft().getSize().priority)) {
			return 1;
		} 
		
		// if aircraft are the same type and size, compare inserted time
		else if ((o1.getAircraft().getType() == o2.getAircraft().getType())
				&& (o1.getAircraft().getSize() == o2.getAircraft().getSize())
				&& o1.getInsertedTime().isBefore(o2.getInsertedTime())) {
			return -1;
		} else if ((o2.getAircraft().getType() == o1.getAircraft().getType())
				&& (o2.getAircraft().getSize() == o1.getAircraft().getSize())
				&& o2.getInsertedTime().isBefore(o1.getInsertedTime())) {
			return 1;
		} 
		// if aircraft are the same, just return
		else if ((o2.getAircraft().getAircraftPriority() == o1.getAircraft().getAircraftPriority())) {
			return 0;
		}

		return 0;
	}
}
