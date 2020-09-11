public class Dog {
	public int weightInPounds;
 	/** constructor for Dog*/
 	public Dog(int w){
 		weightInPounds = w;
 	}
	public  void makeNoise(){
		if(weightInPounds<10){
			System.out.println("yep yep yep");
		} else if(weightInPounds<30){
			System.out.println("wag wag wnag");
		} else {
			System.out.println("wooofwoooof");
		}
		
	}
	}