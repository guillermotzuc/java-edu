package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;

public class MapElementExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();
		
		PCollection<String> input = 
				p.apply(TextIO.read().from("./src/main/resources/input.csv"));
		
		PCollection<String> output1 = input.apply(MapElements.into(TypeDescriptors.strings())
					.via((String s) -> s.toUpperCase()));
		
		output1.apply(TextIO.write().to("./src/main/resources/uppercase.csv")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
