package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSumTest extends AllTest {

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{6, 4, 2},
                {8, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testSum(float res, float a, float b) {
        double sum = Calc.sum(a, b);
        Assert.assertEquals(res, sum);
    }

}