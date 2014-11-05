
public class Observation {

	public double time; 
	public int var1; 
	public int var2;
	
	public Observation(double time, int var1, int var2){
		this.time = time; 
		this.var1 = var1; 
		this.var2 = var2; 
	}
	
	public String toString(){
		
		String output = String.format("%f,%d,%d", time, var1, var2);
		return output; 
		
	}
	
	
}
