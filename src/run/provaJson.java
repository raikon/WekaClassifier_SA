package run;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import net.sf.json.JSONException;
import json.Description;
import json.Entities;
import json.Entities_;
import json.Example;
import json.Metadata;
import json.User;
import textProcessing.Tweet;
import com.google.gson.Gson;

public class provaJson {

	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
	
		
		BufferedReader r = new BufferedReader(new FileReader("C:/Users/SIS/Desktop/Università/Progetti/Mery/dataset/mcdonalds/10/"));

		Example ex = new Example();
		
		try {	    
		        ex = gson.fromJson(r,Example.class);
		    
		        System.out.println(ex.getText());
		        System.out.println(ex.getLang());
    
		} catch (JSONException e) {
		        System.out.println(e);
		}
}
	}
