public class SpeedTestSList {
    public static void main(String[] args){
        SLList<Integer> L = new SLList<Integer>(1);
        int i = 0;
        int N =100000;
        while(i<N){
            L.addlast(i);
            i += 1;
        }
    }
}
