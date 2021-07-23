package atc.model;

import java.time.LocalDateTime;

/**
 * Holds the data for the objects in the queue.
 * @author Nick Capone
 *
 */
public class QueueItem {
	private Aircraft aircraft;
	private LocalDateTime insertedTime;

	public QueueItem(Aircraft ac, LocalDateTime insertedTime) {
		this.aircraft = ac;
		this.insertedTime = insertedTime;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public LocalDateTime getInsertedTime() {
		return insertedTime;
	}

	public void setInsertedTime(LocalDateTime insertedTime) {
		this.insertedTime = insertedTime;
	}

	@Override
	public String toString() {
		return this.aircraft.toString().concat(" ").concat(this.insertedTime.toString());
	}

}
