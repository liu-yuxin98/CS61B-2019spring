public class QuickUnion implements DisjointSets {
    private int[] parent ;
    /* build a parent list for future use*/
    public void quickFindDS(int N){
        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = -1;
        }
    }
    
    /* find the root of p*/
    public int findroot(int p){
        while(parent[p]!=-1){
            p = parent[p];
        }
        return p;
    }

    /* connect two items*/
    public void connect(int p, int q){
        /* 单独的一个item*/
        if(parent[q] == -1){
            parent[q] = p;
        }
        else{
            parent[findroot(q)] = findroot(p);
        }

    }

    /* check wether p,q is connected*/
    public boolean isConnected(int p, int q) {
       return findroot(p) == findroot(q);
    }


    public static void main(String[] args){
        QuickUnion qu = new QuickUnion();
        qu.quickFindDS(7);
        qu.connect(0,1);
        qu.connect(0,2);
        qu.connect(3,4);
        qu.connect(3,5);
        qu.connect(5,6);
        qu.connect(1,6);
    }
}
