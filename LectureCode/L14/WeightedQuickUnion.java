public class WeightedQuickUnion implements DisjointSets {
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
        while(parent[p]>=0){
            p = parent[p];
        }
        return p;
    }

    /* connect two items*/
    public void connect(int p, int q){
        q = findroot(q); /* q to its root*/
        p = findroot(p); /* p to its root*/
        /* compare the numbers in p,q tree*/
        if(Math.abs(parent[p])>= Math.abs(parent[q])){ /* numbers of p > numbers of q*/
            parent[p] += parent[q]; /* add numbers from q to p*/
            parent[q] = p;
        }else{
            parent[q] += parent[p];
            parent[p] = q;
        }

    }

    /* check wether p,q is connected*/
    public boolean isConnected(int p, int q) {
        return findroot(p) == findroot(q);
    }


    public static void main(String[] args){
        WeightedQuickUnion wqu = new WeightedQuickUnion();
        wqu.quickFindDS(7);
        wqu.connect(0,1);
        wqu.connect(0,2);
        wqu.connect(3,4);
        wqu.connect(3,5);
        wqu.connect(6,5);
        wqu.connect(1,6);
        wqu.isConnected(1,5);
    }
}
