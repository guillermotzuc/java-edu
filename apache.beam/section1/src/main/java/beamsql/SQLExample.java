package beamsql;

import java.util.stream.Collectors;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.extensions.sql.SqlTransform;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.schemas.Schema;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.DoFn.ProcessContext;
import org.apache.beam.sdk.transforms.DoFn.ProcessElement;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;

public class SQLExample {

	final static String HEADER = "userId,orderId,productId,Amount";

	final static Schema schema = Schema.builder()
			.addStringField("userId")
			.addStringField("orderId")
			.addStringField("productId")
			.addStringField("Amount")
			.build();

	public static class StringToRow extends DoFn<String, Row> {

		@ProcessElement
		public void processElement(ProcessContext c) {

			if(!c.element().equalsIgnoreCase(HEADER)) {

				String[] array = c.element().split(",");
				Row row = Row.withSchema(schema)
						.addValues(array[0],array[1],array[2],array[3])
						.build();

				c.output(row);
			}
		}
	}

	public static class RowToString extends DoFn<Row, String>{

		@ProcessElement
		public void processElement(ProcessContext c) {

			String outStr = c.element()
					.getValues().stream()
					.map(Object::toString)
					.collect(Collectors.joining(","));

			c.output(outStr);
		}
	}

	public static void main(String[] args) {

		Pipeline pipeline = Pipeline.create();

		//Steap 1: Read csv file
		PCollection<String> fileInput = 
				pipeline.apply(TextIO.read().from("./src/main/resources/user_order.csv"));

		//Steap 2: convert PCollection<String> to PCollection<Rows>
		PCollection<Row> rows = 
				fileInput.apply(ParDo.of(new StringToRow()))
				.setRowSchema(schema);

		//Appy sql tranformation
		PCollection<Row> SQLRows = rows.apply(SqlTransform.query("select * from PCOLLECTION "))
				.setRowSchema(schema);

		SQLRows.apply(ParDo.of(new RowToString()))
				.apply(TextIO.write().to("./src/main/resources/sql_out.csv")
				.withNumShards(1)
				.withSuffix(".csv"));
				
		pipeline.run();
	}

}
