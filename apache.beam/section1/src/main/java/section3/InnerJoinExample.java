package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.join.CoGbkResult;
import org.apache.beam.sdk.transforms.join.CoGroupByKey;
import org.apache.beam.sdk.transforms.join.KeyedPCollectionTuple;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TupleTag;

class OrderParsing extends DoFn<String, KV<String, String>> {
	
	@ProcessElement
	public void processElement(ProcessContext c) {
		
		String[] arr = c.element().split(",");
		c.output(KV.of(arr[0], c.element()));
	}
}

class UserParsing extends DoFn<String, KV<String, String>> {
	
	@ProcessElement
	public void processElement(ProcessContext c) {
		
		String[] arr = c.element().split(",");
		c.output(KV.of(arr[0], arr[1]));
	}
}


public class InnerJoinExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<KV<String, String>> input1 = 
				p.apply(TextIO.read().from("./src/main/resources/user_order.csv")).
				apply(ParDo.of(new OrderParsing()));
		
		
		PCollection<KV<String, String>> input2 = 
				p.apply(TextIO.read().from("./src/main/resources/p_user.csv")).
				apply(ParDo.of(new UserParsing()));
		
		
		final TupleTag<String> orderTuple = new TupleTag<>();
		final TupleTag<String> userTuple = new TupleTag<>();
		
		
		PCollection<KV<String, CoGbkResult>> result = 
							KeyedPCollectionTuple.of(orderTuple, input1)
							.and(userTuple, input2)
							.apply(CoGroupByKey.<String>create());

		
		 PCollection<String> output = result.apply(ParDo.of(new DoFn<KV<String, CoGbkResult>, String>(){
			
			@ProcessElement
			public void processElement(ProcessContext c) {
				
				String key = c.element().getKey();
				CoGbkResult value = c.element().getValue();
				
				Iterable<String> orders = value.getAll(orderTuple);
				Iterable<String> users = value.getAll(userTuple);

				for(String order: orders) {
					
					for(String user: users) {
						
						c.output(key+","+order+","+user);
					}
				}
			}
			
		}));
		
		output.apply(TextIO.write().to("./src/main/resources/join.csv")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
