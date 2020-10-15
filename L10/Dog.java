import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }
    @Override
    public int compareTo(Dog d2){
        return this.size - d2.size;
   }

    /* name comparator*/
   private static class NameComparator implements Comparator<Dog>{
       @Override
        public int compare(Dog d1,Dog d2){
            return d1.name.compareTo(d2.name);
        }
   }
   public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
   }

    /* size comparator*/
    private static class SizeComparator implements Comparator<Dog>{
        @Override
        public int compare(Dog d1,Dog d2){
            return d1.size -d2.size;
        }
    }
    public static Comparator<Dog> getSizeComparator(){
        return new SizeComparator();
    }

}
