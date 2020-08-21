package fastcampus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class BeanScopeTest {

    @Test
    void testIdentity(){
        A a1 = new A();
        A a2 = a1;
        Assert.assertTrue(a1 == a2);
    }


    @Test
    void testEquals(){
        A a1 = new A(10, "hello world");
        A a2 = new A(10, "hello world");
        A a3 = new A(5, "Hello");

        Assert.assertTrue(a1.equals(a2));
        Assert.assertFalse(a1.equals(a3));
    }
}
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class A{
    private int a1;
    private String a2;


}