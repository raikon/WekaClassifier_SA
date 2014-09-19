package textProcessing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Processamento del contenuto del dataset
 * 
 * @author Claudia Raponi
 */

public class Processor {
	Extractor e;
	Normalizer n;

	public Processor() throws IOException {
		super();
		this.e = new Extractor();
		this.n = new Normalizer();
	}

	
	/*
	 * Elaborazione contenuto dei tweet:
	 * - estrazione testo;
	 * - normlizzazione testo;
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer,String> elaborationContent(Map<Integer,String> finalMap) throws IOException {
		
		HashMap<Integer,String> newMap = createCopy(finalMap); 
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TextCfr.xls"));

		String rawContent;
		String onlyRawText;
		String normalizedText;
		Iterator<Entry<Integer, String>> it = finalMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			rawContent = finalMap.get(entry.getKey());
			onlyRawText= e.contentFilter(rawContent);
			if(!onlyRawText.equals("invalid")) {
					out.writeObject(onlyRawText+"\n");
				normalizedText = n.cleanText(onlyRawText);
					out.writeObject(normalizedText+"\n\n");
					newMap.put((Integer) entry.getKey(),normalizedText);
			}
			else{ 
				newMap.remove(entry.getKey());
				System.out.println("the language of the tweet: ["+entry.getKey()+"] is not treated by the software");
			}
			
		}
		out.close();
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