package run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Caricamento dati grezzi
 * 
 * @author Claudia Raponi
 */

public class LoadData {
	private String path;
	private Map<Integer, String> tweetCodeText = new HashMap<>();


	public LoadData(String path) {
		super();
		this.path = path;
	}
	
	/*
	 * Importazione dati specifici attraverso codici noti 
	 */
	public Map<Integer,String> importDataByCode(ArrayList<Integer> code) throws IOException  {
		Integer[] tweetCode = new Integer[code.size()];
		code.toArray(tweetCode);
		File directoryDataSet = new File(this.path);
		String[] children = directoryDataSet.list();
		if (children == null) {
			System.out.println("Error: Either directoryDataSet does not exist or is not a directory");
		} else {
			for (int j=0;j<=tweetCode.length-1;j++) {
				BufferedReader input = new BufferedReader(new FileReader(this.path+tweetCode[j]));
				String text;
				StringBuffer buffer = new StringBuffer();
				while ((text = input.readLine()) != null)
					buffer.append(text + "\n");
				input.close();
				String tweetText = buffer.toString();
				tweetCodeText.put(tweetCode[j], tweetText);
			}
		}
		return tweetCodeText;
	}
	
	
	/*
	 * Importazione dati casuali attraverso la randomizzazione
	 */
	public Map<Integer,String> importDataRandom(int numFile, List<Integer> list) throws IOException {
		File directoryDataSet = new File(this.path);
		String[] children = directoryDataSet.list();
		if (children == null) {
			System.out.println("Error: Either directoryDataSet does not exist or is not a directory");
		} else {
			for(int i=0;i<=numFile-1;i++) {
				// String filename = children[i];
				int filename = Math.abs(0 + (int)(Math.random() * ((254646 - 0) + 1)));
				if (!list.contains(filename)) {
					BufferedReader input = new BufferedReader(new FileReader(this.path+filename));
					String text;
					StringBuffer buffer = new StringBuffer();
					while ((text = input.readLine()) != null)
						buffer.append(text + "\n");
					input.close();
					String tweetText = buffer.toString();
					tweetCodeText.put(filename, tweetText);
				}
				else 
					i = i--;
			}
		}
		return tweetCodeText;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}





