package car.producer.game;

import java.util.Random;

public class RandomUserFactory {

	private static String[] locations = new String[] {
			"Argentina",
			"Bolivia",
			"Brasil",
			"Chile",
			"Mexico",
			"Austria",
			"Estonia",
			"Francia",
			"Italia",
			"Alemania"
	};
	
	public static GameUser newUser() {
		
		Random rand = new Random();
		int randomNum = rand.nextInt((9 - 1) + 1) + 1;
		
		return new GameUser(randomNum, "user" + randomNum, locations[randomNum]);
	}
}
