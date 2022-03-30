package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest extends AllTest {

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{2, 4, 2},
                {3, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testDiv(float res, float a, float b) {
        double div = Calc.div(a, b);
        Assert.assertEquals(res, div);
    }

}