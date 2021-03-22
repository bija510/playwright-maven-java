package utilites;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static String keyVal;
	private static Reader reader;
	private static String jsonFilePath;
	private String filePath;
	
	public JsonUtils(String filePath) {
		this.filePath = filePath;
	}
	
		
	@SuppressWarnings("finally")
	public String readJson(String key) throws Exception {
		jsonFilePath = System.getProperty("user.dir") + "\\" + filePath;
		
		try {  
		    reader = Files.newBufferedReader(Paths.get(jsonFilePath));// create a reader		    
		    ObjectMapper objectMapper = new ObjectMapper();//create ObjectMapper instance	    
		    JsonNode parser = objectMapper.readTree(reader);//read customer.json file into tree model
		    keyVal = parser.path(key).asText();

		} catch (Exception ex) {
			ex.printStackTrace();			
			throw new Exception("======Failed to readData from Json file==========");
	}finally {		
		reader.close(); //close reader
		if(!(keyVal.length()>0)) {
			throw new Exception("======Failed to readData from Json file==========");
		}
		return keyVal;
	}	
  }
}