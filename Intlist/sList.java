/* sentinel node*/
public class sList {
	/* nested class IntNode*/
	private  class IntNode{
		public int item;
		public IntNode next;
		public IntNode(int i,IntNode n){
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size; /* catching size*/
	private	IntNode lastp;/*catching last pointer*/
	
	/* constructor*/
	public sList(int x){
		sentinel = new IntNode(61,null);
		sentinel.next = new IntNode(x,null);
		size = 1;
		lastp = sentinel.next;
	}

	/* constructor to create an empty list*/
	public sList(){
		sentinel = new IntNode(61,null);
		size = 0 ;
		lastp = sentinel;
	}

	/* add an item x into the first place*/
	public void addfirst(int x){
		sentinel.next = new IntNode(x,sentinel.next);
		size += 1;
		lastp = lastp.next;
	}

	/* get first item of the array*/
	public int getfirst(){
		return sentinel.next.item;
	}

	/* add item x to the last*/
	public void addlast_slow(int x){
		/* if to add x to an empty list*/
		size += 1;
		IntNode p = sentinel;
		while(p.next!=null){
			p = p.next;
		}
		p.next = new IntNode(x,null);	
	}

	/* improve addlast*/
	public void addlast_fast(int x){
		size += 1;
		IntNode last = new IntNode(x,null);
		lastp.next = last ;
	}

	/* get last item*/
	public int getlast(){
		IntNode p = sentinel.next;
		while(p.next!=null){
			p = p.next;
		}
		return p.item;
	}

	/* get size of the array*/
	public int size(){
		return size;
	}

	public static void main(String[] args){
		sList L = new sList(4);
		L.addlast_fast(2);
		System.out.println(L.getlast());
		
	}
}
