package car.producer.game;

public class GameUser {

	public final int id;
	public final String name;
	public final String location;
	
	public GameUser(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	};
}
