package com.design.patterns.java.observer.d1;

public interface Observer<T> {

	void handle(PropertyChangedEventArgs<T> args);
}
