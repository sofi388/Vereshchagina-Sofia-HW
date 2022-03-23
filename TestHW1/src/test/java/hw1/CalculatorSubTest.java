package hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorSubTest {
    public  Calculator Calc = new Calculator();

    @DataProvider
    public Object[][] newData(){
        return new Object[][]{{2, Calc.sub(4,2)},
                {4, Calc.sub(6,2)}};
    }

    @Test(dataProvider = "newData", groups={"SumSub"})
    public void testsub(float res, float sub) throws Exception{
        Assert.assertEquals(res, sub);
    }
}