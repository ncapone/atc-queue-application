package atc.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;

import atc.model.Aircraft;
import atc.model.DequeueComparator;
import atc.model.QueueItem;
import atc.model.QueueRequest;
import atc.model.enums.RequestType;

public class AircraftQueueManager {

	Logger log = Logger.getLogger(AircraftQueueManager.class.getName());

	private Queue<QueueItem> itemQueue;

	/**
	 * This method reinitializes the PriorityQueue with each call.
	 * The default size is 11 but it will grow as needed.
	 */
	private void systemStart() {
		log.info("Starting system.");
		Comparator<QueueItem> comparator = new DequeueComparator();
		itemQueue = new PriorityQueue<QueueItem>(11, comparator);
		logQueueSize();
	}

	/**
	 * This method adds the Aircraft to the queue in priority order.
	 * 
	 * @param ac
	 */
	private void enqueueAircraft(Aircraft ac) {
		QueueItem item = new QueueItem(ac, LocalDateTime.now());
		
		try {
			itemQueue.offer(item);
			logQueueSize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method removes the next aircraft from the queue.
	 */
	private void dequeueNextAircraft() {
		if (itemQueue.peek() != null) {
			log.info("Dequeuing " + itemQueue.peek().toString());
		}
		
		try {
			itemQueue.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logQueueSize();
	}

	/**
	 * Handler for the requests sent from the main method. 
	 * 
	 * @param requests
	 */
	public void aqmRequestProcess(QueueRequest request) {
		if (request.getRequestType().equals(RequestType.SYSTEM_START)) {
			log.info("Received request: " + RequestType.SYSTEM_START);
			this.systemStart();
		}

		if (request.getRequestType().equals(RequestType.ENQUEUE)) {
			log.info("Received request: " + request.getAircraft().toString());
			this.enqueueAircraft(request.getAircraft());
		}

		if (request.getRequestType().equals(RequestType.DEQUEUE)) {
			log.info("Received request: " + request);
			this.dequeueNextAircraft();
		}
	}

	private void logQueueSize() {
		try {
			log.info("Current queue size: " + itemQueue.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
