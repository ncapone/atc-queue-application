package atc.model.enums;

/**
 * Enum for the aircraft type. Each type has
 * an integer value associated with it to use
 * for comparison. Higher value == greater priority.
 * @author Nick Capone
 *
 */
public enum Type {
	PASSENGER(2), CARGO(1);

	public final int priority;

	private Type(int priority) {
		this.priority = priority;
	}
}
