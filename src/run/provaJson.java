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
		Gson gsonA = new Gson();
		Gson gsonB = new Gson();
		Gson gsonC = new Gson();
		Gson gsonD = new Gson();
		Gson gsonE = new Gson();
		Gson gsonF = new Gson();
		
		BufferedReader r = new BufferedReader(new FileReader("C:/Users/SIS/Desktop/Università/Progetti/Mery/dataset/mcdonalds/77932/"));
		Description d = new Description();
		Metadata m = new Metadata();
		Entities_ en = new Entities_();
		Entities en2 = new Entities();
		User u = new User();
		Example ex = new Example();
		
		try {
		        //m = gsonA.fromJson(r, Metadata.class);
		        //d = gsonB.fromJson(r, Description.class);
		        //en = gsonC.fromJson(r, Entities_.class);
		        //en2 = gsonD.fromJson(r, Entities.class);
		        //u = gsonE.fromJson(r, User.class);
		        ex = gsonF.fromJson(r,Example.class);
		       // System.out.println(m);
		       // System.out.println(d);
		       // System.out.println(en);	
		       // System.out.println(en2);
		        //System.out.println(u);
		        System.out.println(ex);
    
		} catch (JSONException e) {
		        System.out.println(e);
		}
}
	}
