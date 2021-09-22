package project.excercises.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import project.excercises.code.utils.MyKey;

public class MapCollition {

	@Test
	public void whenCallsEqualsOnCollision_thenCorrect() {
		HashMap<MyKey, String> map = new HashMap<>();
		MyKey k1 = new MyKey(1, "firstKey");
		MyKey k2 = new MyKey(2, "secondKey");
		MyKey k3 = new MyKey(2, "thirdKey");

		System.out.println("storing value for k1");
		map.put(k1, "firstValue");
		System.out.println("storing value for k2");
		map.put(k2, "secondValue");
		System.out.println("storing value for k3");
		map.put(k3, "thirdValue");

		System.out.println("retrieving value for k1");
		String v1 = map.get(k1);
		System.out.println("retrieving value for k2");
		String v2 = map.get(k2);
		System.out.println("retrieving value for k3");
		String v3 = map.get(k3);

		assertEquals("firstValue", v1);
		assertEquals("secondValue", v2);
		assertEquals("thirdValue", v3);
	}
}
