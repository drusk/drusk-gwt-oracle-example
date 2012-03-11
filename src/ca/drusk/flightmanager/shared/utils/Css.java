package ca.drusk.flightmanager.shared.utils;

/**
 * Contains css constants and methods for working with them.
 * 
 * @author drusk
 * 
 */
public final class Css {

	public static final String PX = "px";

	/**
	 * 
	 * @return <code>size</code> as a string in pixels
	 */
	public static String inPixels(int size) {
		return size + PX;
	}

}
