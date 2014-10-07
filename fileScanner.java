package output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileScanner {

	private String pathRead = "";
	private String pathWrite = "";
	
	public fileScanner(String IN, String OUT){
		pathRead = IN; 
		pathWrite = OUT;
	}
	
	public String[] read(int units) {
		String[] toread = new String[units];
		
		// INPUT: SCANNER
				int i = 0; 	// counter for the number of integers in the file

				try{	
					File fname = new File( this.pathRead );
					Scanner input2program = new Scanner (fname);
					String stringInt = "";
					while ( input2program.hasNext() ){
						stringInt = input2program.nextLine();
						toread[i] = stringInt;
						i = i + 1;
					}			
					input2program.close();				
					} catch( FileNotFoundException e ){
							e.printStackTrace();
				}
		
		return toread;
	}
	public void write(String[] toprint, int length ){
		String write2file = this.pathWrite;
		File wrname = new File (write2file);
		try{
			PrintWriter wrfile = new PrintWriter (wrname);	
			for (int i = 0; i < length; i++){
				wrfile.println(toprint[i]);
			}
			wrfile.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}		
	}
}
