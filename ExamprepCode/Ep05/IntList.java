import java.util.Iterator;
import java.util.NoSuchElementException;

/* write my intlist*/
public class IntList implements Iterable<Integer> {
	public int first;
	public IntList rest;
	/* constructor*/
	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if(rest == null){
			return 1;
		}else{
			return 1+rest.size();
		}
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int cnt = 0;
		while(p!=null){
			cnt+=1;
			p = p.rest;
		}
		return cnt;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if(i==0){
			return first;
		}else{
			return rest.get(i-1);
		}
	}

	/* add x into the first*/
	public void addfirst(int x){
		first = x;
		rest = this; 
	}

	@Override
	public Iterator<Integer> iterator(){
		return new myinterator();
	}

	private class myinterator implements Iterator<Integer>{
		IntList f;
		public myinterator(){
			super();
			f = new IntList(first,rest);
		}
		@Override
		public boolean hasNext(){
			return f!=null;
		}
		@Override
		public Integer next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			int returnitem;
			returnitem = f.first;
			f = f.rest;
			return returnitem;
		}

	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		L = new IntList(0, L);
		for(int n:L){
			System.out.println(n);
		}

	}

}