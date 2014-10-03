package textProcessing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

import json.Example;

/**
 * Processamento del contenuto del dataset
 * 
 * @author Claudia Raponi
 */

public class Processor {
	Normalizer n;
	Example ex;
	Gson gson; 

	public Processor() throws IOException {
		super();
		this.n = new Normalizer();
		this.ex = new Example();
		this.gson =  new Gson();
	}


	/*
	 * Elaborazione contenuto dei tweet:
	 * - estrazione testo;
	 * - normlizzazione testo;
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer,String> elaborationContent(Map<Integer,String> finalMap) throws IOException {

		HashMap<Integer,String> newMap = createCopy(finalMap); 

		String rawContent;
		String onlyRawText;
		String normalizedText;
		Iterator<Entry<Integer, String>> it = finalMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			rawContent = finalMap.get(entry.getKey());
			ex = gson.fromJson(rawContent,Example.class);
			if(ex.getLang().equals("en")) {
				onlyRawText = ex.getText();
				//System.out.println(entry.getKey()+","+onlyRawText);
				normalizedText = n.cleanText(onlyRawText);
				newMap.put((Integer) entry.getKey(),normalizedText);
				//System.out.println(entry.getKey()+","+normalizedText+","+ex.getCreatedAt());
			}
			else{ 
				newMap.remove(entry.getKey());
				System.out.println("the language of the tweet: ["+entry.getKey()+"] is not treated by the software");
			}
		}

		return newMap;
	}

	/*
	 * metodo di supporto per ottenere una copia della mappa
	 */
	@SuppressWarnings("rawtypes")
	private HashMap<Integer, String> createCopy(Map<Integer, String> finalMap) {
		HashMap<Integer,String> newMap = new HashMap<Integer, String>();
		Iterator<Entry<Integer, String>> it = finalMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			newMap.put((Integer) entry.getKey(),(String) entry.getValue());
		}
		return newMap;
	}
}
