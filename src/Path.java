import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Path {

	
	ArrayList<Observation> observations ;
	
	public Path (String pathFileName) {
	
		observations = new ArrayList<Observation>();
		
		Scanner in = null ;
		try {
			in = new Scanner(new FileReader(pathFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not find the path file. Terminating.");
			e.printStackTrace();
		}
		
		String line= "";
		line = in.nextLine(); // titles. we just pass the first line
		
		while(in.hasNext()){
			
			line = in.nextLine();
			
			String[] tokens = line.split(",");
			
			String currentStep = tokens[0];
			
			String currentTime = tokens[1];
			double time = Double.parseDouble(currentTime);
			
			String valueVar1 = tokens[2];
			int numericalValueVar1 = Integer.parseInt(valueVar1);
			
			String valueVar2 = tokens[3];			
			int numericalValueVar2 = Integer.parseInt(valueVar2);
			
			Observation observation = new Observation(time, numericalValueVar1, numericalValueVar2);
			
			observations.add(observation);
			
		}
		
	}
	
	public String toString (){
		
		String output = "";
		
		for (Observation obs : observations){
			
			output += obs.toString(); 
			output += "\n";
			
		}
		
		return output;
		
	}
	
 
	

}
