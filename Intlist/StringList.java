public class StringList {
	public String item;
	public StringList rest;
	public StringList(String s,StringList n){
		item = s;
		rest = n;
	}
	public static void main(String[] args){
		StringList L = new StringList("eat", null);
		L = new StringList("shouldn't", L);
		L = new StringList("you", L);
		L = new StringList("sometimes", L);
		StringList M = L.rest;
		StringList R = new StringList("many",null);
		R = new StringList("potatoes",R);
		/* extremely important*/
		R.rest.rest = R;
		System.out.println(R.rest.rest.rest.item);
		M.rest.rest.rest = R.rest;
		L.rest.rest = L.rest.rest.rest;
		L = M.rest;
		}
	}