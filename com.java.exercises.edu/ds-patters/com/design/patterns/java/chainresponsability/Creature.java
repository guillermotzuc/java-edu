package com.design.patterns.java.chainresponsability;

public abstract class Creature {

	protected Game game;
	protected int baseAttack, baseDefense;

	public Creature(Game game, int baseAttack, int baseDefense)
	{
		this.game = game;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
	}

	public abstract int getAttack();
	public abstract int getDefense();
	public abstract void query(Object source, StatQuery sq);
}
