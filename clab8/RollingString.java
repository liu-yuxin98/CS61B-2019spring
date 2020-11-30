import sun.java2d.pipe.AAShapePipe;

import java.util.ArrayList;

/**
 * A String-like class that allows users to add and remove characters in the String
 * in constant time and have a constant-time hash function. Used for the Rabin-Karp
 * string-matching algorithm.
 */
class RollingString{

    private int size;
    private ArrayList<Integer> chars;

    /**
     * Number of total possible int values a character can take on.
     * DO NOT CHANGE THIS.
     */
    static final int UNIQUECHARS = 128;

    /**
     * The prime base that we are using as our mod space. Happens to be 61B. :)
     * DO NOT CHANGE THIS.
     */
    static final int PRIMEBASE = 6113;


    /**
     * Initializes a RollingString with a current value of String s.
     * s must be the same length as the maximum length.
     */


    public RollingString(String s, int length) {
        assert(s.length() == length);
        /* FIX ME */
        size = length;
        chars  = new ArrayList<Integer>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            int nc = (int)c;
            if(nc>UNIQUECHARS){
                System.out.println("Invalid input");
                break;
            }
            chars.add(nc);
        }
    }

    /**
     * Adds a character to the back of the stored "string" and 
     * removes the first character of the "string". 
     * Should be a constant-time operation.
     */
    public void addChar(char c) {
        int nc = (int)c;
        chars.remove(0);
        chars.add(nc);
        /* FIX ME */
    }


    /**
     * Returns the "string" stored in this RollingString, i.e. materializes
     * the String. Should take linear time in the number of characters in
     * the string.
     */
    public String toString() {
        StringBuilder strb = new StringBuilder();
        /* FIX ME */
        for(int n:chars){
            char c = (char)n;
            strb.append(c);
        }
        return strb.toString();
    }

    /**
     * Returns the fixed length of the stored "string".
     * Should be a constant-time operation.
     */
    public int length() {
        /* FIX ME */
        return size;
    }


    /**
     * Checks if two RollingStrings are equal.
     * Two RollingStrings are equal if they have the same characters in the same
     * order, i.e. their materialized strings are the same.
     */
    @Override
    public boolean equals(Object o) {
        /* FIX ME */
        if(o == null){
            return false;
        }
        if(! (o instanceof RollingString)){
            return false;
        } else{
            RollingString ro = (RollingString)o;
            for(int i =0;i<size;i++){
                    if(chars.get(i)!=ro.chars.get(i)){
                        return false;
                    }
            }
            return true;
        }

    }

    /**
     * Returns the hashcode of the stored "string".
     * Should take constant time.
     */
    @Override
    public int hashCode() {
        int hashvalue = 0;
        for(int i=0;i<size;i++){
            hashvalue = hashvalue*PRIMEBASE;
            hashvalue += chars.get(i);
        }
        return hashvalue;
    }

    public static void main(String[] args){
        RollingString rl1 = new RollingString("james",5);
        System.out.println(rl1.hashCode());
        System.out.println(rl1.hashCode());
    }
}
