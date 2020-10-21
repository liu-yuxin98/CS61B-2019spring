/*Exercises A1 A2*/
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f,IntList r){
        first = f;
        rest = r;
    }
    /* copy value*/
    public IntList copyvalue(){
        IntList tempL = this;
        IntList copyedL = new IntList(this.first,null);
        IntList tempLc = copyedL;
        while(true){
            tempL = tempL.rest;
            if(tempL==null){
                break;
            }
            copyedL.rest = new IntList(tempL.first,null);
            copyedL = copyedL.rest;
        }
        copyedL = null;
        return tempLc;
    }




/*  完全版的  Exercises A1 调用了 addsame,copyvalue*/
    public void addAdjancent(){
        IntList p  = this;
       while(true){
           IntList newp = addsame(p);
           /* 无变化*/
           if(newp.size() == p.size()){
               p.rest = null;
               break;

           }
           p = newp;
           this.first = p.first;
           this.rest = p.rest ;
       }
    }
    /* 从左往右遍历 合并相同项,返回合并完成后的intlist*/
    public IntList addsame(IntList L){
        IntList p = L.copyvalue();
        IntList tempL = p;
        while(true){
            if(p.rest == null){
                return tempL;
            }
            if(p.first == p.rest.first){
                while(true){
                    /* 向右相加相同项直到新的一项和之前的一项不相同*/
                    IntList nextitem = p.rest;
                    p.first *=2;
                    p.rest = p.rest.rest;
                    nextitem.rest = null; /* 删除相同项目的前一项*/
                    /*已经到达最后一项*/
                    if(p.rest == null){
                        break;
                    }
                    /* 两者不等*/
                    if(p.first!=p.rest.first){
                        break;
                    }
                }
            }
            if(p.rest == null){
                return tempL;
            }
            p = p.rest;
        }
    }
    /* returen size*/
    public int size(){
        IntList p = this;
        int size = 0;
        while(p!=null){
            p = p.rest;
            size += 1;
        }
        return size;
    }
    /* print out*/
    public void printIntList(){
        IntList p = this;
        for(int i =0;i<size();i++){
            System.out.println(p.first);
            p = p.rest;
        }
    }

    public static void main(String[] args){
        IntList L = new IntList(3,null);
        L = new IntList(3,L);
        L = new IntList(6,L);
        L = new IntList(2,L);
        L = new IntList(2,L);
        L = new IntList(1,L);
        L.printIntList();
        L.addAdjancent();
        L.printIntList();


    }
}