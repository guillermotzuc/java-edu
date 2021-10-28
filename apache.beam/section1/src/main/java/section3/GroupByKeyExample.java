package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.GroupByKey;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

class StringToKV extends DoFn<String, KV<String, Integer>> {
	
	@ProcessElement
	public void processElement(ProcessContext c) {
		
		String[] arr = c.element().split(",");
		c.output(KV.of(arr[0], Integer.valueOf(arr[3])));
	}
}

class KVToString extends DoFn<KV<String, Iterable<Integer>>, String> {
	
	@ProcessElement
	public void processElement(ProcessContext c) {
		
		String key = c.element().getKey();
		Iterable<Integer> vals = c.element().getValue();
		
		int summ=0;
		for(Integer i: vals) {
			
			summ+= i;
		}
		
		c.output(String.format("%s %s", key, summ));
	}
}

public class GroupByKeyExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> input1 = 
				p.apply(TextIO.read().from("./src/main/resources/GroupByKey_data.csv"));
		
		PCollection<KV<String, Integer>>  korder = input1.apply(ParDo.of(new StringToKV()));
		
		PCollection<KV<String, Iterable<Integer>>> result = korder.apply(GroupByKey.<String, Integer>create());
		
		PCollection<String> output = result.apply(ParDo.of(new KVToString()));
		output.apply(TextIO.write().to("./src/main/resources/groupkey.csv")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
