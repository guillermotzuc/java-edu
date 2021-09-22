package com.design.patterns.java.command.command.interpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.design.patterns.java.command.interpreter.ExpressionProcessor;

/**
 * See ANTLR
 * https://www.antlr.org/
 * @author guillermoMac
 *
 */
public class Evaluate {

	@Test
	public void test()
	{
		ExpressionProcessor ep = new ExpressionProcessor();
		ep.variables.put('x', 5);

		assertEquals(1, ep.calculate("1"));
		assertEquals(3, ep.calculate("1+2"));
		assertEquals(6, ep.calculate("1+x"));
		assertEquals(0, ep.calculate("1+xy"));
	}
}
