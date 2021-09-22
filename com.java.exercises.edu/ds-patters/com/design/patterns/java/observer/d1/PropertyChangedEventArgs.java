package com.design.patterns.java.observer.d1;

public class PropertyChangedEventArgs<T> {

	public T source;
	public String propertyName;
	public Object newValue;

	public PropertyChangedEventArgs(T source, String propertyName,
			Object newValue)
	{
		this.source = source;
		this.propertyName = propertyName;
		this.newValue = newValue;
	}
}
