package ca.drusk.flightmanager.shared.utils;

import com.google.gwt.user.client.ui.HTML;

/**
 * Utility class for succinctly applying HTML effects to a string, and either
 * returning the HTML as a string or as an {@link HTML} widget.
 * 
 * @author drusk
 * 
 */
public class HtmlBuilder {

	private String html;

	/**
	 * 
	 * @param text
	 *            the text which HTML formatting tags will be applied to.
	 */
	public HtmlBuilder(String text) {
		this.html = text;
	}

	/**
	 * Wraps the current HTML with the bold tags.
	 * 
	 * @return the <code>HtmlBuilder</code>
	 */
	public HtmlBuilder bold() {
		html = "<b>" + html + "</b>";
		return this;
	}

	/**
	 * Wraps the current HTML with the italics tags.
	 * 
	 * @return the <code>HtmlBuilder</code>
	 */
	public HtmlBuilder italics() {
		html = "<i>" + html + "</i>";
		return this;
	}

	/**
	 * Wraps the current HTML with the underline tags.
	 * 
	 * @return the <code>HtmlBuilder</code>
	 */
	public HtmlBuilder underline() {
		html = "<u>" + html + "</u>";
		return this;
	}

	/**
	 * Returns the string representation of the HTML that has been generated.
	 */
	public String toString() {
		return html;
	}

	/**
	 * 
	 * @return the HTML that has been generated as an {@link HTML} GWT widget.
	 */
	public HTML asHtml() {
		return new HTML(html);
	}

}
