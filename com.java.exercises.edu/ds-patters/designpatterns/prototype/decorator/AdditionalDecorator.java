package designpatterns.prototype.decorator;

public abstract class AdditionalDecorator implements Beverage {
	
	protected Beverage additionalIngredient;

	public AdditionalDecorator(Beverage additionalIngredient) {
		
		this.additionalIngredient = additionalIngredient;
	}
}
