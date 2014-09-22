package textProcessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Normalizzazione contenuto testo dai dati grezzi
 * 
 * @author Claudia Raponi
 */

public class Normalizer {
	private File stopWordFile;
	private File slang;
	private File slangTranslate;
	private HashMap<String,String> dictionary;

	public Normalizer() throws IOException {
		super();
		this.stopWordFile = new File("stopWord.txt");
		this.slang = new File("slang.txt");
		this.slangTranslate = new File("slangTranslate.txt");
		this.dictionary = createSlangDictionary();
	}


	/*
	 * Normalizzazione contenuto del tweet
	 */
	public String cleanText(String onlyRawText) throws IOException {
		String s;
		//s = manageHashTag(onlyRawText);
		
		byte[] utf8 = onlyRawText.getBytes("UTF-8");
		s = new String(utf8);
		
		s = removeHTMLCharacterEntities(s);
				
		s = normalizeText(s);
		
		ArrayList<String>  a = translateSlang(s); 
		s = a.get(0).toLowerCase(); 
		
		s = removeStopWord(s);
		s = removePunctuation(s);
		
		a = translateSlang(s); 
		s = a.get(0).toLowerCase(); 
		
		s = removeStopWord(s);
		s = removePunctuation(s);
		
		s = s.replaceAll("  ","");
		
		return s;
	}
	
	/*
	 * Traduzione dei termini relativi alle entità html
	 */
	public String removeHTMLCharacterEntities(String content) throws IOException {
		content = content
				.replaceAll("&nbsp;"," ")
				.replaceAll( "&lt;", "<")
				.replaceAll("&gt;",">")
				.replaceAll("&amp;","&")
				.replaceAll("&cent;","¢")
				.replaceAll("&pound;","£")
				.replaceAll("&yen;","¥")
				.replaceAll("&euro;","€")
				.replaceAll("&copy;","©")
				.replaceAll("&reg;","®");
		return content;
	}
	
	/*
	 * Traduzione dei termini dello slang
	 */
	private ArrayList<String> translateSlang(String onlyRawText) {
		ArrayList<String> g = new ArrayList<String>();
		String newText="";
		String s = onlyRawText;
		String[] token = s.split(" ");
		for (String a: token) {
			if (dictionary.containsKey(a)) {
				newText += dictionary.get(a) + " ";
			}
			else
				newText += a +" ";
		}
		g.add(newText);
		return g;
	}

	/*
	 * Rimozione delle stopWord
	 */
	public String removeStopWord(String text) throws IOException    {
		StringTokenizer tokens = new StringTokenizer(text, " ");
		String newText = "";
		while (tokens.hasMoreTokens()) {
			String temp = tokens.nextToken();
			if (!checkStopWord(temp,stopWordFile)) {
				newText += temp + " ";
			}
		}
		text = "";
		text = newText;
		return text;
	}
	
	
	/*
	 * Pulizia dei termini contenenti gli hashtag:
	 * viene rimosso il simbolo # ma mantenuto il termine che costituisce il contenuto dell'hashtag
	 */
	public String manageHashTag(String text) {
		String t = text.replace("#","");
		return t;
	}
	
	
	/*
	 * Pulizia del testo del tweet:
	 * - @: mentions
	 * - http: url
	 * - #: hashtag
	 * - \: slash
	 */
	public String normalizeText(String onlyRawText) throws IOException    {
		String lowerCaseText = onlyRawText.toLowerCase();
		StringTokenizer tokens = new StringTokenizer(lowerCaseText, " ");
		String newText = "";
		while (tokens.hasMoreTokens()) {
			String temp = tokens.nextToken();
			if (!temp.contains("@") && !temp.contains("http") && !temp.contains("#") && !temp.contains("\\") ) {
				newText += temp + " ";
			}
		}
		lowerCaseText = "";
		lowerCaseText = newText;
		return lowerCaseText;
	}

	/*
	 * Rimozione della punteggiatura nel testo
	 */
	public String removePunctuation(String text) throws IOException    {
		return text.replaceAll("[^a-zA-Z ]", " ");
	}

	/*
	 * Metodo di supporto per la verifica delle stop word
	 */
	@SuppressWarnings("resource")
	public boolean checkStopWord(String word, File stopWordFile) throws IOException {
		BufferedReader stopWordReader = new BufferedReader(new FileReader(stopWordFile));
		String text2;
		while ((text2 = stopWordReader.readLine()) != null) {
			if(word.equals(text2))
				return true;
		}
		stopWordReader.close();
		return false;
	}

	/*
	 * Creazione del dizionario relativo ai termini dello slang
	 */
	public HashMap<String,String> createSlangDictionary() throws IOException {
		HashMap<String,String> dict = new HashMap<String,String>();
		String[] textS = createSingleArray(slang);
		String[] textST = createSingleArray(slangTranslate);
		
		for (int i=0;i<5462;i++) {
			dict.put(textS[i],textST[i]);
		}
		return dict;
	}
	
	/*
	 * Metodo di supporto per createSlangDictionary
	 */
	public String[] createSingleArray(File sFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(sFile));
		String[] array = new String[5462];
		String text;
		int i=0;
		while ((text = reader.readLine()) != null) {
			array[i]=text;
			i++;
		}
		reader.close();
	return array;
	}
}
