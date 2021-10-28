package section1;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.values.PCollection;

public class LocalFileExample {

	public static void main(String[] args) {
		
		Pipeline p = Pipeline.create();
		PCollection<String>  output = 
				p.apply(TextIO.read().from("./src/main/resources/input.csv"));
		
		output.apply(TextIO.write().to("./src/main/resources/output.csv")
				.withNumShards(1)
				.withSuffix("csv"));
		
		p.run();
	}
}

