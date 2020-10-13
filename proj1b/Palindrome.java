public class Palindrome {
    public Deque<Character> wordToDeque(String word){
       Deque<Character> result = new ArrayDeque<>();
       for(int i =0;i<word.length();i++){
           result.addLast(word.charAt(i));
       }
        return result;
    }
    /*return true if the word is a palindrome according to the character comparison
    test provided by the CharacterComparator
     */
    public boolean isPalindrome(String word, CharacterComparator cc){
       int length = word.length();
       if(length<=1){
           return true;
       }
       else{
           for(int i=0;i< (int)length/2;i++){
               char f = word.charAt(i);
               char l = word.charAt(length-i-1);
               if(!cc.equalChars(f,l)){
                   return false;
               }
           }
           return true;
       }
    }

    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        if(d.size()<=1){
            return true;
        }else{
            boolean flag = true;
            while(true){
                if(d.size()<=1){
                    break;
                }
                if(d.removeFirst()!=d.removeLast()){
                    flag = false;
                    break;
                }
            }
            return flag;

        }

    }
}
