package com.design.patterns.java.command;

public class Account {
	
	public int balance;

	public void process(Command c)
	{
		switch (c.action)
		{
		case DEPOSIT:
			balance += c.amount;
			c.success = true;
			break;
		case WITHDRAW:
			c.success = balance >= c.amount;
			if (c.success) balance -= c.amount;
			break;
		}
	}
}
