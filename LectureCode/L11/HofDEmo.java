public class HofDEmo {
    public  static int do_twice(intFunction f,int x){
        return f.apply(f.apply(5));
    }

    public static void main(String[] args){
        intFunction tenX = new tenx();
        System.out.println( do_twice(tenX,5) );
    }
}
