public class OffByOne implements CharacterComparator {
    /** Returns true if characters are equal by the rules of the implementing class. */
    @Override
    public boolean equalChars(char x, char y){
        int a= x;
        int b = y;
        if(Math.abs(a-b)==1){
            return true;
        }
        return false;
    }
}
