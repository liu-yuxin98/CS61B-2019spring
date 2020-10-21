public class Cat extends Animal {
    public Cat(String name,int age){
        super(name,age);
    }
    @Override
    public void greet() {
        if (this.age <= 5) {
            System.out.println("Cat " + name + " says: " + "MEOW");
        } else {
            System.out.println("Cat " + name + " says: " + "Meow");
        }
    }


    public static void main(String[] args){
        Cat c = new Cat("tiit",3);
        c.greet();
    }
}
