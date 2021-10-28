package section3;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Partition;
import org.apache.beam.sdk.transforms.Partition.PartitionFn;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionList;

class MyCityPartition implements PartitionFn<String> {

	@Override
	public int partitionFor(String elem, int numPartitions) {

		String[] row = elem.split(",");
		if(row[row.length-1].equals("Los Angeles")) {
			
			return 0;
		} else if(row[row.length-1].equals("Phonix")) {
			
			return 1;
		}else {
			
			return 2;
		}
	}
	
}

public class PartitionExample {

	public static void main(String[] args) {

		Pipeline p = Pipeline.create();

		PCollection<String> input1 = 
				p.apply(TextIO.read().from("./src/main/resources/Partition.csv"));
		
		PCollectionList<String> list = input1.apply(Partition.of(3, new MyCityPartition()));
		
		PCollection<String> result1 = list.get(0);
		
		result1.apply(TextIO.write().to("./src/main/resources/partition1.csv")
				.withHeader("id,name,last,city")
				.withNumShards(1)
				.withSuffix(".csv"));
		
		p.run();
	}

}
