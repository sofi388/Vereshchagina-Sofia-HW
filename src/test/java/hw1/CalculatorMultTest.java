package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorMultTest {
    public  Calculator Calc = new Calculator();

    @DataProvider
    public Object[][] newData(){
        return new Object[][]{{8, Calc.mult(4,2)},
                {12, Calc.mult(6,2)}};
    }

    @Test(dataProvider = "newData")
    public void testmult(float res, float div) throws Exception{
        Assert.assertEquals(res, div);
    }
}