public interface DisjointSets {
    /* connect two numbers p & q*/
    public void connect(int p, int q);

    /* decide wether p,q is connected*/
    boolean isConnected(int p, int q);
}
