package avro.generic;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

public class GenericRecordExamples {

	public static void main(String[] args) {
		
		//Define schema
		Schema.Parser parser = new Schema.Parser();
		
		Schema schema = parser.parse("{\n" + 
				"     \"type\": \"record\",\n" + 
				"     \"namespace\": \"com.example\",\n" + 
				"     \"name\": \"Customer\",\n" + 
				"     \"doc\": \"Avro Schema for our Customer\",     \n" + 
				"     \"fields\": [\n" + 
				"       { \"name\": \"first_name\", \"type\": \"string\", \"doc\": \"First Name of Customer\" },\n" + 
				"       { \"name\": \"last_name\", \"type\": \"string\", \"doc\": \"Last Name of Customer\" },\n" + 
				"       { \"name\": \"age\", \"type\": \"int\", \"doc\": \"Age at the time of registration\" },\n" + 
				"       { \"name\": \"height\", \"type\": \"float\", \"doc\": \"Height at the time of registration in cm\" },\n" + 
				"       { \"name\": \"weight\", \"type\": \"float\", \"doc\": \"Weight at the time of registration in kg\" },\n" + 
				"       { \"name\": \"automated_email\", \"type\": \"boolean\", \"default\": true, \"doc\": \"Field indicating if the user is enrolled in marketing emails\" }\n" + 
				"     ]\n" + 
				"}");
		
		//Step 1: create a generic record
		GenericRecordBuilder customerBuilder = new GenericRecordBuilder(schema);
		customerBuilder.set("first_name", "Guillermo");
		customerBuilder.set("last_name", "Tzuc");
		customerBuilder.set("age", 31);
		customerBuilder.set("height", 1.60f);
		customerBuilder.set("weight", 70.0f);
		//customerBuilder.set("automated_email", true);
		
		
		GenericData.Record record = customerBuilder.build();
		System.out.println(record);
		//Step 2: write generic record to a file
        // writing to a file
        final DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter)) {
            dataFileWriter.create(schema, new File("customer-generic.avro"));
            dataFileWriter.append(record);
            System.out.println("Written customer-generic.avro");
            dataFileWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't write file");
            e.printStackTrace();
        }
        
		//Step 3: Read generic record
        // reading from a file
        final File file = new File("customer-generic.avro");
        final DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();
        GenericRecord customerRead;
        try (DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(file, datumReader)){
            customerRead = dataFileReader.next();
            System.out.println("Successfully read avro file");
            System.out.println(customerRead.toString());

            // get the data from the generic record
            System.out.println("First name: " + customerRead.get("first_name"));

            // read a non existent field
            System.out.println("Non existent field: " + customerRead.get("not_here"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
		//Interpret as generic record
	}

}
