package com.design.patterns.java.command;

public class Command {

	enum Action
	{
		DEPOSIT, WITHDRAW
	}

	public Action action;
	public int amount;
	public boolean success;

	public Command(Action action, int amount)
	{
		this.action = action;
		this.amount = amount;
	}
}
