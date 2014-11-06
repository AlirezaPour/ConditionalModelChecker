import java.util.ArrayList;
import java.util.Iterator;


public class TransientFrequencies extends ArrayList<Frequencies> {
	
	
	public TransientFrequencies(Path path, int var1MaxValue, int var2MaxValue){
		super();
		
		// fill in the frequencies with the data. 
		ArrayList<Double> timePoints = new ArrayList<Double>(); 
		
		for (Observation observation : path.observations){
			double time = observation.time;
			timePoints.add(time);
		}
		
		for(Double timePoint : timePoints){
			Frequencies freqs = new Frequencies(timePoint, var1MaxValue, var2MaxValue);
			this.add(freqs);
			
		}
		
	}

	private static final long serialVersionUID = 1L;

	public Frequencies getFrequenciesOfTime(double time){
		
		Frequencies freqs ; 
		
		Iterator<Frequencies> iter = this.iterator();
		
		while(iter.hasNext()){
			
			freqs = iter.next(); 
			
			if (freqs.getTime() == time ) return freqs;
			
		}
		
		return null;
		
	}
	
}
