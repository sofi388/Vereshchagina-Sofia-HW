package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest extends AllTest {

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{2, 4, 2},
                {4, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testSub(float res, float a, float b) {
        double sub = Calc.sub(a, b);
        Assert.assertEquals(res, sub);
    }
}