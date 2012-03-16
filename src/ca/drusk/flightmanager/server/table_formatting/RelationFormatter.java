package ca.drusk.flightmanager.server.table_formatting;

import ca.drusk.flightmanager.client.data.Relation;

/**
 * Applies formatting to a {@link Relation}.
 * 
 * @author drusk
 * 
 */
public class RelationFormatter {

	private HourMinuteFormatter formatter = new HourMinuteFormatter();
	private final Relation relation;

	public RelationFormatter(Relation relation) {
		this.relation = relation;
	}

	// public Relation formatField(String... fieldNames) throws ParseException {
	// DefaultRelation formattedRelation = new DefaultRelation(relation
	// .getColumnNames().toArray(new String[0]));
	// for (Row row : relation.getRows()) {
	// for (String field : fieldNames) {
	// String value = row.getValue(fieldNames);
	// formatter.formatTime(value);
	// }
	// formattedRelation.add(row);
	// }
	// return formattedRelation;
	// }

}
