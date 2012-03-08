package ca.drusk.flightmanager.shared.utils;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

/**
 * Tests for collection utilities.
 * 
 * @author drusk
 * 
 */
public class CollectionUtilsTest {

	private static final String ONE = "1";

	private static final String TWO = "2";

	private static final String THREE = "3";

	@Test
	public void keyListReturnedInInsertionOrder() {
		LinkedHashMap<String, String> linkedMap = new LinkedHashMap<String, String>();
		linkedMap.put(TWO, "two");
		linkedMap.put(ONE, "one");
		linkedMap.put(THREE, "three");
		List<String> keyList = CollectionUtils.getKeyList(linkedMap);
		assertTrue(keyList.get(0).equals(TWO));
		assertTrue(keyList.get(1).equals(ONE));
		assertTrue(keyList.get(2).equals(THREE));
	}

}
