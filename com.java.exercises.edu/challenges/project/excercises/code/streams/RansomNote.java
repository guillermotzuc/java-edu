package project.excercises.code.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class RansomNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isRansomeNote("money rescue delay money money rescue", "magazine number money rescue date delay money rescue money interest money delay way"));
		System.out.println(isRansomeNote("money rescue delay money money rescue", "magazine number money rescue date delay money rescue interest delay way" ));

	}

	/**
	 * Case: 1
	 * "money rescue delay money money rescue", 
	 * "magazine number money rescue date delay money rescue money interest money delay way" true
	 * 
	 * Case 2
	 * "money rescue delay money money rescue", 
	 * "magazine number money rescue date delay money rescue interest delay way" false
	 * 
	 * 
	 * @param words
	 * @param magazineWords
	 * @return
	 */
	static boolean isRansomeNote(String words, String magazineWords) {
		
		Map<String, Long> wordsCount = convertWordsListToMap(words);
		Map<String, Long> magazineWordsCount = convertWordsListToMap(magazineWords);
		
		BiPredicate<String, Long> canBeUsedOnNote = (k,count) -> {

			return !(!magazineWordsCount.containsKey(k) || wordsCount.get(k) > magazineWordsCount.get(k));
		};
		
		return wordsCount.entrySet()
				.stream()
				.allMatch((entry) -> {
					
					return canBeUsedOnNote.test(entry.getKey(), entry.getValue()); 
				});
			
	}
	
	static Map<String, Long> convertWordsListToMap(String words) {
	
		return Arrays.stream(words.split("\\ "))
				.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
	}
}
