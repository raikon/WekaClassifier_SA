package run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import test.Excel2Arff_test;
import test.myFilteredClassifier;
import textProcessing.Processor;
import training.Excel2Arff_training;
import training.myFilteredLearner;
import weka.core.Instances;

/**
 * Main di avvio del software!
 * 
 * @author Claudia Raponi
 */

public class Start {

	// il training necessita di dati specifici

	public static void main(String[] args) throws Exception {
		
		ArrayList<Integer> code = new ArrayList<Integer>();
		
		BufferedReader reader = new BufferedReader(new FileReader("codiciTrainingSet.txt"));
		String line;
		
		while ((line = reader.readLine()) != null) {
		     code.add(Integer.parseInt(line));
		}
		reader.close();
		
		train(code);
		
		/*Creazione modello di training*/
			myFilteredLearner learner = new myFilteredLearner();
			learner.createModel("fileArff.arff", "TrainingModel.dat");
		
		//test(code);
		
		System.out.println("=== Classification Completed ===");
	}
	
	/*
	* metodo per l'elabozione del trainingSet
	*/
	public static void train(ArrayList<Integer> code) throws IOException, InvalidFormatException, ParseException {
		LoadData dataset = new LoadData("C:/Users/SIS/Desktop/Università/Progetti/Mery/dataset/mcdonalds/");
		Map<Integer, String> tweetCodeText = new HashMap<>();
		System.out.println("TrainingSet capacity: "+code.size());
		
		/* Caricamento di dati specifici*/
		tweetCodeText = dataset.importDataByCode(code);

		/* Caricamento di dati casuali*/
		//tweetCodeText = dataset.importDataRandom(1000,code);
		
		//printMap(tweetCodeText);

		/* Estrazione testo e Normalizzazione del contenuto dei tweet */
			Processor p = new Processor();
			tweetCodeText = p.elaborationContent(tweetCodeText);
		
		//printMap(tweetCodeText);
		
		/*Rimozione eventuali duplicati*/
			//tweetCodeText = removeDuplicate(tweetCodeText);
			//System.out.println("TweetList: "+tweetCodeText.size());
		
		//printMap(tweetCodeText);
		
		/* Salvataggio dei dati processati in un file excel*/
			//export2Excel(tweetCodeText,"export2Excel.xls");

		/* Creazione del file arff a partire dall'excel creato */
			Excel2Arff_training ex_training  = new Excel2Arff_training();
			//ex_training.excel2arff("export2Excel.xls");
		
		//printMap(tweetCodeText);
	}
	

	/*
	* metodo per l'elabozione del testSet e della classificazione
	*/
	public static void test(ArrayList<Integer> code) throws InvalidFormatException, ParseException, IOException {
		/* 
		 *  Caricamento dataset 
		 *  Due modalità: caricamento file specifici, caricamento file casuali
		 */
		LoadData dataset = new LoadData("C:/Users/SIS/Desktop/Università/Progetti/Mery/dataset/mcdonalds/");
		Map<Integer, String> tweetCodeText = new HashMap<>();

		/*Caricamento di dati specifici*/
		//tweetCodeText = dataset.importDataByCode(tweetName);
		
		/* Caricamento di dati casuali*/
		tweetCodeText = dataset.importDataRandom(15,code);

		//printMap(tweetCodeText);

		/* Estrazione testo e Normalizzazione del contenuto dei tweet */
		Processor p = new Processor();
		tweetCodeText = p.elaborationContent(tweetCodeText);
		
		printMap(tweetCodeText);
		
		/*Rimozione eventuali duplicati*/
		tweetCodeText = removeDuplicate(tweetCodeText);
		//System.out.println("TweetList: "+tweetCodeText.size());
		
		/* Salvataggio dei dati processati in un file excel*/
		export2Excel(tweetCodeText,"export2Excel_test.xls");
		
		/* Creazione del file arff a partire dall'excel creato */
		Excel2Arff_test ex_test  = new Excel2Arff_test();
		Instances i = ex_test.excel2arff("export2Excel_test.xls");

		 /* Classificazione*/
		myFilteredClassifier classifier = new myFilteredClassifier();
		classifier.makeClassification(i,"TrainingModel.dat");
	}
	
	
	/*
	 * metodo di supporto per l'eliminazione dei duplicati nella mappa
	 */
	@SuppressWarnings("rawtypes")
	private static Map<Integer, String> removeDuplicate(Map<Integer, String> tweetCodeText) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Iterator<Entry<Integer, String>> it = tweetCodeText.entrySet().iterator();
		while (it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();
				if(!map.containsValue(entry.getValue())) {
					int k = (int) entry.getKey();
					String t = (String) entry.getValue();
					map.put(k,t);
				}
		}
		return map;
	}

	
	/*
	 * metodo di supporto per l'esportazione dei dati nel formato excel
	 */
	public static void export2Excel(Map<Integer, String> tweetCodeText, String nameFile) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("DataSet");
		int rownum = 0;
		Set<Integer> keys = tweetCodeText.keySet();
		for (Integer key : keys) {
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(tweetCodeText.get(key));
			Cell cellSent = row.createCell(cellnum++);
			cellSent.setCellValue("positive");

		}
		try {
			FileOutputStream out = new FileOutputStream(new File(nameFile));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully \n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		workbook.close();
	}

	
	/*
	 * metodo di supporto per la stampa della mappa 
	 */
	@SuppressWarnings("rawtypes")
	public static void printMap(Map<Integer, String> tweetCodeText) {
		Iterator<Entry<Integer, String>> it = tweetCodeText.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println(entry.getKey()+","+entry.getValue());
		}
	}

}
