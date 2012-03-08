package ca.drusk.flightmanager.shared.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * General purpose methods for collections.
 * 
 * @author drusk
 * 
 */
public class CollectionUtils {

	/**
	 * Returns the keys from the map as a list. Most useful if the map's keys
	 * are ordered, for instance if it is a <code>LinkedHashMap</code>.
	 * 
	 * @param map
	 * @return
	 */
	public static <T, U> List<T> getKeyList(LinkedHashMap<T, U> linkedMap) {
		List<T> keyList = new ArrayList<T>();
		for (T key : linkedMap.keySet()) {
			keyList.add(key);
		}
		return keyList;
	}

}
