import java.util.*;

import static org.junit.Assert.assertFalse;

public class MyHashMap<K,V> implements Map61B<K, V>{
    /* each bucket will store values*/
    LinkedList[] buckets;
    int size =0;
    double LoadFactor=0.75; /* initial LoadFactor =0.75*/
    /* node has two property: key and value*/

    public class Node{
        K key;
        V value;
        public Node(K k, V v){
            key = k;
            value = v;
        }
    }

    /* constructor*/
    public MyHashMap(){
       buckets = new LinkedList[16];
    }
    public MyHashMap(int initialSize){
        buckets = new LinkedList[initialSize];
    }
    public MyHashMap(int initialSize, double loadFactor){
        buckets = new LinkedList[initialSize];
        LoadFactor = loadFactor;
    }

    /* return hashcode for key*/
    public int Hash(K key){
        String skey = key.toString();
        int hashcode = 0;
        for(int i=0;i<skey.length();i++){
            hashcode *=31;
            hashcode += skey.charAt(i);
        }
        return hashcode;
    }

    /* resizing*/
    public void resize(){
        LinkedList[] temp = buckets;
        buckets = new LinkedList[temp.length*2];

        for(int i=0;i< temp.length;i++){
            /* if temp[i] != null then go into temp[i]*/
            if(temp[i] != null){
                for(int j=0;j<temp[i].size();j++){
                    Node nodej = (Node)temp[i].get(j);
                    put(nodej.key, nodej.value);
                    size -=1;
                }
            }

        }
    }
    /** Removes all of the mappings from this map. */
    public void clear(){
        Arrays.fill(buckets, null);
        size = 0;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        int hashcode = Hash(key);
        int pos = Math.abs(hashcode%buckets.length); /* find which bucket key belongs to*/

        if(buckets[pos] == null){
            return false;
        } else{
            for(int i=0;i<buckets[pos].size();i++){
                /* get the node of the key-value*/
                Node nodei = (Node)buckets[pos].get(i);
                if( key.equals(nodei.key)){
                  return true;
                }
            }
           return false;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        /*check if contains key*/
        if(containsKey(key)){
            int hascode = Hash(key);
            int pos = Math.abs(hascode% buckets.length);
            for(int i=0;i<buckets[pos].size();i++){
                Node nodei = (Node)buckets[pos].get(i);
                if(key.equals(nodei.key)){
                    return nodei.value;
                }
            }

        }
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size(){
        return size;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K key, V value){

        if((1.0*size/ buckets.length*1.0)>=LoadFactor){
            resize();
        }
        int hashcode = Hash(key);
        int pos = Math.abs(hashcode% buckets.length);
        /*  if buckets[pos] == null*/
        if(buckets[pos] == null){
            /* create new linkedlist*/
            buckets[pos] = new LinkedList();
            Node node = new Node(key,value);
            buckets[pos].add(node);
            size+=1;
        } else{
            /* not null, there are two possible situations:
            1) key exists inside the hashmap-> renew the value
            2) key doesn't exist -> add the node to the end of the LinkedList
        */
            boolean flag = true;
            for(int i=0;i<buckets[pos].size();i++){
                 Node nodei = (Node)buckets[pos].get(i);
                 /* situation 1*/
                 if(key.equals(nodei.key)){
                     nodei.value = value;
                     flag = false; /* indicate that key exists*/
                 }
            }
            /* situation 2*/
            if(flag){
                Node node = new Node(key,value);
                buckets[pos].add(node);
                size+=1;
            }
        }
    }

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        Set<K> keys = new HashSet<K>();
        for(int i=0;i<buckets.length;i++){
            if(buckets[i]!=null){
                for(int j=0;j<buckets[i].size();j++){
                    Node nodej = (Node)buckets[i].get(j);
                    keys.add(nodej.key);
                }
            }
        }
        return keys;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }


    public static void main(String[] args){
        MyHashMap<String, Integer> b = new MyHashMap<String, Integer>();
        for(int i=0;i<20;i++){
            b.put("I"+i,i);
            boolean flag;
            flag = b.containsKey("I"+i);
            System.out.println(flag);
        }

    }
}
