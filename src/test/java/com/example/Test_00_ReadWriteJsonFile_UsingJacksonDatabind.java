package com.example;

import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*==========================================================
 * https://attacomsian.com/blog/java-read-write-json-files
 ==========================================================*/
public class Test_00_ReadWriteJsonFile_UsingJacksonDatabind {
    private static String jsonFilePath = System.getProperty("user.dir") + "\\Data\\TestData.json";
	
    @Test
	public void test_write_JsonFIle() {
		try {
			
		    // create a writer
		    BufferedWriter writer = Files.newBufferedWriter(Paths.get(jsonFilePath));

		    // create a map for customer properties
		    Map<String, Object> customer = new HashMap<>();
		    customer.put("id", 1);
		    customer.put("name", "John Doe");
		    customer.put("email", "john.doe@example.com");
		    customer.put("age", 32);

		    // create address
		    Map<String, Object> address = new HashMap<>();
		    address.put("street", "155 Middleville Road");
		    address.put("city", "New York");
		    address.put("state", "New York");
		    address.put("zipCode", 10045);

		    // add address to customer
		    customer.put("address", address);

		    // create payment methods
		    customer.put("paymentMethods", Arrays.asList("PayPal", "Stripe"));

		    // create 1st project
		    Map<String, Object> p1 = new HashMap<>();
		    p1.put("title", "Business Website");
		    p1.put("budget", 4500);

		    // create 2nd project
		    Map<String, Object> p2 = new HashMap<>();
		    p2.put("title", "Sales Dashboard");
		    p2.put("budget", 8500);

		    // add projects to customer
		    customer.put("projects", Arrays.asList(p1, p2));

		    // create ObjectMapper instance
		    ObjectMapper mapper = new ObjectMapper();

		    // write JSON to file
		    writer.write(mapper.writeValueAsString(customer));

		    //close the writer
		    writer.close();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	  
  }
	
	@Test
	public void test_read_JsonFIle() {
	
		try {
		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(jsonFilePath));

		    //create ObjectMapper instance
		    ObjectMapper objectMapper = new ObjectMapper();

		    //read customer.json file into tree model
		    JsonNode parser = objectMapper.readTree(reader);

		    // read customer details
		    System.out.println(parser.path("id").asLong());
		    System.out.println(parser.path("name").asText());
		    System.out.println(parser.path("email").asText());
		    System.out.println(parser.path("age").asLong());

		    // read address
		    JsonNode address = parser.path("address");
		    System.out.println(address.path("street").asText());
		    System.out.println(address.path("city").asText());
		    System.out.println(address.path("state").asText());
		    System.out.println(address.path("zipCode").asLong());

		    // read payment method
		    for (JsonNode pm : parser.path("paymentMethods")) {
		        System.out.println(pm.asText());
		    }

		    // read projects
		    for (JsonNode project : parser.path("projects")) {
		        System.out.println(project.path("title").asText());
		        System.out.println(project.path("budget").asLong());
		    }

		    //close reader
		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}   
 }

}