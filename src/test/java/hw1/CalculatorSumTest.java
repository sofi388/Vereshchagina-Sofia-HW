package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorSumTest {
    public  Calculator Calc = new Calculator();

    @DataProvider
    public Object[][] newData(){
        return new Object[][]{{6, Calc.sum(4,2)},
                {8, Calc.sum(6,2)}};
    }
    @Test(dataProvider = "newData")
    public void testsum(float res, float sum) throws Exception {
        Assert.assertEquals(res,sum);

    }

}