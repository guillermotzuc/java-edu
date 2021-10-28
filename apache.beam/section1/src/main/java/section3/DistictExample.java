package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Distinct;
import org.apache.beam.sdk.values.PCollection;

public class DistictExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();
		
		PCollection<String> input1 = 
				p.apply(TextIO.read().from("./src/main/resources/Distinct.csv"));
		
		PCollection<String> uniqueInput1 = input1.apply(Distinct.<String>create());
		
		uniqueInput1.apply(TextIO.write().to("./src/main/resources/distict.csv")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
