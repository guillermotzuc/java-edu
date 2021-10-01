package designpatterns.prototype.decorator;

public class DecoratorTest {

	public static void main(String[] args) {

		Beverage beverage = new Expresso();
		System.out.println(beverage.description() + " $" + beverage.cost());
		
		beverage = new Milk(beverage);
		System.out.println(beverage.description() + " $" + beverage.cost());

	}

}
