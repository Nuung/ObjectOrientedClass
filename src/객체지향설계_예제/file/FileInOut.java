package 객체지향설계_예제.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInOut {

	private File readFile;
	private File writeFile;
	
	public FileInOut(String path1, String path2) {
		// Create File object
		this.readFile = new File(path1);
		this.writeFile = new File(path2);
		
		try {
			
			// Make (Stream) Reader and Writer about File Object
			BufferedReader reader = new BufferedReader(new FileReader(readFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile));
			String inputString; 
			
			// reading all inputString untill the end
			while((inputString = reader.readLine()) != null) {
				// and ataching them all to writer object (writeFile -> test2.txt)
				writer.write(inputString + "-Line clear");
			} // while 
			
			// clear all object
			reader.close();
			writer.close();
			readFile.delete();
			
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		} // try ~ catch
		
		System.out.println("Done2....");
	}
}
