package com.design.patterns.java.chainresponsability;

public class Goblin extends Creature {

	protected Goblin(Game game, int baseAttack, int baseDefense)
	  {
	    super(game, baseAttack, baseDefense);
	  }

	  public Goblin(Game game)
	  {
	    super(game, 1, 1);
	  }

	  @Override
	  public int getAttack()
	  {
	    StatQuery q = new StatQuery(Statistic.ATTACK);
	    for (Creature c : game.creatures)
	      c.query(this, q);
	    return q.result;
	  }

	  @Override
	  public int getDefense()
	  {
	    StatQuery q = new StatQuery(Statistic.DEFENSE);
	    for (Creature c : game.creatures)
	      c.query(this, q);
	    return q.result;
	  }

	  @Override
	  public void query(Object source, StatQuery sq)
	  {
	    if (source == this)
	    {
	      switch (sq.statistic)
	      {
	        case ATTACK:
	          sq.result += baseAttack;
	          break;
	        case DEFENSE:
	          sq.result += baseDefense;
	          break;
	      }
	    }
	    else if (sq.statistic == Statistic.DEFENSE)
	    {
	      sq.result++;
	    }
	  }
}
