package com.design.patterns.java.observer.d2;

public class PropertyChangedEventArgs {

	public Object source;
	public String propertyName;

	public PropertyChangedEventArgs(Object source, String propertyName)
	{
		this.source = source;
		this.propertyName = propertyName;
	}
}
