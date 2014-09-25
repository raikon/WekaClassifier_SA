package training;


import weka.classifiers.AbstractClassifier;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.meta.FilteredClassifier;
import weka.core.Instances;
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
  public static void main(String[] args) throws Exception {
      System.out.println("\nUsage: RemoveMisclassifiedTest input.arff classname output.arff\n");

    // get data
    Instances input = new Instances(
        new BufferedReader(new FileReader("fileArff.arff")));
    input.setClassIndex(input.numAttributes() - 1);
    
    StringToWordVector fi = new StringToWordVector();	
	fi.setAttributeIndices("first");

    // get classifier
	FilteredClassifier classifier;
	classifier = new FilteredClassifier();
	classifier.setFilter(fi);
	classifier.setClassifier(new NaiveBayesMultinomial());

    // setup and run filter
	
		RemoveMisclassified f = new RemoveMisclassified();
		f.setClassifier(classifier);
		f.setClassIndex(-1);
		f.setNumFolds(10);
		f.setThreshold(0.1);
		f.setMaxIterations(1);
	
		
		  
		String[] op = new String[1];
	    op[0]="-V";
	    //f.setOptions(op);
	    
	     
	    f.setInputFormat(input);
	      
		Instances output = Filter.useFilter(input, f);

		// output file
		BufferedWriter writer = new BufferedWriter(new FileWriter("fuori.arff"));
		writer.write(output.toString());
		writer.newLine();
		writer.flush();
		writer.close();
	}
  }
