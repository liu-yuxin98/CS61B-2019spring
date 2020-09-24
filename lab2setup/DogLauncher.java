/** doglauncher */
public class DogLauncher {
	public static void main(String[] args){
		/* create two dogs*/
		Dog d1 = new Dog(35);
		Dog d2 = new Dog(15);
		/* using class methods to compare weight*/
		Dog wd = Dog.compare(d1,d2);
		System.out.println(wd.weight);

		/* using instance methods to compare weight*/
		Dog wd2 = d1.instanceCompare(d2);
		System.out.println(wd2.weight);

		/* create dog arrays*/
		Dog [] dogs = new Dog[3];
		dogs[0] = new Dog(18);
		dogs[1] = new Dog(56);
		dogs[2] = new Dog(34);
		/* get max dog, class method*/
		Dog maxdog = Dog.MaxDog(dogs);
		maxdog.makeNoise();
		System.out.println(maxdog.weight);
		}
	}