public class Dog extends Animal{
    public Dog(){
        super(12,1);
    }
    public int getage(){
        return noise;
    }
    public void makeNoise(){
        maknoise();
    }

    public static void main(String[] args){
        Dog d1 = new Dog();
        Animal A1 = d1;
    }
}
