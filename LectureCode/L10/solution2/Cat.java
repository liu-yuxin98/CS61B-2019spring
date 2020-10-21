package solution2;
public class Cat implements  Comparable<Cat>{
    private String name;
    private int size;

    public Cat(String n, int s) {
        name = n;
        size = s;
    }

    public void mieo() {
        System.out.println(name + " says: mieo");
    }
    @Override
    public int compareTo(Cat c2){
        return this.size - c2.size;
    }
}
