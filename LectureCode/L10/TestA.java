import org.junit.Test;
import solution1.*;

public class TestA {
    @Test
    public void TestMinimizer(){
        Teacher[] teachers = {new Teacher(23), new Teacher(45), new Teacher(58)};
        Teacher mint = (Teacher)Minimizer.getMin(teachers);
        System.out.println(mint.age );

    }
}
