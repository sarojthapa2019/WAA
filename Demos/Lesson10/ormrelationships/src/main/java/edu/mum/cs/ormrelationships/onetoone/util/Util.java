package edu.mum.cs.ormrelationships.onetoone.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static <T> List<T> iterableToCollection(Iterable<T> iterable) {
		List<T> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		return collection;
	}

}
