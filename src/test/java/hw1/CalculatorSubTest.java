package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubTest {
    protected Calculator Calc;

    @BeforeMethod
    public void makeCalculator() {
        Calc = new Calculator();
    }

    @DataProvider
    public Object[][] newData() {
        return new Object[][]{{2, 4, 2},
                {4, 6, 2}};
    }

    @Test(dataProvider = "newData")
    public void testSub(float res, float a, float b) throws Exception {
        double sub = Calc.sub(a, b);
        Assert.assertEquals(res, sub);
    }
}