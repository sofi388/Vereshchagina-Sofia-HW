package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivTest {
    protected Calculator Calc;

    @BeforeMethod
    public void makeCalculator() {
        Calc = new Calculator();
    }

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{2, 4, 2},
                {3, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testDiv(float res, float a, float b) throws Exception {
        double div = Calc.div(a, b);
        Assert.assertEquals(res, div);
    }
}