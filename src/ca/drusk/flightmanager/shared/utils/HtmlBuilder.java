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

	public HtmlBuilder(String text) {
		this.html = text;
	}

	public HtmlBuilder bold() {
		html = "<b>" + html + "</b>";
		return this;
	}

	public HtmlBuilder italics() {
		html = "<i>" + html + "</i>";
		return this;
	}

	public HtmlBuilder underline() {
		html = "<u>" + html + "</u>";
		return this;
	}

	public String toString() {
		return html;
	}

	public HTML asHtml() {
		return new HTML(html);
	}

}
