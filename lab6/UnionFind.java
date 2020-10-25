public class UnionFind {
    private int[] parents;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if(vertex>=parents.length){
            throw new OutOfMemoryError("index out of index");
        }
        if(vertex<0){
           throw new IllegalArgumentException(" negative index") ;
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        while(parents[v1]>=0){
            v1 = parents[v1];
        }
        return Math.abs(parents[v1]);
    }

    /* Returns the parent of v1 */
    public int parent(int v1) {
        while(parents[v1]>=0){
            v1 = parents[v1];
        }
        return v1;
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        /* find(v1)==find(v2) -> path-compression*/
        /* parent(v1) == parent(v2) -> no path-compression*/
      if(find(v1) == find(v2)){
          return true;
      }
        return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int rootv1 = find(v1);
        int rootv2 = find(v2);
        if(sizeOf(v1)>sizeOf(v2)){
            parents[rootv1] -= sizeOf(v2);
            parents[rootv2] = rootv1;
        } else {
            parents[rootv2] -= sizeOf(v1);
            parents[rootv1] = rootv2;
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        int root = vertex;
        while(parents[root]>=0){
            root = parents[root];
        }
        while(parents[vertex]>=0){
            int next = parents[vertex];
            parents[vertex] = root;
            vertex = next;
        }
        return root;
    }

    public static void main(String[] args){
        UnionFind uf = new UnionFind(5);
        uf.union(1,0);
        uf.union(0,2);
        uf.union(3,4);
        uf.union(0,3);


    }

}
