
public class PrismCommand {
	
	public PrismCommand(){
		
	}
	
	public String[] commandForPath(String modelName, double endTime, String variableName1, String variableName2,double snapshot, int experimentSeries, String pathFileName){

		
		String[] command = {"/home/alireza/PRISM/prism-4.2.beta1-linux64/bin/prism", modelName , "-simpath", "time="+endTime+",snapshot="+snapshot+",vars=("+variableName1 + "," + variableName2 + "),sep=comma", pathFileName, "-simpathlen", "100000000"};						
		return command;
		
	}
}
