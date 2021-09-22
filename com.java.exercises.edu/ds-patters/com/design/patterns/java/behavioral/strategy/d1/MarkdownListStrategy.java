package com.design.patterns.java.behavioral.strategy.d1;

public class MarkdownListStrategy implements ListStrategy {

	  @Override
	  public void addListItem(StringBuilder stringBuilder, String item)
	  {
	    stringBuilder.append(" * ").append(item)
	      .append(System.lineSeparator());
	  }

}
