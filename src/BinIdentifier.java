
public class BinIdentifier {

	int value1 ;
	int value2 ;
	
	public BinIdentifier(int value1, int value2){
		this.value1 = value1;
		this.value2 = value2; 
	}
	
	@Override
	public boolean equals(Object obj) {
		
		BinIdentifier fidentifier = (BinIdentifier) obj;
		
		if ( (this.value1 == fidentifier.value1) & (this.value2 == fidentifier.value2) ) return true;
		
		return false;
		
	}
	
	
	@Override
	public String toString(){
		
		String output = "";
		
		output = String.format("<%d,%d>", value1 , value2 );
			
	
		return output;
		
		
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	
}
