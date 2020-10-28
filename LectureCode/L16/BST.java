public class BST<Key> {
    private Key key;
    private BST left;
    private BST right;

    public BST(Key key,BST l,BST r){
        this.key = key;
        this.left = l;
        this.right = r;
    }
    public BST(Key key){
        this.key = key;
    }

    /* 以下的代码是伪代码*/
    /* serarch key*/
    public  BST SearchKey(BST Tree,Key searchkey){
        if(Tree == null){
            return null;
        }
        if(searchkey == Tree.key){
            return Tree;
        }
        /* 不可以直接使用 searchkey<Tree.key 因为没有这个比较方法*/
        if(searchkey<Tree.key){
            return SearchKey(Tree.left,searchkey);
        }
        if(searchkey>Tree.key){
            return SearchKey(Tree.right,searchkey);
        }

    }


    /* insert key*/
    public BST insert(BST Tree,Key ik){
        if(Tree == null){
            return new BST(ik);
        }
        if(ik<Tree.key){
            Tree.left = insert(Tree.left,ik);
        }
        if(ik>Tree){
            Tree.right = insert(Tree.right,ik);
        }
    }


}
