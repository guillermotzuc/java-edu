package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Flatten;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionList;

public class FlattenExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> input1 = 
				p.apply(TextIO.read().from("./src/main/resources/customer_1.csv"));
		
		PCollection<String> input2 = 
				p.apply(TextIO.read().from("./src/main/resources/customer_2.csv"));
		
		PCollection<String> input3 = 
				p.apply(TextIO.read().from("./src/main/resources/customer_3.csv"));
		
		PCollectionList<String> list = PCollectionList.of(input1).and(input2).and(input3);
		
		PCollection<String> output = 
				list.apply(Flatten.pCollections());
		
		
		output.apply(TextIO.write().to("./src/main/resources/flatten.csv")
				.withHeader("id,name,last,city")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
