package atc.model;

import atc.model.enums.RequestType;

/**
 * Holds the objects for the item queue request.
 * @author Nick Capone
 *
 */
public class QueueRequest {
	private Aircraft aircraft;
	private RequestType requestType;

	public QueueRequest(RequestType requestType, Aircraft aircraft) {
		this.requestType = requestType;
		this.aircraft = aircraft;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	
	@Override
	public String toString() {
		return this.requestType.toString()
				.concat(" ")
				.concat(this.aircraft != null ? this.aircraft.toString() : "");
	}
}
