package supercrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Vilket ord söker du efter: ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.next();
		
		File folder = new File("./filefolder");
		File[] listOfFiles = folder.listFiles();
		
		folderPath(folder.getAbsolutePath(), userInput);
	}
		
	
	private static void folderPath(String Path, String userInput) {
		File newPath = new File(Path);
		File[] listOfFiles = newPath.listFiles();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
			    Scanner scanner = null;
			    try {
			    	scanner = new Scanner(listOfFiles[i]);
			    	while (scanner.hasNext()) {
			    		String content = scanner.next();
			    		if (userInput.equalsIgnoreCase(content)) {
			    			System.out.println("Ditt sökord: " + "'" + userInput + "'" + " finns i denna textfil:");
			    			System.out.println(listOfFiles[i].getAbsolutePath());
			    			break;
			    		} else {
			    			// System.out.println("Ordet överensstämmer ej.");
			    		}
			    	}
			    } catch (FileNotFoundException e) {
			    	e.printStackTrace();
			    }
			  } else if (listOfFiles[i].isDirectory()) {
				  folderPath(listOfFiles[i].getAbsolutePath(), userInput);
			  }
		}
	}
}

