import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class TransientBins extends HashMap<Double, FrequencyCollection>{

		ArrayList<Double> timePoints;
	
		public TransientBins(Path path, int var1MaxValue, int var2MaxValue){
			
			super();
		
			FrequencyCollection freqColl;
			
			
			
			for(Double timePoint : timePoints){
				
				freqColl = new FrequencyCollection(var1MaxValue, var2MaxValue);
				this.put(timePoint, freqColl);
				
			}
			
		}
	
		
		@Override
		public String toString() {
			
			
			String output = "";
			FrequencyCollection fcoll; 
			
			Iterator<Double> iter = this.keySet().iterator(); 
			
			while(iter.hasNext()){
				Double time = iter.next();
				fcoll = this.get(time);
				output += String.format("%s :\n%s \n", Double.toString(time) , fcoll.toString() );
			}
			
			return output;
			
		}
		
		
}
