package training;


import weka.classifiers.AbstractClassifier;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSink;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.unsupervised.instance.RemoveMisclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Runs the RemoveMisclassified filter over a given ARFF file.
 * First parameter is the input file, the second the classifier
 * to use and the third one is the output file.
 *
 * Usage: RemoveMisclassifiedTest input.arff classname output.arff
 *
 * @author FracPete (fracpete at waikato dot ac dot nz)
 */
public class RemoveMisclassifiedTest {
	  
	  /**
	   * Expects three parameters: 
	   * First parameter is the input file, the second the classifier
	   * to use (no options) and the third one is the output file. 
	   * It is assumed that the class attribute is the last attribute in the
	   * dataset.
	   * 
	   * @param args	the commandline arguments
	   * @throws Exception	if something goes wrong
	   */
	  public static void main(String[] args) throws Exception {
	    
	      System.out.println("\nUsage: RemoveMisclassifiedTest <input.arff> <classname> <output.arff>\n");
	    
	     StringToWordVector filter = new StringToWordVector();
			filter.setAttributeIndices("first");
			FilteredClassifier classifier = new FilteredClassifier();
			classifier.setFilter(filter);		
			classifier.setClassifier(new NaiveBayesMultinomial());
			
	    // get data 
	    Instances input = DataSource.read("fileArff.arff");
	    input.setClassIndex(input.numAttributes() - 1);

	    // get classifier
	   // Classifier c = AbstractClassifier.forName(classifier, new String[0]);

	    // setup and run filter
	    RemoveMisclassified f = new RemoveMisclassified();
	    f.setClassifier(classifier);
	    f.setClassIndex(1);
	    f.setNumFolds(10);
	    f.setThreshold(0.1);
	    f.setMaxIterations(1);
	    f.setInputFormat(input);
	    f.setInvert(false);
	    Instances output = Filter.useFilter(input, f);
	    
	    // output file
	    DataSink.write("out.arff", output);
	  }
}