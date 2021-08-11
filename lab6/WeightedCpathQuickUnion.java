public class WeightedCpathQuickUnion implements DisjointSets {
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
        int root = p;
        /* 每调用一次find就把沿途的所有Item与root直接相连，从而减少tree的height*/
        while(parent[root]>=0){
            root = parent[root];
        }
        while(parent[p]>=0){
            int temp = p;
            p = parent[p];
            parent[temp] = root;
        }
        return root;
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
        WeightedCpathQuickUnion wcpqu = new WeightedCpathQuickUnion();
        wcpqu.quickFindDS(7);
        wcpqu.connect(0,1);
        wcpqu.connect(0,2);
        wcpqu.connect(3,4);
        wcpqu.connect(3,5);
        wcpqu.connect(6,5);
        wcpqu.connect(1,6);
        wcpqu.isConnected(1,5);
    }
}
