package textProcessing;

/**
 * Estrazione contenuto testo dai dati grezzi
 * 
 * @author Claudia Raponi
 */

public class Extractor {

	public Extractor() {
		super();
	}

	/*
	 * Filtra il contenuto selezionando solo il testo dei tweet e aggiornado la mappa
	 * (creandone una nuova)
	 */

	public String contentFilter(String rawContent) {
		String newBuffer = "";
			if (checkEnglishTweetNo(rawContent).equals("en")) {
				newBuffer=extractSubstring(rawContent,",\"text\":\"RT ",",\"contributors\":");
				//System.out.println("NewBufferA: "+newBuffer);
			if(newBuffer==null) 
				newBuffer=extractSubstring(rawContent,"\"text\":",",\"geo\":");
				//System.out.println("NewBufferB: "+newBuffer);
			}
			else
				newBuffer="invalid";
			//System.out.println("NewBuffer: "+newBuffer+"\n ===================================");
			String bufferWithoutQuote = newBuffer.replace("\"", "");
			
		return bufferWithoutQuote;
	}
	
	public String checkEnglishTweetNo(String rawContent) {
		//System.out.println("Contenuto Grezzo: "+rawContent);
		String language=extractSubstring(rawContent,"\"iso_language_code\":\"","\"}}");
		if( language==null || language.length()>2) { 
			if (language!=null) {
				language=extractSubstring(rawContent,"\"iso_language_code\":\"","\"},");
			}
			else
				language=extractSubstring(rawContent,",\"lang\":\"","\",\"");
		}
		//System.out.println("Language: "+language);
		return language;
	}

	/*
	 * Metodo di supporto per l'estrazione della sottostringa interessata
	 */

	public String extractSubstring(String str, String begin, String end){
		int firstIndex = str.indexOf(begin);
		if(firstIndex == -1)
			return null;
		int secondIndex = str.indexOf(end, firstIndex+1);
		if(secondIndex == -1)
			return null;
		return str.substring(firstIndex+begin.length(), secondIndex);
	}
}
