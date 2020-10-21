package solution1;
/* solution1 使用的是 comparable*/
public class Teacher implements Comparable<Teacher> {
    public int age;
    public Teacher(int a){
        age = a ;
    }
    /* return >1 if this>o
     return = 0 if this = o
     return <0 if this <o
     */
    public int compareTo(Teacher t){ /* 注意Object o*/
        return this.age-t.age;
    }
}
