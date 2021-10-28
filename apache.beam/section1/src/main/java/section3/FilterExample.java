package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.SerializableFunctions;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.PCollection;

class MyFilter implements SerializableFunction<String, Boolean>{

	@Override
	public Boolean apply(String input) {

		String[] arr= input.split(",");
		return arr[3].equals("Los Angeles");
	}
	
	
}

public class FilterExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> input = 
				p.apply(TextIO.read().from("./src/main/resources/customer_pardo.csv"));
		
		PCollection<String> result = input.apply(Filter.by(new MyFilter()));

	}

}
