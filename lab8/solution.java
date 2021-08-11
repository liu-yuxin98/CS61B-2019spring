import java.awt.*;
import java.util.LinkedList;

public class solution {

    public int Hash(String key){
        String skey = key.toString();
        int hashcode = 0;
        for(int i=0;i<skey.length();i++){
            hashcode *=31;
            hashcode += skey.charAt(i);
        }
        return hashcode;
    }

    public class Node{
        int key;
        int value;
        public Node(int k, int v){
            key = k;
            value = v;
        }

    }

    public void create(){
        LinkedList[] ls = new LinkedList[16];
        ls[0] = new LinkedList();
        Node n1 = new Node(0,0);
        Node n2 = new Node(1,1);
        Node n3 = new Node(1,1);
        ls[0].add(n1);
        ls[0].add(n2);
        ls[0].add(n3);
        ls[1] = new LinkedList<String>();
        ls[1].add("c");
        ls[1].add("c2");
        ls[1].add("c3");
        Node nodei = (Node)ls[0].get(1);
        System.out.println(nodei.key);


    }

    public static void main(String[] args){
        solution s = new solution();
       System.out.println(-232903%10);
    }
}
