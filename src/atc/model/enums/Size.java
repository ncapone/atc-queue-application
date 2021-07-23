package atc.model.enums;

/**
 * Enum for the aircraft size. Each size
 * has an integer value applied to it to use
 * for comparison. Higher value == greater priority.
 * @author Nick Capone
 *
 */
public enum Size {
	LARGE(2), SMALL(1);

	public final int priority;

	private Size(int priority) {
		this.priority = priority;
	}
}
