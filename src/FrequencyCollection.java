import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class FrequencyCollection extends HashMap<BinIdentifier, Integer>{
	

	int var1MaxValue;
	int var2MaxValue;
	
	public FrequencyCollection(int var1MaxValue, int var2MaxValue){
		
		super();
		
		this.var1MaxValue = var1MaxValue ; 
		this.var2MaxValue = var2MaxValue ; 
		
		
		BinIdentifier identifier;
		
		for (int i = 0 ; i <= var1MaxValue; i ++){
			
			for (int j = 0 ; j <= var2MaxValue; j ++){
				
				identifier = new BinIdentifier(i, j);
				this.put(identifier, 0);
				
			}
			
		}
	
	}
	
	
	@Override
	public String toString(){
		
		String output = "";
		BinIdentifier identifier;
		int freq; 
		
		Iterator<BinIdentifier> iter = this.keySet().iterator(); 
		
		while(iter.hasNext()){
			BinIdentifier id = iter.next();
			freq = this.get(id);
			output += String.format("%s : %d \n", id.toString() , freq );
		}
		
		return output;
		
	}
	
}
