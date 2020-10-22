import java.util.Set;
/* compare weight and path record*/
public class DisjointSet {
    public int[] items;
    public DisjointSet(int N){
        items = new int[N];
        for(int i=0;i<N;i++){
            items[i] = -1;
        }
    }
    /* find the root of a*/
    public int find(int a){
        int root = a;
        while(items[root]>=0){
            root = items[root];
        }
        while(a!=root){
            int next = items[a];
            items[a] = root;
            a = next;
        }
        return root;
    }
    /* connect p,q*/
    public void connect(int p,int q){
            Integer rp = find(p);
            Integer rq = find(q);
            Integer np = Math.abs(items[rp]); /* numbers in p tree*/
            Integer nq = Math.abs(items[rq]); /* numbers in q tree*/
            if(np>=nq){
                items[rp] += items[rq];
                items[q] = rp;
            } else {
                items[rq] += items[rp];
                items[p] = rq;
            }
    }

    public boolean isConnected(int p,int q){
        Integer rp = find(p);
        Integer rq = find(q);
        return rp==rq;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<items.length-1;i++){
            res.append(items[i]+",");
        }
        res.append(items[items.length-1]);

        return "["+res.toString()+"]";
    }

    public static void main(String[] args){
        DisjointSet ds = new DisjointSet(9);
        for(int i=0;i<8;i+=2){
            ds.connect(i,i+1);
        }
        System.out.println(ds.toString());
        ds.connect(0,2);
        ds.connect(4,6);
        System.out.println(ds.toString());
        ds.connect(0,4);
        System.out.println(ds.toString());
        ds.isConnected(7,3);
        System.out.println(ds.toString());
    }
}
