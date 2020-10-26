import org.junit.Test;

public class TestUnionFind {
    @Test
    public void TestUnion(){
        UnionFind uf = new UnionFind(13);
        uf.union(0,12);
        uf.union(1,12);
        uf.union(3,12);
        uf.union(6,12);
        uf.union(6,7);
        uf.union(6,9);
        uf.union(7,9);
    }
}
