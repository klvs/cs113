package edu.miracosta.cs113.hw10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RecordSort {
	
	int lineNo;
	PrintWriter outFile1, outFile2;
	Scanner inFile;
	ArrayList<String> buffer;
	ArrayList<String> run;
	boolean wroteFile1Last = false;
	
	public RecordSort(String fName){
		try {
			inFile = new Scanner(new File(fName));
			outFile1 = new PrintWriter(new FileOutputStream("outFile1.txt", true));
			outFile2 = new PrintWriter(new FileOutputStream("outFile2.txt", true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void sortRecords(){
		tokenize();
		while(!buffer.isEmpty()){
			setRun(); // load 10 lines from buffer
			sortRun(); // sort said run
			writeFile();
		}
		done();
	}
	
	// read in entire file and break it into tokens
	public void tokenize(){
		String[] split = inFile.useDelimiter("\\Z").next().split("\n");
		buffer = new ArrayList<String>(Arrays.asList(split));		
	}
	
	
	// clears the current run
	// sets run to next 10
	public void setRun(){
		if(run == null || !run.isEmpty()){
			run = new ArrayList<String>();
		}
		for(int i=0; i<10; i++){
			run.add(buffer.remove(0));
		}
	}
	
	public void sortRun(){
		//do sort
	}
	
	// writes sorted run to either file1 | file2
	public void writeFile(){
		PrintWriter outFile;
		if(wroteFile1Last){
			// write file 2
			outFile = outFile2;
			wroteFile1Last = false;
		}else {
			// write file 1
			outFile = outFile1;
			wroteFile1Last = true;
		}
		for(String s: run){
			outFile.println(s);
		}
	}
	
	// closes files, ect
	public void done(){
		outFile1.close();
		outFile2.close();
	}
}
