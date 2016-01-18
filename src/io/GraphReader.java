package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import core.Graph;
import core.Node;

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
				
				if(g.getNode(n1) == null)
					g.addNode(n1);
				
				try {
					String edge = sc.next();
					String n2 = sc.next();
					
					if ( (g.getNode(n2)) == null)
						g.addNode(n2);
					g.getNode(n1).addEdge(edge, g.getNode(n2));
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
