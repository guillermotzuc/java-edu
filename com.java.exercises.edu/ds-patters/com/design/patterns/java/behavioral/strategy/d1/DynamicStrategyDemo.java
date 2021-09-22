package com.design.patterns.java.behavioral.strategy.d1;

import java.util.Arrays;

public class DynamicStrategyDemo {

	public static void main(String[] args)
	{
		TextProcessor<MarkdownListStrategy> tp = new TextProcessor<>(
				MarkdownListStrategy::new);
		
		tp.appendList(Arrays.asList("liberte", "egalite", "fraternite"));
		System.out.println(tp);

		TextProcessor<HtmlListStrategy> tp2 = new TextProcessor<>(HtmlListStrategy::new);
		tp2.appendList(Arrays.asList("liberte", "egalite", "fraternite"));
		System.out.println(tp2);
	}
}
