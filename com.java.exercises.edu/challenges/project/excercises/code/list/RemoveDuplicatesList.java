package project.excercises.code.list;

import java.util.ArrayList;
import java.util.List;

import project.excercises.code.utils.ListUtils;

public class RemoveDuplicatesList {

	public static void main(String[] args) {

		List<String> input = new ArrayList<>();
		input.add("c");
		input.add("b");
		input.add("b");
		input.add("d");
		input.add("c");
		input.add("a");
		
		List<String> result = ListUtils.removeDuplicatesAndOrder(input);
		System.out.println(result);
		
	}

}
