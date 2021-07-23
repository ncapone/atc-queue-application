package atc.model;

import atc.model.enums.Size;
import atc.model.enums.Type;

/**
 * Holds the objects for the aircraft parameters.
 * @author Nick Capone
 *
 */
public class Aircraft {
	private Size size;
	private Type type;

	public Aircraft(Size size, Type type) {
		this.size = size;
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return size.toString()
				.concat(" ")
				.concat(type.toString())
				.concat(" ")
				.concat("PRIORITY " + this.getAircraftPriority());
	}

	public int getAircraftPriority() {

		return this.getSize().priority + this.getType().priority;
	}
}
