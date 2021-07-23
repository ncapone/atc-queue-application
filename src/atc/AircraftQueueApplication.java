package atc;

import java.util.ArrayList;
import java.util.List;

import atc.model.Aircraft;
import atc.model.QueueRequest;
import atc.model.enums.RequestType;
import atc.model.enums.Size;
import atc.model.enums.Type;
import atc.service.AircraftQueueManager;

/** 
 * Contains the main method used for demonstration. Normally
 * there would be some kind of user interface to do this but
 * for demo purposes we mock up some requests to send to the AircraftQueueManager.
 * 
 * @author Nick Capone
 *
 */
public class AircraftQueueApplication {

	public static void main(String[] args) {
		// build aircraft objects to use in request tests
		Aircraft ac1 = new Aircraft(Size.LARGE, Type.PASSENGER);
		Aircraft ac2 = new Aircraft(Size.SMALL, Type.PASSENGER);
		Aircraft ac3 = new Aircraft(Size.LARGE, Type.CARGO);
		Aircraft ac4 = new Aircraft(Size.SMALL, Type.CARGO);
		Aircraft ac5 = new Aircraft(Size.LARGE, Type.PASSENGER);
		
		// instantiate Aircraft Queue Manager
		AircraftQueueManager aqm = new AircraftQueueManager();

		// boot system
		QueueRequest startRequest = new QueueRequest(RequestType.SYSTEM_START, null);

		// enqueue all of our aircraft
		QueueRequest enqueueAc1 = new QueueRequest(RequestType.ENQUEUE, ac1);
		QueueRequest enqueueAc2 = new QueueRequest(RequestType.ENQUEUE, ac2);
		QueueRequest enqueueAc3 = new QueueRequest(RequestType.ENQUEUE, ac3);
		QueueRequest enqueueAc4 = new QueueRequest(RequestType.ENQUEUE, ac4);
		QueueRequest enqueueAc5 = new QueueRequest(RequestType.ENQUEUE, ac5);
		
		
		List<QueueRequest> requests = new ArrayList<>();
		requests.add(startRequest);
		
		// simulate enqueue requests
		requests.add(enqueueAc3);
		requests.add(enqueueAc1);
		requests.add(enqueueAc2);
		requests.add(enqueueAc4);
		requests.add(enqueueAc5);
		
		QueueRequest dequeueAc1 = new QueueRequest(RequestType.DEQUEUE, null);	
		
		// simulate dequeue requests
		requests.add(dequeueAc1);
		requests.add(dequeueAc1);
		requests.add(dequeueAc1);
		requests.add(dequeueAc1);
		requests.add(dequeueAc1);
		
		/*
		 * Restarting the system and adding a couple
		 * of aircraft to see how the queue is handled.
		 */
		
		requests.add(startRequest);
		requests.add(enqueueAc1);
		requests.add(enqueueAc2);
		requests.add(enqueueAc3);

		aqm.aqmRequestProcess(requests);
	}
}
