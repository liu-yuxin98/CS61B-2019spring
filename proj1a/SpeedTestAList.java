public class SpeedTestAList {
    public static void main(String[] args){
        AList L = new AList();
        int i = 0;
        int N =100000;
        while(i<N){
            L.addLast(i);
            i += 1;
        }
    }
}
