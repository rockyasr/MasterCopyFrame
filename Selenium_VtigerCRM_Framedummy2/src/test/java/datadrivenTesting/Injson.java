package datadrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Injson {
      public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/jsoncommondata.json"));
		JSONObject map = (JSONObject)obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
	}
}
