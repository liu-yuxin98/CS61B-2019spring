/* write my own BST*/
public class BST<Key extends Comparable<Key>,Value>{
    public Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int n;
        public Node(Key k,Value v,int ns){
            this.key = k;
            this.value = v;
            this.n = ns;
        }
        public Node(){
            this.key = null;
            this.value = null;
            this.n = 0;
        }
    }


    /* size*/
    public int size(){
        return size(root);
    }
    private int size(Node T){
        if(T ==null){
            return 0;
        }
        return T.n;
    }

    /* is empty*/
    public boolean isEmpty(){
        return size(root) ==0;
    }

    /* search key*/
    public Value Search(Key sk){
        return Search(root,sk);
    }
    private Value Search(Node T,Key sk){
        if(T == null){
            return null;
        }
        int cmp = sk.compareTo(T.key);
        if(cmp>0){
            return Search(T.right,sk);
        } else if(cmp<0){
            return Search(T.left,sk);
        } else{
            return T.value;
        }

    }

    /* insert key*/
    public void insert(Key ik,Value v){
        root = insert(root,ik,v);
    }
    private Node insert(Node T, Key ik,Value v){
        if(T == null){
            return new Node(ik,v,1);
        }
        int cmp = ik.compareTo(T.key);
        /* ik>T.key 插入右边*/
        if(cmp>0){
            T.right = insert(T.right,ik,v);
        } else if(cmp<0){ /* ik<T.key 插入左边*/
            T.left = insert(T.left,ik,v);
        } else {
            T.value = v;
        }

        T.n  = size(T.left)+size(T.right)+1;
        return T;
    }

    /* delete*/
    /*Three different situation:no children, one children, two children*/
//    public void delete(Key k){
//        delete(root,k);
//    }

    public void delete(Key k){
        root = delete(root,k);
    }


    private Node delete(Node T,Key k){

        if(T == null){
            return null;
        }
        int cmp = k.compareTo(T.key);
        if(cmp>0){
            T.right = delete(T.right,k);
        } else if(cmp<0){
            T.left = delete(T.left,k);
        } else { /* T.key = k*/
            /* 1 or 0 children*/
            if(T.right == null){
                return T.left;
            }
            if (T.left == null){
                return T.right;
            }
            /* two children*/
            Node preNode = pred(T);
            delete(T, preNode.key);
            preNode.left = T.left;
            preNode.right = T.right;
            T = preNode;
        }
        T.n = size(T.right)+size(T.left)+1;
        return T;
    }
    /* find the predecessor node of the node*/
    private Node pred(Node T){
        Node p = T.left;
        while(p.right!=null){
            p = p.right;
        }
        return p;
    }

}