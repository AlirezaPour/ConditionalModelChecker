import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Application {
	
	
	int experimentSeries = 1;
	
	String variableName1 = "user_near_sending" ;
	int var1MaxValue = 30;
	
	String variableName2 = "wcuq_femto_1" ;
	int var2MaxValue = 1;	 
	
	double endTime = 500 ; 
	String modelName = "model.sm" ;
	int numberOfRuns=10000;	
	double snapshot = 100;
	
	String pathFileName = "path_" + variableName1 + "_" + variableName2 + "_series_" + experimentSeries + ".csv";
	
	TransientBins transientBins ; // this is initialised when the first path is generated.  
		
	
	public static void main(String[] args) throws IOException {
		
		Application application = new Application(); 
		
		application.run();

	}
	
	public void run() throws IOException{
		

		boolean firstPath = true;
		
		
		// -------------------------------------- start the loop from here. 
		
		// generate a path
		//generateOnePath();
		
		// read the path and generate its observations
		Path path = new Path(pathFileName);
		
		// when the first path is generated, initialise the bins. 
		
		if (firstPath){
			transientBins = new TransientBins(path, var1MaxValue, var2MaxValue);
			firstPath= false;
		}
		
	
		
		double atime = 400.0;
		FrequencyCollection acollection = transientBins.get(atime);
		
		BinIdentifier anId  = new BinIdentifier(20,0);
		//int afreq =  acollection.get(anId);
		boolean exist = acollection.containsKey(anId);
		
		if (exist) System.out.println("yes"); else System.out.println("Does not exist");
		
		System.out.println(acollection);
		
		
		// test : check if the transientBins is initialised correctly. 
		//System.out.println(transientBins);
		
		
		//updateTransientBins(path);
		
	}
	
		
	public void generateOnePath() throws IOException{
		
		PrismCommand prismCommand = new PrismCommand(); 
		
		
		String[] command = prismCommand.commandForPath(modelName, endTime, variableName1, variableName2, snapshot, experimentSeries, pathFileName); 
				
		//System.out.printf("command = %s \n\n" , Arrays.toString(command));
		
		ProcessBuilder probuilder = new ProcessBuilder( command );

        //You can set up your work directory
        //probuilder.directory(new File("/home/alireza/Dropbox/Academics/Thesis/TwoTierNetworkCaseStudy/Model/TwoFemtoCells"));
        
        Process process = probuilder.start();
        
      //Read out dir output
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        //System.out.printf("Output of running %s is:\n", Arrays.toString(command));
       
        
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        
		
	}

}
