import edu.princeton.cs.algs4.BST;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V>  implements Map61B<K, V> {
    private Node root;

    private class Node{
        public K key;
        public V value;
        public int size;
        public Node left;
        public Node right;

        public Node(K k,V v,int n){
            this.key = k;
            this.value = v;
            this.size = n;
        }
    }



    @Override
    /** Removes all of the mappings from this map. */
    public void clear(){
        root = null;
    }

    @Override
    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        return get(key)!=null;
    }

    @Override
    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
       return get(root,key);
    }

    private V get(Node T,K key){
        if(key == null){
            return null;
        }
        if(T == null){
            return null;
        }
        int cmp = key.compareTo(T.key);
        if(cmp>0){
            return get(T.right,key);
        } else if (cmp<0){
            return get(T.left,key);
        } else{
            return T.value;
        }
    }


    @Override
    /* Returns the number of key-value mappings in this map. */
    public int size(){
        if(root == null){
            return 0;
        }
        return root.size;
    }
    /* Returns the number of key-value mappings in the map whose root is T. */
    public int size(Node T){
        if(T == null){
            return 0;
        }
        return T.size;
    }

    @Override
    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value){
        root = put(root,key,value);
    }
    private Node put(Node T, K key,V value){
        if(key==null){
            throw new NullPointerException("key ==null");
        }
        if(T == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(T.key);
        if(cmp>0){
            T.right = put(T.right,key,value);
        } else if(cmp<0){
            T.left = put(T.left,key,value);
        }
        T.size += 1;
        return T;
    }
    @Override
    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        return KeySet(root);
    }

    private Set<K> KeySet(Node T){
        Set<K> keys = new HashSet<>();
        if(T.left==null && T.right ==null){
            keys.add(T.key);
        }
        if(T.left!=null && T.right == null){
           Set<K> tempkeys = KeySet(T.left);
           keys.addAll(tempkeys);
           keys.add(T.key);
        }
        if(T.left == null && T.right!=null){
            keys.add(T.key);
            Set<K> tempkeys = KeySet(T.right);
            keys.addAll(tempkeys);
        }
        if(T.left!=null && T.right!=null){
            Set<K> tempkeys = KeySet(T.left);
            keys.addAll(tempkeys);
            keys.add(T.key);
            Set<K> rtempkeys = KeySet(T.right);
            keys.addAll(rtempkeys);
        }
        return keys;
    }

    @Override
    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){
       V kvalue = get(key);
       root = remove(root,key);
       return kvalue;
    }

    private Node remove(Node T,K k){
        if(T == null){
            return null;
        }
        if(k == null){return null;}
        int cmp = k.compareTo(T.key);
        if(cmp>0){
            T.right = remove(T.right,k);
        } else if(cmp<0){
            T.left = remove(T.left,k);
        } else{ /* T.key = k*/
            /* zero child*/
            if(T.left ==null && T.right ==null){
                T = null;
                return T;
            } else if(T.left ==null && T.right!=null ){ /* one child*/
                T = T.right;
            } else if(T.right == null && T.left!=null){ /* one child*/
                T = T.left;
            } else{ /* two children*/
                Node prenode = pre(T);
                if(prenode == T.left){ /* pre node doesn't have children*/
                    T.left = prenode.left;
                    prenode.left = null;
                    T.key = prenode.key;
                    T.value = prenode.value;
                } else { /* prenode isn't directly connect to node T*/
                    prenode = remove(prenode, prenode.key);
                    prenode.left = T.left;
                    prenode.right = T.right;
                    T = prenode;
                }

            }
        }
        T.size = size(T.left)+size(T.right)+1;
        return T;
    }

    public Node pre(Node T){
        Node p = T.left;
        while(p.right!=null){
            p = p.right;
        }
        return p;
    }


    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }


    private class BSTiterator<K> implements Iterator<K> {
        public boolean hasNext(){
            return false;
        }
        public K next(){
            return null;
        }
    }
    @Override
    public  BSTiterator iterator(){
       return new BSTiterator();
    }
    /*
    *  prints out  BSTMap in order of increasing Key*/
    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(Node T){
        if(T.left == null && T.right == null){
            System.out.println(T.key+" "+T.value);
        }
        if(T.right != null && T.left !=null){
            printInOrder(T.left);
            System.out.println(T.key+" "+T.value);
            printInOrder(T.right);
        }
        if(T.left ==null && T.right!=null){
            System.out.println(T.key+" "+T.value);
            printInOrder(T.right);
        }
        if(T.right == null && T.left!=null){
            printInOrder(T.left);
            System.out.println(T.key+" "+T.value);
        }
    }


    /* find the smallest key in the BSTMap, return that key*/
    public K getMin(){
        return getMin(root);
    }

    private K getMin(Node T){
        if(T == null){
            return null;
        }
        if(T.left == null){
            return T.key;
        }
        else{
           return getMin(T.left);
        }
    }




}
