package training;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row; 

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

/**
 * Generates an ARFF file. Con il campo 'Sentiment' compilato. Il campo 'Sentiment' pu˜ assumere 3 valori: positive, negative, neutral.
 *
 * @author Claudia Raponi (revisiting of Anastasiya Zadorozhna's job)
 */

@SuppressWarnings("deprecation")
public class Excel2Arff_training {

	private static HSSFWorkbook wb;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void excel2arff(String inputFile) throws ParseException, IOException, InvalidFormatException {
		FastVector atts;
		FastVector attValsSentiment;
		Instances data;
		double[] vals;

		// 1. set up attributes
		atts = new FastVector();

		// - string
		atts.addElement(new Attribute("Content", (FastVector) null));

		// - nominal
		attValsSentiment = new FastVector();
		attValsSentiment.addElement("positive");
		attValsSentiment.addElement("negative");
		attValsSentiment.addElement("neutral");
		atts.addElement(new Attribute("Sentiment", attValsSentiment));

		// 2. create Instances object
		data = new Instances(inputFile.substring(0, inputFile.length()-5), atts, 0);

		// 3. fill with data
		FileInputStream fis = new FileInputStream(inputFile);

		InputStream wrappedStream = POIFSFileSystem.createNonClosingInputStream(fis);
		wb = new HSSFWorkbook(wrappedStream);
		org.apache.poi.ss.usermodel.Sheet ws = wb.getSheetAt(0);

		int rowNum = ws.getLastRowNum() +1;
		System.out.println("Number of rows in Training set = " + rowNum);

		System.out.println("====================");

		for(int i = 0; i < rowNum; i++) {	
			Row row = ws.getRow(i);
			vals = new double [data.numAttributes()];
			
			// - string 
			Cell cell = row.getCell(0);

			String value = cell.toString();
			if(value.equals("")){
				vals[0] = data.attribute(0).addStringValue(" ??? none ???");
			}
			else {
				vals[0] = data.attribute(0).addStringValue(value);
			}

			// - nominal 
			Cell cellClass = row.getCell(1);
			vals[1] = attValsSentiment.indexOf(cellClass.toString());
			// add
			data.add(new DenseInstance(1.0, vals));
		}

		// 4. save to file
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("fileArff.arff"));
		saver.writeBatch();
		System.out.println("===== Training set for SENTIMENT in ARFF format created =====");
	}
}
