package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class AllTest {
    protected Calculator Calc;

    @BeforeMethod
    public void makeCalculator() {
        Calc = new Calculator();
    }

}
