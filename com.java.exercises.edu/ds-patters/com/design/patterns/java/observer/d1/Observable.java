package com.design.patterns.java.observer.d1;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

	private List<Observer<T>> observers = new ArrayList<>();

	public void subscribe(Observer<T> observer)
	{
		observers.add(observer);
	}

	protected void propertyChanged(T source,
			String propertyName,
			Object newValue)
	{
		for (Observer<T> o : observers)
			o.handle(new PropertyChangedEventArgs<T>(
					source, propertyName, newValue
					));
	}
}
