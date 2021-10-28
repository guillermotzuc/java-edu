package section1;

import java.util.Arrays;
import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;

public class InMemoryExample {

	public static void main(String[] args) {

		MyOptions options = 
				PipelineOptionsFactory
				.fromArgs(args)
				.withValidation().as(MyOptions.class);
		
		Pipeline p = Pipeline.create();
		
		PCollection<CustomerEntity> entities = 
				p.apply(Create.of(getCustomer()));
		
		PCollection<String> customerStrings  =	
				entities.apply(MapElements.into(TypeDescriptors.strings())
				.via((CustomerEntity cust) -> cust.getName()));
		
		customerStrings.apply(TextIO.write().to("./src/main/resources/customers.csv")
				.withNumShards(1)
				.withSuffix(options.getExtension()));

		p.run();
	}

	static List<CustomerEntity> getCustomer() {
		
		return Arrays.asList(
				new CustomerEntity(0, "A"),
				new CustomerEntity(1, "B"),
				new CustomerEntity(2, "C")
				);
	}
}
