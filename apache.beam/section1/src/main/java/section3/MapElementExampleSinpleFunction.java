package section3;

import java.util.Arrays;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;

class User extends SimpleFunction<String, String> {

	@Override
	public String apply(String input) {

		String[] row = input.split(",");
		if(row[row.length-1].equals("1")) {
			
			row[row.length-1] = "M";
		} else if(row[row.length-1].equals("2")) {
			
			row[row.length-1] = "F";
		}
		return String.join(",", row);
	}
	
}

public class MapElementExampleSinpleFunction {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();
		
		PCollection<String> input = 
				p.apply(TextIO.read().from("./src/main/resources/user.csv"));
		
		PCollection<String> sex = input.apply(MapElements.via(new User()));
		
		sex.apply(TextIO.write().to("./src/main/resources/userTransform.csv")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
