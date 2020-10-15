/* class之间的继承关系使用 extends*/
public class RotatingSLList<lochNess> extends SLList<lochNess> {


    public void rotateRight(){
      for(int i=0;i<this.size()-1;i++){
           lochNess p = this.removeLast();
           this.insert(p,i);
      }
    }


    public void rotateRight(RotatingSLList<lochNess> RL){
        RotatingSLList<lochNess> nRL = new RotatingSLList<>();
        for(int i = 0;i<RL.size();i++){
            nRL.addFirst(RL.get(i));
        }
        RL = nRL;
    }
}
