/* sentinel node*/
public class sList {
	/* nested class IntNode*/
	private static class IntNode{
		int item;
		IntNode next;
		public IntNode(int i,IntNode n){
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	private int size;
	/* constructor*/
	public sList(int x){
		sentinel = new IntNode(61,null);
		sentinel.next = new IntNode(x,null);
		size = 1;
	}
	/* constructor to create an empty list*/
	public sList(){
		sentinel = new IntNode(61,null);
		size = 0 ;
	}

	/* add an item x into the first place*/
	public void addfirst(int x){
		sentinel.next = new IntNode(x,sentinel.next);
		size += 1;
	}

	/* get first item of the array*/
	public int getfirst(){
		return sentinel.next.item;
	}
	/* add item x to the last*/
	public void addlast(int x){
		/* if to add x to an empty list*/
		size += 1;
		IntNode p = sentinel;
		while(p.next!=null){
			p = p.next;
		}
		p.next = new IntNode(x,null);
		
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
		sList L = new sList();
		L.addlast(2);
		System.out.println(L.size());
		
		}
	}