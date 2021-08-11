public class OffByN implements CharacterComparator {
    public int N;
    public OffByN(int n){
        N =n;
    }
    @Override
    public boolean equalChars(char x, char y){
        int a= x;
        int b = y;
        if(Math.abs(a-b)==N){
            return true;
        }
        return false;
    }
}
