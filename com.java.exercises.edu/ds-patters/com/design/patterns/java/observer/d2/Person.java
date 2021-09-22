package com.design.patterns.java.observer.d2;

public class Person {

	public Event<PropertyChangedEventArgs>
	propertyChanged = new Event<>();

	private int age;

	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		if (this.age == age) return;

		boolean oldCanVote = getCanVote();

		this.age = age;
		propertyChanged.fire(new PropertyChangedEventArgs(
				this, "age"
				));

		if (oldCanVote != getCanVote())
		{
			propertyChanged.fire(new PropertyChangedEventArgs(
					this, "canVote"
					));
		}
	}

	public boolean getCanVote()
	{
		return age >= 18;
	}

}
