import java.util.ArrayList;
import java.util.Iterator;


public class Frequencies extends ArrayList<Frequency> {

	private static final long serialVersionUID = 1L;
	
	private double time; 
	
	
	public Frequencies(double timePoint, int var1MaxValue, int var2MaxValue){
		super();
		
		this.time = timePoint; 
		
		for ( int i=0 ; i <= var1MaxValue ; i++ ){
			
			for (int j=0 ; j <= var2MaxValue ; j++){
				
				BinIdentifier binId = new BinIdentifier(i,j); 
				
				Frequency freq = new Frequency(binId); 
				
				this.add(freq);
				
			}
		}
		
	}

	public Frequency getFrequencyOf(BinIdentifier id){
		
		Iterator<Frequency> iter = this.iterator();
		
		Frequency freq;
		
		while(iter.hasNext()){
			
			freq = iter.next();
			
			if ((freq.binId).equals(id)) return freq;
			
		}
		
		return null;
		
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	
	
}
