package run;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
 * Main di avvio del software
 * 
 * @author Claudia Raponi
 */

public class Start {
	
	// il training necessita di dati specifici
	private static final int[] tweetName = new int[]{242,563,810,903,1989,2064,2096,2499,2879,2994,3050,3385,3411,3501,3713,4149,4638,
		4942,6756,7196,7748,8134,8618,8846,9206,9419,10163,11064,11781,12131,12402,12777,13116,13608,13785,14342,14553,14580,14679,14845,
		14917,16148,16534,16627,17018,17345,18175,18503,18687,18700,19253,19689,21733,21927,22012,22058,22312,22643,22732,24348,25591,
		25950,27272,27308,27450,27911,28060,28170,28305,28977,29048,29356,29964,30024,30172,30661,30877,31067,32617,32930,33207,33444,
		33545,34308,34702,35009,35239,35915,36105,36117,36158,36260,36665,37240,37297,38336,38640,38887,39027,39086,39093,39426,39754,
		39766,40171,40379,40484,41558,41599,41603,42051,42591,43176,44169,44772,44917,45968,46241,46649,47087,47152,48033,48151,49051,
		49077,49415,49524,49631,49959,49984,50225,50792,50914,51050,51149,51696,51937,51959,52725,53166,53438,53515,53741,53827,54203,
		54256,54554,54595,54664,55472,55911,56180,56430,56605,56747,56771,56895,57055,57360,57945,58006,58022,58751,59093,59165,59555,
		59865,60403,60441,60789,62343,62450,62472,62640,63044,63296,63620,64288,64487,64904,64984,65140,65561,65961,66757,67405,67474,
		67530,67793,68042,68263,68516,68728,70214,70252,70377,70934,71596,71642,71696,71736,71974,72011,72100,72396,72443,72752,73131,
		73459,73598,73672,73789,74293,74644,74777,74874,75281,75600,76236,76952,76990,77909,77932,77950,78305,78398,78401,78645,78710,
		78796,79468,79716,79974,80355,80364,81982,82185,82351,82661,83113,83328,83842,84341,84612,84714,85002,85325,85387,85485,85735,
		87055,87196,87244,87551,89404,89850,90476,90839,91004,91135,91336,91613,91762,91928,92268,92426,92996,93685,94496,94538,94925,
		95678,96085,96835,97084,97112,97943,98006,98028,98693,99252,99620,100123,100365,100802,101224,101485,101655,102532,102658,102932,
		103190,103538,103604,104054,104552,104650,104827,107314,108197,108553,108924,109750,110012,110416,110551,110855,111279,111729,
		111906,112131,112436,112492,112888,113462,113792,114384,116297,116642,118436,118990,119716,120299,120691,121261,121541,122219,
		122428,122450,122492,123905,124236,125913,126974,128069,128712,128788,128819,129352,129594,129620,130815,132334,132394,133337,
		133501,135324,135675,135833,135901,135904,136859,137787,138509,140105,141124,141186,141369,141910,142242,142918,143565,143891,
		144119,147589,148930,150273,150979,151010,151042,151379,151723,154066,154108,154450,154703,154779,155410,156402,158107,158292,
		158341,158711,159153,159234,160150,160311,160563,161519,161723,162188,162337,162910,163020,163608,163675,164015,164116,164156,
		164488,164525,164575,164635,164864,165427,165677,165697,166225,167340,167343,167391,168216,168238,168357,168609,168636,168897,
		168988,169282,169553,170756,170958,170997,171106,171538,171666,171677,171841,171951,172041,172047,172052,172471,172483,173124,
		173346,174741,175103,175871,176786,176798,177409,177511,177668,178087,178112,178158,178361,178452,178566,178571,178625,179036,
		179043,179054,179174,179289,179583,179965,180298,180384,180473,180620,180720,181071,181871,182284,182422,182485,182738,182827,
		182875,183509,183656,184380,184575,185043,185715,186747,187264,187437,187620,187830,187904,187917,188261,188370,188415,188871,
		189212,189439,189628,189772,190470,190608,190776,190922,191058,191149,191512,191545,191944,192018,192767,192825,193818,194018,
		194092,194271,194929,194973,195043,195207,195218,195285,195318,195703,196163,196219,196280,196609,196857,196870,197145,198203,
		198340,198490,198581,198590,198864,199079,200139,200295,200443,200547,202070,202640,203214,203291,203468,203507,203577,203666,
		203953,204065,204190,204640,204712,204719,205184,205266,205341,205484,205486,205821,205843,206698,207506,208250,208255,208571,
		208982,209216,209241,209563,209677,209689,210012,210433,210536,211304,211587,212486,212575,212948,213842,213883,215456,215480,
		215630,216106,216768,216891,217336,217601,217798,217839,218033,218068,218252,218842,218955,219704,219757,220044,220044,220190,
		220820,221022,221132,221173,221428,221562,221755,221869,222169,222219,222474,222548,222641,223316,223385,223439,223540,224105,
		224107,224180,224512,224700,225070,226036,226386,226422,226524,226740,226757,227804,227897,229022,229239,229270,229436,230093,
		230235,230858,231044,233502,233610,234058,234168,234239,234837,235165,235335,235757,235889,235891,236550,236949,237498,237636,
		237742,237761,237925,238653,238669,238909,240336,240647,240684,240941,241064,241085,241100,241314,241484,242579,242707,243447,
		243973,244230,244385,244626,244750,245417,245584,245958,246490,246541,246940,246993,247279,247733,249605,249611,249803,249951,
		250647,250738,251542,252364,253357};
	
	
	public static void main(String[] args) throws Exception {
		
		train();
		
		/*Creazione modello di training*/
		myFilteredLearner learner = new myFilteredLearner();
		learner.createModel("fileArff.arff", "TrainingModel.dat");
		
		//test();
		
		System.out.println("=== Classification Completed ===");
	}
	
	/*
	* metodo per l'elabozione del trainingSet
	*/
	public static void train() throws IOException, InvalidFormatException, ParseException {
		LoadData dataset = new LoadData("C:/Users/SIS/Desktop/Università/Progetti/Mery/dataset/mcdonalds/");
		Map<Integer, String> tweetCodeText = new HashMap<>();
		System.out.println("TweeName: "+tweetName.length);
		
		/* Caricamento di dati specifici*/
		tweetCodeText = dataset.importDataByCode(tweetName);
		
		//printMap(tweetCodeText);

		/* Estrazione testo e Normalizzazione del contenuto dei tweet */
		Processor p = new Processor();
		tweetCodeText = p.elaborationContent(tweetCodeText);
		
		//printMap(tweetCodeText);
		
		/*Rimozione eventuali duplicati*/
		tweetCodeText = removeDuplicate(tweetCodeText);
		//System.out.println("TweetList: "+tweetCodeText.size());
		
		//printMap(tweetCodeText);
		
		/* Salvataggio dei dati processati in un file excel*/
		//export2Excel(tweetCodeText,"export2Excel.xls");

		/* Creazione del file arff a partire dall'excel creato */
		Excel2Arff_training ex_training  = new Excel2Arff_training();
		ex_training.excel2arff("export2Excel.xls");
	}
	

	/*
	* metodo per l'elabozione del testSet e della classificazione
	*/
	public static void test() throws InvalidFormatException, ParseException, IOException {
		/* 
		 *  Caricamento dataset 
		 *  Due modalità: caricamento file specifici, caricamento file casuali
		 */
		LoadData dataset = new LoadData("C:/Users/SIS/Desktop/Università/Progetti/Mery/dataset/mcdonalds/");
		Map<Integer, String> tweetCodeText = new HashMap<>();

		/*Caricamento di dati specifici*/
		//tweetCodeText = dataset.importDataByCode(tweetName);
		
		/* Caricamento di dati casuali*/
		List<Integer> list = new ArrayList<Integer>(tweetName.length);  
		for (int n : tweetName) {  
		    list.add(n);  
		}
		tweetCodeText = dataset.importDataRandom(5,list);

		//printMap(tweetCodeText);

		/* Estrazione testo e Normalizzazione del contenuto dei tweet */
		Processor p = new Processor();
		tweetCodeText = p.elaborationContent(tweetCodeText);
		
		//printMap(tweetCodeText);
		
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
			FileOutputStream out = 
					new FileOutputStream(new File(nameFile));
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
