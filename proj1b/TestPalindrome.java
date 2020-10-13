import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
//    @Test
//    public void TestDeque(){
//        Deque<Integer> d = new ArrayDeque<>();
//        d.addFirst(2);
//        d.printDeque();
//
//    }
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome(){

        assertFalse(palindrome.isPalindrome("abc"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("rancor"));


        CharacterComparator obo = new OffByOne();
        assertFalse(palindrome.isPalindrome("racecar",obo));
        assertTrue(palindrome.isPalindrome("flake",obo));


    }
}
//Uncomment this class once you've created your Palindrome class.