package project.excercises.code.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DishTest {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

		/*
		 * A list of String with the names of the dishes which has calories less than 400 and sorted by calory, 
		 * the list will contain the following names:
		 * season fruit, prawns, rice
		 */
		
		Comparator<Dish> sortByCalories = 
				Comparator.comparing(Dish::getCalories);
		
		List<Dish> lessThan400 = menu.stream()
									.filter(d -> d.getCalories() < 400)
									.sorted(sortByCalories)
									.collect(Collectors.toList());
		
		lessThan400.forEach(d -> System.out.println(d.getName()));
		
		/*
		 * A map of Dish Type as key and list of dishes as value, grouped by the Dish Type, 
		 * the map will contain the following entires:
		 */
		Map<Dish.Type,List<String>> group = menu.stream()
											.collect(
													Collectors.groupingBy(Dish::getType, 
												    Collectors.mapping(Dish::getName, Collectors.toList())
												    ));
		
		System.out.println(group);
		
		/*
		 * A list of String with the names of only 3 dishes with calories more than 300, 
		 * the list will contain the following names: pork, beef, chicken
		 */
		menu.stream()
			.filter(d -> d.getCalories() > 300)
			.map(Dish::getName)
			.limit(3)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		/*
		 * A boolean indicating if any of the dishes is vegetarian, in this case the result will be true
		 */
		boolean isVeg = menu.stream()
						.anyMatch(Dish::isVegetarian);
		
		System.out.println(isVeg);
		
		/*
		 * A boolean indicating if all of the dishes are healthy, 
		 * in this case that the calories are less than 1000, in this case the result will be true
		 */
		
		boolean isHealthy = menu.stream()
				.allMatch(d-> d.getCalories() < 1000);
		
		System.out.println(isHealthy);

		/*
		 * An optional of type Dish that contains any dish which is vegetarian,
		 * the value of the optional will be french fries for example
		 */
		menu.stream()
		.filter(d -> d.isVegetarian())
		.findAny() // Optional dish
		.ifPresent(d -> System.out.println(d.getName()));
		
		/*
		 * An integer which is the total sum of the calories for all the dishes, 
		 * in this case the result will be 120
		 */
		int totalCalories = menu.stream()
							.mapToInt(d -> d.getCalories())
							.sum();
		
		System.out.println(totalCalories);
		
		/*
		 * A long with the total count of all the dishes, in this case the result will be 9
		 */
		System.out.println(menu.size());
		
		/*
		 * An optional of type Dish with the dish with the higest calories, 
		 * the value of the optional will be pork for example
		 */
		menu.stream()
		.max(sortByCalories)
		.ifPresent(d -> System.out.println(d.getName()));
		
		/*
		 * A list of Dish, sorted by calories, in this case the list will be:
		 * season fruit, prawns, rice, chicken, salmon, french fries, pizza, beef, pork
		 */
		menu.stream()
		.sorted(sortByCalories)
		.forEach(d -> System.out.println(d.getName()));
		
		/*
		 * A map of Dish Type as key and Long as value, 
		 * grouped by the Dish Type and the value is the count of all dishes for each type, the map will contain the 
			following entires:
			FISH, 2
			MEAT, 3
			OTHER, 4
		 */
		Map<Dish.Type, Long> groupCount = menu.stream()
				.collect(
						Collectors.groupingBy(Dish::getType, 
					    Collectors.counting()
					    ));
		
		System.out.println(groupCount);
		
		/*
		 * Now having a list of String like the example "Java8", "Lambdas", "In", "Action", 
		 * get a list of integers with the length of each String, the list will
			contain the integers:
			5, 7, 2, 6
		 */
		Stream.of("Java8","Lambdas","In","Action")
		.mapToInt(s-> s.length())
		.boxed()
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		/*
		 * Now having a list of String like the example "Hello", "World", get a list of unique characters, which will be a list of String, the list will
		   contain the Strings:
		  "H", "e", "l", "o", "W", "r", "d"
		 */
		List<String> words = new ArrayList<>();
		words.add("Hello");
		words.add("World");
		System.out.println(getUniqueChars(words));
	}
	
	public static List<String> getUniqueChars(List<String> word) {
		
		return word.stream()
				.flatMap(w -> w.codePoints().mapToObj(c -> String.valueOf((char)c)))
				.distinct()
				.collect(Collectors.toList());
	}

}
