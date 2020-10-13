import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestequalChars(){
        assertEquals(true,offByOne.equalChars('a','b'));
        assertEquals(true,offByOne.equalChars('&','%'));
        assertEquals(false,offByOne.equalChars('a','B'));
    }
}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.