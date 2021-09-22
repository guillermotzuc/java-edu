package com.design.patterns.java.singleton.proxy.dynamic;

import java.lang.reflect.Proxy;

public class DynamicLoggingProxyDemo {
	
	@SuppressWarnings("unchecked")
	public static <T> T withLogging(T target, Class<T> itf)
	{
		return (T) Proxy.newProxyInstance(
				itf.getClassLoader(),
				new Class<?>[] { itf },
				new LoggingHandler(target));
	}

	public static void main(String[] args)
	{
		Person person = new Person();
		Human logged = withLogging(person, Human.class);
		logged.walk();
		logged.talk();
		logged.talk();

		System.out.println(logged);
	}
}
