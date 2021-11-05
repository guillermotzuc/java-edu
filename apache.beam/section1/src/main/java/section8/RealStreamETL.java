package section8;


import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Values;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.joda.time.Duration;

public class RealStreamETL {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		p.apply(KafkaIO.<Long,IoTEvent>read().withBootstrapServers("localhost:9092")
				.withTopic("beamtopic")
				.withKeyDeserializer(LongDeserializer.class)
				.withValueDeserializer(IoTDeserializer.class)
				.withoutMetadata())
		.apply(Values.<IoTEvent>create())
		.apply(Window.<IoTEvent>into(FixedWindows.of(Duration.standardDays(10))))
		.apply(ParDo.of(new DoFn<IoTEvent, String>(){

			@ProcessElement
			public void processElement(ProcessContext c) {

				if(c.element().getTemperature()>80.0) {
					
					c.output(c.element().getDeviceId());
				}
			}

		}))
		.apply(Count.perElement())
		.apply(ParDo.of(new DoFn<KV<String, Long>, Void>(){

			@ProcessElement
			public void processElement(ProcessContext c) {

				System.out.println(c.element());
			}

		}));
//		.apply(ParDo.of(new DoFn<IoTEvent, Void>(){
//
//			@ProcessElement
//			public void processElement(ProcessContext c) {
//
//				System.out.println(c.element());
//			}
//
//		}));

		p.run();

	}

}
