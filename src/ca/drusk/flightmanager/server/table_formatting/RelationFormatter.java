package ca.drusk.flightmanager.server.table_formatting;

import java.text.ParseException;

import ca.drusk.flightmanager.client.data.DefaultRelation;
import ca.drusk.flightmanager.client.data.Relation;
import ca.drusk.flightmanager.client.data.Row;

/**
 * Applies formatting to a {@link Relation}.
 * 
 * @author drusk
 * 
 */
public class RelationFormatter {

	private DefaultTimeFormatter formatter = new DefaultTimeFormatter();

	private final Relation relation;

	public RelationFormatter(Relation relation) {
		this.relation = relation;
	}

	public Relation formatField(String... fieldNames) throws ParseException {
		DefaultRelation formattedRelation = new DefaultRelation(relation
				.getColumnNames().toArray(new String[0]));
		for (Row row : relation.getRows()) {
			for (String field : fieldNames) {
				String value = row.getValue(field);
				String formattedTime = formatter.formatTime(value);
			}
			formattedRelation.add(row);
		}
		return formattedRelation;
	}

}
