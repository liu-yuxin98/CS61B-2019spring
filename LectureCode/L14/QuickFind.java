public class QuickFind implements DisjointSets{
    private int[] id ;
    /* build a id list for future use*/
    public void quickFindDS(int N){
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    /* connect two items*/
    public void connect(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i=0;i<id.length;i++){
            /* 第 i 个元素 与 p 在一个set 中*/
            if(id[i]==pid){
                id[i] = qid; /* 把这个元素的组编号改为与q元素相同，表示两者在一个组中*/
            }
        }
    }

    /* check wether p,q is connected*/
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
