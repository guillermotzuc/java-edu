package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

class CustFilter extends DoFn<String, String>{

	@ProcessElement
	public void processElement(ProcessContext c) {

		String line = c.element();
		String[] arr= line.split(",");

		if(arr[3].equals("Los Angeles")) {

			c.output(line);
		}
	}
}

public class PartDoExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> input = 
				p.apply(TextIO.read().from("./src/main/resources/customer_pardo.csv"));
		
		PCollection<String> result = input.apply(ParDo.of(new CustFilter()));
		result.apply(TextIO.write().to("./src/main/resources/pardo.csv")
				.withHeader("id,name,last,city")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
