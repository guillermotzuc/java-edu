package project.excercises.code.tricky;

public class FuntionalInterface01 {

	public static void main(String[] args) {

		MyFunctionalInterface2 lambda = () -> {
		    System.out.println("Executing...");
		};
		
		lambda.execute();
	}

}
