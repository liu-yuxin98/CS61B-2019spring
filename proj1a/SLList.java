/* genetic*/

public class SLList<lochNess> {
    public class stuffNode {
        public lochNess item;
        public stuffNode next;
        public stuffNode(lochNess i, stuffNode n){
            item = i;
            next = n;
        }
        public stuffNode(){
            item = null;
            next = null;
        }
    }
    public int size;
    public stuffNode sentinel;
    public stuffNode p; /* point last*/
    /* constructor */
    public SLList(lochNess x){
        size = 1;
        sentinel = new stuffNode(x,null);
        sentinel.next = new stuffNode(x,null);
        p = sentinel.next;
    }
    /* empty constructor*/
    public SLList(){
        size = 0;
        sentinel = new stuffNode();
        p = sentinel;
    }



    /* add first*/
    public void addfirst(lochNess x){
        sentinel.next = new stuffNode(x,sentinel.next);
        size += 1;
        if(size==1){
            p = p.next;
        }
    }
    /* add last*/
    public void addlast(lochNess x){
        p.next = new stuffNode(x,null);
        p = p.next;
        size += 1;
    }
    /* return size of the array*/
    public int size(){
        return size;
    }
    /* print*/
    public void printSLList(){
        stuffNode newp = sentinel.next;
        for(int i =0;i<size;i++){
            System.out.println(newp.item);
            newp = newp.next;
        }
    }
    /* delete first*/
    public void deletefirst(){
        if(size==0){
            System.out.println("wrong! empty list can't deletefirst");
        }
        else{
            stuffNode pfirst = sentinel.next;
            sentinel.next = sentinel.next.next;
            pfirst.next =null;
        }

    }
    /* get ith*/
    public lochNess get(int index){
        stuffNode newp = sentinel;
        if(index>size()-1){
            return null;
        }
        else{
            for(int i =0;i<index;i++){
                newp = newp.next;
            }
            return newp.item;
        }
    }


    /*return the longest string in the Sllist*/
    public String longest(SLList<String> list){
       int longest = 0;
       int index = 0;
       for(int i=0;i< list.size();i++){
           if(list.get(i).length()>=longest){
               longest = list.get(i).length();
               index = i;
           }
       }
        return list.get(index);
    }

    public static void main(String[] args) {
        SLList<String> L = new SLList<String>("james");
        L.addfirst("pete");
        L.addfirst("huahuaa");
        L.printSLList();
        System.out.println(L.longest(L));

    }

}
