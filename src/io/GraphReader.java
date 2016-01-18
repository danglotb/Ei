package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import core.Graph;

public class GraphReader {
	
	public static Graph read(String pathname) {
		
		Graph g = new Graph();
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(pathname));
			
			String line = null;
			
			while ((line = br.readLine()) != null) {
				
				Scanner sc = new Scanner(line);
				sc.useDelimiter("\t");
				
				String n1 = sc.next();
				try {
					String edge = sc.next();
					String n2 = sc.next();
				} catch (NoSuchElementException e) {
					//No need to had Edge so
				}
				
				sc.close();
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return g;
	}
	

}
