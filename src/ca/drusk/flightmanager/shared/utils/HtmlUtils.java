package ca.drusk.flightmanager.shared.utils;

/**
 * Contains utility methods for adding HTML content.
 * 
 * @author drusk
 * 
 */
public class HtmlUtils {

	/**
	 * 
	 * @param text
	 *            input text
	 * @return the input text surrounded by HTML bold tag
	 */
	public static String toBold(String text) {
		return "<b>" + text + "</b>";
	}

	/**
	 * 
	 * @param text
	 *            input text
	 * @return the input text surrounded by HTML italics tag
	 */
	public static String toItalics(String text) {
		return "<i>" + text + "</i>";
	}

}
