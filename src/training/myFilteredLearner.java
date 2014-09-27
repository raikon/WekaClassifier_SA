package training;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.Range;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AddClassification;
import weka.filters.unsupervised.attribute.AddID;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.unsupervised.instance.RemoveMisclassified;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.evaluation.Prediction;
import weka.classifiers.evaluation.output.prediction.AbstractOutput;
import weka.classifiers.evaluation.output.prediction.CSV;
import weka.classifiers.functions.SMO;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.rules.ZeroR;
import weka.core.converters.ArffLoader.ArffReader;
import weka.core.converters.ConverterUtils.DataSink;
import weka.core.tokenizers.NGramTokenizer;

import java.io.*;

/**
 * 
 * A Java class that implements a simple text learner, based on WEKA.
 * To be used with MyFilteredClassifier.java.
 * WEKA is available at: http://www.cs.waikato.ac.nz/ml/weka/
 * Copyright (C) 2013 Jose Maria Gomez Hidalgo - http://www.esp.uem.es/jmgomez
 *
 * This program is free software: you can redistribute it and/or modify
 * it for any purpose.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

 * @author Claudia Raponi (revisiting of Jose Maria Gomez Hidalgo's job)
 * see on GitHub: https://github.com/jmgomezh/tmweka
 */


public class myFilteredLearner {

	/**
	 * Object that stores training data.
	 */
	Instances trainData;
	/**
	 * Object that stores the filter
	 */
	StringToWordVector filter;
	/**
	 * Object that stores the classifier
	 */
	FilteredClassifier classifier;
	 Instances predictedData = null;

	/**
	 * This method loads a dataset in ARFF format. If the file does not exist, or
	 * it has a wrong format, the attribute trainData is null.
	 * @param fileName The name of the file that stores the dataset.
	 */
	public void loadDataset(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			ArffReader arff = new ArffReader(reader);
			trainData = arff.getData();
			System.out.println("===== Loaded dataset: " + fileName + " =====");
			reader.close();
		}
		catch (IOException e) {
			System.out.println("Problem found when reading: " + fileName);
		}
	}

	/**
	 * This method evaluates the classifier. As recommended by WEKA documentation,
	 * the classifier is defined but not trained yet. Evaluation of previously
	 * trained classifiers can lead to unexpected results.
	 */
	public void evaluate() {
		try {
			trainData.setClassIndex(trainData.numAttributes() - 1);
			filter = new StringToWordVector();	
			filter.setAttributeIndices("first");
			
			 
			 
			/*Utilizzo di n-gram diversi: default n=1, quindi se filter.setTokenzer disattivato n=1*/
			NGramTokenizer tokenizer = new NGramTokenizer(); 
			String[] options = new String[6]; 
			options[0] = "-max"; 
			options[1] = "1"; 
			options[2] = "-min"; 
			options[3] = "1"; 
			options[4] = "-delimiters"; 
			options[5] = " \r"; 
			tokenizer.setOptions(options);
			filter.setTokenizer(tokenizer);
			
			classifier = new FilteredClassifier();
			classifier.setFilter(filter);
			classifier.setClassifier(new NaiveBayesMultinomial());
			
			AddID addid=new AddID();
			String[] add_options = new String[2]; 
			add_options[0] = "-C";
		     add_options[1] = "1";
		     addid.setOptions(add_options);                           // set options
		     addid.setInputFormat(trainData);  
		        
		     Instances newData = Filter.useFilter(trainData, addid);
		      
			Evaluation eval = new Evaluation(trainData);
			
			StringBuffer output = new StringBuffer();
			AbstractOutput printout = new CSV(); 
		    printout.setBuffer(output); 
		    printout.setAttributes("1");
			
			eval.crossValidateModel(classifier, trainData, 10, new Random(1),printout, null, true);
			
			System.out.println(eval.toSummaryString());
			System.out.println(eval.toClassDetailsString());
			
			 
			    
			System.out.println(output); 
		
			createConfusionMatrix(eval);
			
			System.out.println("===== Evaluating on filtered (training) dataset done =====");
		}
		catch (Exception e) {
			System.out.println("Problem found when evaluating");
			System.out.println(e);
		}
	}
	
	public void method(String o) throws Exception {
		
		trainData.setClassIndex(trainData.numAttributes() - 1);
		RemoveMisclassified f = new RemoveMisclassified();
		
		f.setClassifier(classifier);
		f.setClassIndex(trainData.numAttributes() - 1);
		f.setNumFolds(10);
		f.setThreshold(0.1);
		f.setMaxIterations(1);
		f.setInvert(true);
		f.setInputFormat(trainData);
		Instances output = Filter.useFilter(trainData, f);
		
		/*esporta le istanze "misClassificate in un nuovo arff"*/
		DataSink.write(o, output);
	}
	
	/* 
	 * metodo di supporto per stampare la matrice di confusione
	 */
	public static void createConfusionMatrix(Evaluation eval) {
		double[][] cmMatrix = eval.confusionMatrix();
		System.out.println();
		System.out.println("== Confusion Matrix =="+"\n");
		System.out.println(" a      b     c");
		for(int row_i=0; row_i<cmMatrix.length; row_i++){
			for(int col_i=0; col_i<cmMatrix.length; col_i++){
				System.out.print(cmMatrix[row_i][col_i]+"  ");  
			}
			System.out.print("|");
			if (row_i==0)
				System.out.println("a = positive");
			if (row_i==1)
				System.out.println("b = neutral");
			if (row_i==2) 
				System.out.println("c = negative");
		}
		System.out.println("\n");
	}

	/**
	 * This method trains the classifier on the loaded dataset.
	 */
	public void learn() {
		try {
			trainData.setClassIndex(trainData.numAttributes() - 1);

			filter = new StringToWordVector();
			filter.setAttributeIndices("first");
			
			/*Utilizzo di n-gram diversi: default n=1, quindi se filter.setTokenzer disattivato n=1*/
			NGramTokenizer tokenizer = new NGramTokenizer(); 
			String[] options = new String[6]; 
			options[0] = "-max"; 
			options[1] = "1"; 
			options[2] = "-min"; 
			options[3] = "1"; 
			options[4] = "-delimiters"; 
			options[5] = " \r"; 
			tokenizer.setOptions(options);
			//filter.setTokenizer(tokenizer);
			
			classifier = new FilteredClassifier();
			classifier.setFilter(filter);		
			classifier.setClassifier(new NaiveBayesMultinomial());
			classifier.buildClassifier(trainData);
			// Uncomment to see the classifier
			// System.out.println(classifier);

			System.out.println("===== Training on filtered (training) dataset done =====");
		}
		catch (Exception e) {
			System.out.println("Problem found when training");
			System.out.println(e);
		}
	}

	/**
	 * This method saves the trained model into a file. This is done by
	 * simple serialization of the classifier object.
	 * @param fileName The name of the file that will store the trained model.
	 */
	public void saveModel(String fileName) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(classifier);
			out.close();
			System.out.println("===== Saved model: " + fileName + " =====");
		} 
		catch (IOException e) {
			System.out.println("Problem found when writing: " + fileName);
		}
	}

	/**
	 * This method create the trained model into a file.
	 * @param arff The name of the arff file that will allow to create the trained model.
	 * 		  model The name of the file that will store the trained model.
	 * @throws Exception 
	 */
	public void createModel(String arff, String model) throws Exception {
		loadDataset(arff);
		evaluate();
		learn();
		method("output.arff");
		saveModel(model);
		System.out.println();
	}

	/* 
	 * Main di prova per la verifica della tokenizzazione in n-gram
	*/
	/*
	public static void main(String[] args) throws Exception {
		String[] testArray = new String[]{"Hello to my audience."};     

		String[] options = new String[6]; 
		options[0] = "-max"; 
		options[1] = "2"; 
		options[2] = "-min"; 
		options[3] = "1"; 
		options[4] = "-delimiters"; 
		options[5] = " \r"; 

		try { 
			NGramTokenizer tokenizer = new NGramTokenizer();
			tokenizer.setOptions(options); 
			
			Vector<String> result = new Vector<String>(); 
			for (int i = 0; i < testArray.length; i++) { 
				Vector<String> tmpResult = new Vector<String>(); 
				tokenizer.tokenize(testArray[i]); 
				while (tokenizer.hasMoreElements()) { 
					System.out.println(tokenizer.nextElement());
					tmpResult.add(tokenizer.nextElement()); 
				} 
				// add to result 
				result.addAll(tmpResult); 
			} 

			for (int i = 0; i < result.size(); i++) { 
				//System.err.println(result.get(i)); 
			} 
			

		} catch (Exception e1) { 
			// TODO Auto-generated catch block 
			e1.printStackTrace(); 
		}     
	} 
*/
}	

