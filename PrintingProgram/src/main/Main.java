package main;

import java.awt.Desktop;
import java.io.BufferedReader;  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import objects.Printer;


import javax.print.*;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;



public class Main  

  {
	public static void main(String[] args) throws InterruptedException, IOException {
	String location = "";
	String name = "";
	Scanner in = new Scanner(System.in);
	
   //	File saveData = new File("C:\\eclipse2023\\PrintingProgram\\src\\res\\saveData.txt");
  // Scanner reader = new Scanner("C:\\eclipse2023\\PrintingProgram\\src\\res\\saveData.txt");
 //  FileWriter writer = new FileWriter("C:\\eclipse2023\\PrintingProgram\\src\\res\\saveData.txt");
    BufferedReader br = new BufferedReader(new FileReader("C:\\eclipse2023\\PrintingProgram\\src\\res\\saveData.txt"));     
    
   
	System.out.println("All Done!\nNow insert the path to the folder and press enter");
	boolean isDir = false;
	File dir;
	File[] listOfFiles = new File[1];
	while(isDir == false) {
	String pathToFolder = in.nextLine();
	dir = new File(pathToFolder);
	listOfFiles = dir.listFiles();
	if(dir.isDirectory() == false) {
		System.out.println("That's not a valid path to a directory (folder). Try again and press enter.");
	}
	else {
		for(int i =0; i< listOfFiles.length;i++ ) {
			if(listOfFiles[i].isDirectory() == true) {
				System.out.println("This is a valid path to a directory (folder), but it contains a directory as well. Try again with a directory that contains only leaves (single files)");
			}
		}
		isDir = true;
	}
	
	}
	
	Desktop desk = Desktop.getDesktop();
	for(int i =0; i< listOfFiles.length;i++ ) {
    desk.print(listOfFiles[i]);
	}
	}}