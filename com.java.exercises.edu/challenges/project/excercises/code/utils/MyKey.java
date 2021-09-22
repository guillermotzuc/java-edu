package project.excercises.code.utils;

public class MyKey {

	private String name;
	private int id;

	public MyKey(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// standard getters and setters

	@Override
	public int hashCode() {
		System.out.println("Calling hashCode()");
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		
		System.out.println("Calling equals:" + obj);
		
		if(obj instanceof MyKey) {
			
			MyKey key = (MyKey)obj;
			return key.id == this.id && key.name.equals(this.name);
		}
		
		return false;
	}

	@Override
	public String toString() {
		
		return String.format("{ id: %s , name: %s }", this.id, this.name);
	}
}
