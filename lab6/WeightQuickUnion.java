public class WeightQuickUnion implements DisjointSets{
    private int[] parents;
    /* Creates a Height data structure holding N vertices. Initially, all
      vertices are in disjoint sets. */
    public void UnionFind(int N){
        parents = new int[N];
        for(int i=0;i<N;i++){
            parents[i] = -1;
        }
    }
    /* return the root of v*/
    public int find(int v){
        int root = v;
        while(parents[root]>=0){
            root = parents[root];
        }

        while(parents[v]>=0){
            int next = parents[v];
            parents[v] = root;
            v = next;
        }
        return root;
    }



    /* connect v1,v2*/
    @Override
    public void connect(int v1, int v2){
        if(v1==v2){
            return;
        }
        int rootv1 = find(v1);
        int rootv2 = find(v2);
        if(Math.abs(parents[rootv1])> Math.abs(parents[rootv2])){
            parents[rootv1] += parents[rootv2];
            parents[rootv2] = rootv1;
        } else {
            parents[rootv2] += parents[rootv1];
            parents[rootv1] = rootv2;
        }

    }

    /* decide weather v1,v2 is connected*/
    @Override
    public boolean isConnected(int v1, int v2){
        return find(v1) == find(v2);
    }

    @Override
    public boolean equals(Object o){
        WeightQuickUnion other = (WeightQuickUnion)o;
        for(int i=0;i<other.parents.length;i++){
            if(parents[i]!=other.parents[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
       WeightQuickUnion wcpqu = new WeightQuickUnion();
        wcpqu.UnionFind(9);
        wcpqu.connect(0,1);
        wcpqu.connect(0,2);
        wcpqu.connect(3,4);
        wcpqu.connect(3,5);
        wcpqu.connect(6,5);
        wcpqu.connect(1,6);
        wcpqu.connect(7,8);
        wcpqu.connect(0,0);
        WeightQuickUnion wcpqu2 = new WeightQuickUnion();
        wcpqu2.UnionFind(9);
        System.out.println(wcpqu.equals(wcpqu2));
        wcpqu2.connect(0,1);
        wcpqu2.connect(0,2);
        wcpqu2.connect(3,4);
        wcpqu2.connect(3,5);
        wcpqu2.connect(6,5);
        wcpqu2.connect(1,6);
        wcpqu2.connect(7,8);
        wcpqu2.connect(0,0);
        System.out.println(wcpqu.equals(wcpqu2));
    }
}
