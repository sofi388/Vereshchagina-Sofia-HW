package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultTest {
    protected Calculator Calc;

    @BeforeMethod
    public void makeCalculator() {
        Calc = new Calculator();
    }

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{8, 4, 2},
                {12, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testMult(float res, float a, float b) throws Exception {
        double sum = Calc.mult(a, b);
        Assert.assertEquals(res, sum);
    }
}