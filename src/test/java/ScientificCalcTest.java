import static org.junit.Assert.*;
import org.junit.Test;

//JUnit test cases
public class ScientificCalcTest {
    
    ScientificCalc calc = new ScientificCalc();
    
    // tolerance for double comparison
    private static final double DELTA = 1e-15;

    @Test
    public void testBasicMath() {
        // testing addition op
        assertEquals(15.0, calc.add(10.0, 5.0), DELTA);
        
        // testing subtraction op
        assertEquals(5.0, calc.subtract(10.0, 5.0), DELTA);
    }

    @Test
    public void testMultiply() {
        //testing multiplication op
        assertEquals(50.0, calc.multiply(10.0, 5.0), DELTA);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calc.divide(10.0, 5.0), DELTA);
        
        //division by zero returns NaN
        assertTrue(Double.isNaN(calc.divide(10.0, 0.0)));
    }

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, calc.squareRoot(16.0), DELTA);
    }

    @Test
    public void testFactorial() {
        // normal case
        assertEquals(120, calc.factorial(5));
        
        assertEquals(1, calc.factorial(0));
        
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, calc.naturalLog(1.0), DELTA);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, calc.power(2.0, 3.0), DELTA);
    }
}