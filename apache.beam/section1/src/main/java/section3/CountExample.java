package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Distinct;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class CountExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> input1 = 
				p.apply(TextIO.read().from("./src/main/resources/Count.csv"));

		PCollection<Long> pLong = input1.apply(Count.globally());
		pLong.apply(ParDo.of(new DoFn<Long, Void>() {
		
			@ProcessElement
			public void processElement(ProcessContext c) {
				
				System.out.println(c.element());
			}
		
		}));
		p.run();
	}

}
