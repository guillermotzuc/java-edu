package designpatterns.decorator;

public class Milk extends AdditionalDecorator {

	public Milk(Beverage additionalIngredient) {
		
		super(additionalIngredient);
	}

	@Override
	public double cost() {

		return this.additionalIngredient.cost() + .80;
	}

	@Override
	public String description() {

		return this.additionalIngredient.description() + "," + "Milk";
	}

}
