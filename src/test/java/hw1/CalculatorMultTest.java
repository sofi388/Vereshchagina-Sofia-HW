package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest extends AllTest {

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{8, 4, 2},
                {12, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testMult(float res, float a, float b) {
        double sum = Calc.mult(a, b);
        Assert.assertEquals(res, sum);
    }
}