package com.design.patterns.java.command.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.design.patterns.java.command.Account;
import com.design.patterns.java.command.Command;
public class CommandTest {

	@Test
	public void test()
	{
		Account a = new Account();

		Command command = new Command(Command.Action.DEPOSIT, 100);
		a.process(command);

		assertEquals(100, a.balance);
		assertTrue(command.success);

		command = new Command(Command.Action.WITHDRAW, 50);
		a.process(command);

		assertEquals(50, a.balance);
		assertTrue(command.success);

		command = new Command(Command.Action.WITHDRAW, 150);
		a.process(command);

		assertEquals(50, a.balance);
		assertFalse(command.success);
	}
}
