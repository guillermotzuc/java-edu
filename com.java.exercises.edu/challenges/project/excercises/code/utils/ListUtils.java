package project.excercises.code.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListUtils {

	public static <E extends Comparable<E>> List<E> removeDuplicatesAndOrder(List<E> list){
		
		Set<E> set = new LinkedHashSet<>(list);
		ArrayList<E> arrayList = new ArrayList<>(set);
		Collections.sort(arrayList);
		
		return arrayList;
	}
}
