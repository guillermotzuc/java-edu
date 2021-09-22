package project.excercises.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import project.excercises.code.utils.ListUtils;

public class ListUtilsTest {

	@Test
	public void givenStringThenRemoveDuplicates() {
		
		List<String> input = new ArrayList<>();
		input.add("c");
		input.add("b");
		input.add("b");
		input.add("d");
		input.add("c");
		input.add("a");
		
		List<String> result = ListUtils.removeDuplicatesAndOrder(input);
		assertEquals("[a, b, c, d]", result.toString());
	}
}
