
public class algo 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		long time = System.nanoTime();

		AlgorithmLab.algorithm1(10);

		System.out.println((System.nanoTime()-time)/1000000000.0);
		
		
		long time2 = System.nanoTime();

		AlgorithmLab.algorithm2(10);

		System.out.println((System.nanoTime()-time2)/1000000000.0);
		
		
		long time3 = System.nanoTime();

		AlgorithmLab.algorithm3(10);

		System.out.println((System.nanoTime()-time3)/1000000000.0);
		
		long time4 = System.nanoTime();

		AlgorithmLab.algorithm4(10);

		System.out.println((System.nanoTime()-time4)/1000000000.0);
		
		
		long time5 = System.nanoTime();

		AlgorithmLab.algorithm5(10);

		System.out.println((System.nanoTime()-time5)/1000000000.0);
	}
	
	

}
