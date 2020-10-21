package solution2;
import java.util.Comparator;
/* solution2 使用的是 comparator*/
public class AnimalLauncher {


    public static void main(String[] args){
        Dog[] dogs = {new Dog("Elyse", 3),
                new Dog("Sture", 9), new Dog("Benjamin", 15)};
        Dog d = (Dog)Maximizer.max(dogs);
        d.bark();

        Cat[] cats = {new Cat("cici",1),new Cat("pipi",2),new Cat("didi",3)};
        Cat c = (Cat)Maximizer.max(cats);
        c.mieo();

        Comparator<Dog> nc = Dog.getNameComparator();
        if(nc.compare(dogs[1],dogs[2])>0){ // if dogs[1] comes later than dogs[2] in alphabet
            dogs[1].bark();
        }else{
            dogs[2].bark();
        }


        Comparator<Dog> sc = Dog.getSizeComparator();
        if(sc.compare(dogs[0],dogs[2]) >0){ // if dogs[1].size > dogs[2].size
            dogs[0].bark();
        }else{
            dogs[2].bark();
        }
    }
}
