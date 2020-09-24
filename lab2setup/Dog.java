public class Dog {
	/* instance variables*/
	public int weight;
	/* class variables*/
	public static String dogsType ="animal";
	public  Dog(int w){
		weight = w;
	}

	public void makeNoise(){
		if ( weight<15){
			System.out.println("yel yel ");
		}else{
			System.out.println("woof woof");
		}
	}

	/** static methods, compare two dogs weight
	invoke by Dog.compare(d1,d2)
	*/
	public static Dog compare(Dog d1, Dog d2){
		if (d1.weight >= d2.weight){
			return d1;
		}else{
			return d2 ;
		}	
	}

	/** non-static methods, compare two dogs weight
	invoke by  d1.instanceCmpare(d2);
	*/
	public Dog instanceCompare(Dog d2){
		if(this.weight>=d2.weight){
			return this;
		}else{
			return d2;
		}
	}		


	/*return the weightest dog in a dog array*/
	public static Dog MaxDog(Dog [] dogs){
		int index = 0;
		int maxweight = dogs[0].weight;
		for(int i =0;i<dogs.length;i++){
			if(dogs[i].weight>=maxweight){
				maxweight = dogs[i].weight;
				index = i;
			}
		}
		return dogs[index];
	}
	
	
	}