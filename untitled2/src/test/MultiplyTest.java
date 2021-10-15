package test;

import it.college.Multiply;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class MultiplyTest {

    @Test
    public void multiply() throws IOException {
        Multiply multiplyObject = new Multiply();
        int result = multiplyObject.multiply();
        Assert.assertEquals(20, result);
    }
}
