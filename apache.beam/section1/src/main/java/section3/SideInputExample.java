package section3;

import java.util.Map;
import java.util.Optional;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.View;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionView;

public class SideInputExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();


		PCollection<KV<String, String>> pReturn = p.apply(TextIO.read().from("./src/main/resources/return.csv"))
				.apply(ParDo.of(new DoFn<String, KV<String,String>>(){

					@ProcessElement
					public void process(ProcessContext c) {

						String line = c.element();
						String[] arr= line.split(",");

						c.output(KV.of(arr[0], arr[1]));
					}

				}));


		PCollectionView<Map<String, String>> view = pReturn.apply(View.asMap());

		PCollection<String> customerOrders = 
				p.apply(TextIO.read().from("./src/main/resources/cust_order.csv"));
		
		customerOrders.apply(ParDo.of(new DoFn<String, Void>(){
			
			@ProcessElement
			public void process(ProcessContext c) {

				Map<String, String> mapUsers = c.sideInput(view);
				String line = c.element();
				String[] arr= line.split(",");
				
				String user = mapUsers.get(arr[0]);
				if(Optional.ofNullable(user).isPresent()) {
					
					System.out.println(line);
				}
			}
			
		}).withSideInputs(view));

	}

}
