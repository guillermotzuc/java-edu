package com.design.patterns.java.observer.d1;

public class Person extends Observable<Person>
{
	private int age;

	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		if (this.age == age) return;
		this.age = age;
		propertyChanged(this, "age", age);
	}
}
