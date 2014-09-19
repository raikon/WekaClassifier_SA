package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

/**
 * Generates an ARFF file. Senza campo 'Class' compilato. 
 *
 * @author Anastasiya Zadorozhna
 */

@SuppressWarnings("deprecation")
public class Excel2Arff_test {

	private HSSFWorkbook wb;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Instances excel2arff(String inputFile) throws ParseException, IOException {
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
		attValsSentiment.addElement("neutral");
		attValsSentiment.addElement("negative");
		atts.addElement(new Attribute("Sentiment", attValsSentiment));

		// 2. create Instances object
		data = new Instances(inputFile.substring(0, inputFile.length()-5), atts, 0);
		data.setClassIndex(1);

		// 3. fill with data

		FileInputStream fis = new FileInputStream(inputFile);

		InputStream wrappedStream = POIFSFileSystem.createNonClosingInputStream(fis);
		wb = new HSSFWorkbook(wrappedStream);
		org.apache.poi.ss.usermodel.Sheet ws = wb.getSheetAt(0);

		int rowNum = ws.getLastRowNum() + 1;

		for(int i = 0; i < rowNum; i++) {
			Row row = ws.getRow(i);
			vals = new double [data.numAttributes()];

			// - string 
			Cell cell = row.getCell(0);
			String value = cell.toString();
			if(value.equals("")){
				vals[0] = data.attribute(0).addStringValue("");
			}
			else
				vals[0] = data.attribute(0).addStringValue(value);

			// add
			data.add(new DenseInstance(1.0, vals));
		}

		// 4. save to file
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("fileArff_test.arff"));
		saver.writeBatch();
		System.out.println("===== Data set to classify in ARFF format created =====");
		return data;
	}
}
