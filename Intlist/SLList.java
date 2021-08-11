public class SLList {
	/* nested class*/
	/* private->can't be used out of the SLList class*/
	/* static-> the StuffNode class can't use the method out of the
	!!StuffNode class!!*/
	private  class StuffNode {
		public int item;
		public StuffNode next;
		public StuffNode(int i,StuffNode n){
			item = i;
			next = n;
		}

	}
	private StuffNode first;

	public SLList(int x){
		first = new StuffNode(x,null); /*easification*/
	}
	/* add an item to the front of the array*/
	public void addfirst(int x){
		first = new StuffNode(x,first);
	}
	/* get the first item of the array*/
	public int getfirst(){
		return first.item;
	}


	/* add item x to the last*/
	public void addLast(int x){
		StuffNode p = this.first;/* address of this.first*/
		while(p.next!=null){
			p = p.next;
		}
		p.next = new StuffNode(x,null);
	}
	

    /* returns the length of the arrays start from the InNode p*/
    private static int size(StuffNode p){
    	if(p.next==null){
    		return 1;
    	}else{
    		return 1+size(p.next);
    	}

    }
	/* count size of the sllist*/
	public int size(){
		return size(first);
	}

	
	public static void main(String[] args) {
		SLList L = new SLList(10);
		L.addfirst(5);
		L.addfirst(0);
		L.addLast(8);
		System.out.println(L.size());
		
		

	}
}