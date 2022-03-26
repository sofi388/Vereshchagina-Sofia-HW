package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorDivTest {
    public  Calculator Calc = new Calculator();

    @DataProvider
    public Object[][] newData(){
        return new Object[][]{{2, Calc.div(4,2)},
                {3, Calc.div(6,2)}};
    }

    @Test(dataProvider = "newData")
    public void testdiv(float res, float div) throws Exception{
        Assert.assertEquals(res, div);
    }
}