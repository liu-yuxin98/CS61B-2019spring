public class SLList {
	/* nested class*/
	/* private->can't be used out of the SLList class*/
	/* static-> the IntNode class can't use the method out of the
	!!IntNode class!!*/
	private static class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int i,IntNode n){
			item = i;
			next = n;
		}

	}
	private IntNode first;

	public SLList(int x){
		first = new IntNode(x,null); /*easification*/
	}
	/* add an item to the front of the array*/
	public void addfirst(int x){
		first = new IntNode(x,first);
	}
	/* get the first item of the array*/
	public int getfirst(){
		return first.item;
	}


	/* add item x to the last*/
	public void addLast(int x){
		IntNode p = this.first;/* address of this.first*/
		while(p.next!=null){
			p = p.next;
		}
		p.next = new IntNode(x,null);
	}
	

    /* returns the length of the arrays start from the InNode p*/
    private static int size(IntNode p){
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
		L.addLast(9);
		System.out.println(L.size());
		

	}
}