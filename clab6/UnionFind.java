public class UnionFind {
    int [] parents;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) throws IllegalAccessException {
        if(vertex>=parents.length){
            throw new IllegalAccessException("out of index");
        }
        if(vertex<0){
            throw new IllegalAccessException("negative index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int root = find(v1);
        return Math.abs(parents[root]);
    }


    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        if(connected(v1,v2)){
            return;
        } else {
            if(sizeOf(v1)>sizeOf(v2)){
                parents[find(v1)] += parents[find(v2)];
                parents[find(v2)] = find(v1);
            } else {
                parents[find(v2)] += parents[find(v1)];
                parents[find(v1)] = find(v2);
            }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {

        int root = vertex;
        while(parents[root]>=0){
            root = parents[root];
        }
        return root;

    }

}
