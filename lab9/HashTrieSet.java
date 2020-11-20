import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HashTrieSet implements TrieSet61B {

    private Node root; /* root of tries*/
    int n; /* number of keys*/

    /* node */
    private class Node{
        boolean isKey; /* weather iskey*/
        HashMap<Character,Node> next;
        private Node(){
            isKey =false;
            next = new HashMap<>();
        }
    }
    public HashTrieSet(){
        root = new Node();
        n = 0;
    }


    /** Clears all items out of Trie */
    public void clear(){
        root = null;
    }
    /** Returns true if the Trie contains KEY, false otherwise */
   public boolean contains(String key){
        return  contains(key,root,0);
    }

   private boolean contains(String key, Node x,int d){
       if(key == null){
           throw new NullPointerException();
       }
       char c = key.charAt(d);
       if(x.next.containsKey(c)){
           if(d == key.length()-1){
               x = x.next.get(c);
               return x.isKey;
           }
           return contains(key,x.next.get(c),d+1);
       } else{
           return false;
       }

   }

    /** Inserts string KEY into Trie */
    public void add(String key){
            add(key,root,0);
    }

    private Node add(String key,Node x,int d){
        if(key == null){
            throw new NullPointerException();
        }
        char c = key.charAt(d);
        /* to the end character*/
        if(d == key.length()-1){
            x.next.put(c,new Node());
            x = x.next.get(c);
            x.isKey = true;
            return x;
        } else{
            /* two situation
             * 1) x contains c
             * 2) x doesn't contains c*/
            if(x.next.containsKey(c)){
                Node t = x.next.get(c) ;
                t  = add(key,x.next.get(c),d+1);
            } else{
                x.next.put(c,new Node());
                Node t = x.next.get(c) ;
                t = add(key,x.next.get(c),d+1);
            }
            return x;
        }

    }

    /** Returns a list of all words that start with PREFIX */
    public List<String> keysWithPrefix(String prefix){
        if(prefix == null){
            throw new NullPointerException();
        }
        List<String> x = new LinkedList<>();
        Node a = root;
        /* let node x points to the last character of prefix*/
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(a.next.containsKey(c)){
                a = a.next.get(c);
            } else{
                return null;
            }
        }
        /* x points to last character of prefix*/
        for(char c:a.next.keySet()){
            CollectHelper(prefix+c,x,a.next.get(c));
        }
        return x;

    }



    /** Returns the longest prefix of KEY that exists in the Trie
     * Not required for Lab 9. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public String longestPrefixOf(String key){
      throw new UnsupportedOperationException();

    }

    public List<String> Collect(){
        List<String> ls = new ArrayList<>();
        for(char c:root.next.keySet()){
            CollectHelper(String.valueOf(c),ls,root.next.get(c));
        }
        return ls;
    }

    private List<String> CollectHelper(String s,List<String> ls,Node x){
        if(x.isKey){
            ls.add(s);
        }
        for(char c:x.next.keySet()){
            CollectHelper(s+c,ls,x.next.get(c));
        }
        return ls;
    }

    public static void main(String[] args) {
//        HashTrieSet t = new HashTrieSet();
//        t.add("hello");
//        t.add("hi");
//        t.add("help");
//        t.add("zebra");
//        System.out.println(t.contains("hello"));
//        System.out.println(t.contains("hi"));
//        System.out.println(t.contains("help"));
//        System.out.println(t.contains("zebra"));
//        System.out.println(t.contains("heglo"));
//        List<String> ls = t.Collect();
//        for(String s:ls){
//            System.out.println(s);
//        }
//        List<String> ls2 = t.keysWithPrefix("he");
//        for(String s:ls2){
//            System.out.println(s);
//        }

    }
}
