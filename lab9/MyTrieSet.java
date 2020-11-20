import java.util.*;

public class MyTrieSet implements TrieSet61B{


    /* DataIndexedCharMap*/
    public class DataIndexedCharMap<V> {
        private V[] items;
        /* constructor*/
        public DataIndexedCharMap(int R) {
            items = (V[]) new Object[R];
        }
        /* put (c,x) key-value pairs into items*/
        public void put(char c, V x) {
            items[c] = x;
        }
        public V get(char c) {
            if (c < 0 || c > R - 1) return null;
            return items[c];
        }
        /* return keys of the items*/
        public Set<Character> keys(){
            Set<Character> allkeys = new HashSet<>();
            for(int i=0;i<items.length;i++){
                if(items[i]!=null){
                    char c = (char)(i);
                    allkeys.add(c);
                }

            }
            return allkeys;
        }

        public boolean contains(char c) {
            return get(c) != null;
        }
    }

    private static final int R = 128;
    private Node root; /* root of tries*/
    int n; /* number of keys*/

    /* node */
    private class Node{
        boolean isKey; /* weather iskey*/
        private DataIndexedCharMap<Node> next; /* store nodes*/
        private Node(){
            isKey =false;
            next = new DataIndexedCharMap<>(R);
        }
    }

    public MyTrieSet(){
        root = new Node();
    }

    /** Clears all items out of Trie */
    public void clear(){
        root = null;
    }

    /** Returns true if the Trie contains KEY, false otherwise */
    public boolean contains(String key){
        return contains(key,root,0);
    }

    private boolean contains(String key,Node x,int d){
        char c = key.charAt(d);
        if(x.next.contains(c)){
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
                root = add(key,root,0);
    }

    private Node add(String key,Node x,int d){
        if(key == null){
            throw new NullPointerException();
        }
        char c = key.charAt(d);
        if(d == key.length()-1){
            x.next.put(c,new Node());
            x= x.next.get(c);
            x.isKey = true;
            return x;
        } else{
           /* two situation
           * 1) x contains c
           * 2) x doesn't contains c*/
            if(x.next.contains(c)){
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
        List<String> x = new LinkedList<>();
        Node a = root;
        /* let node x points to the last character of prefix*/
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(a.next.contains(c)){
                a = a.next.get(c);
            } else{
                return null;
            }
        }
        /* x points to last character of prefix*/
        for(char c:a.next.keys()){
            collecthelper(prefix+c,x,a.next.get(c));
        }
        return x;
    }


    public List<String> collect(){
            List<String> x = new ArrayList<>();
            for(char c:root.next.keys()){
                String s = String.valueOf(c);
                collecthelper(s,x,root.next.get(c));
            }
        return x;
    }

    private List<String> collecthelper(String s,List<String> x,Node n){
        if(n.isKey){
            x.add(s);
        }
        for(char c:n.next.keys()){
            collecthelper(s+c,x,n.next.get(c));
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

    public static void main(String[] args) {
        MyTrieSet t = new MyTrieSet();
        t.add("hello");
        t.add("hi");
        t.add("help");
        t.add("zebra");
        System.out.println(t.contains("hello"));
        System.out.println(t.contains("hi"));
        System.out.println(t.contains("help"));
        System.out.println(t.contains("zebra"));
        System.out.println(t.contains("heglo"));
        List<String> ls = t.collect();
        for(String s:ls){
            System.out.println(s);
        }
        List<String> ls2 = t.keysWithPrefix("he");
        for(String s:ls2){
            System.out.println(s);
        }


//        for(int i = 65;i<123;i++){
//            char ch = (char)(i);
//            System.out.println(ch);
//        }


    }
}
