import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class IntegerDivisionTest {
    IntegerDivision division = new IntegerDivision();

    @Test
    void getDivisionResult_zeroAsDivisor_exceptionIsExpected() {
        assertThrows(ArithmeticException.class, () -> division.getDivisionResult(190, 0));
    }

    @Test
    void getDivisionResult_dividendIsLessThanDivisor_simpleStringResultExpected() {
        int dividend = 10;
        int divisor = 20;

        String expectedResult = "_10|20\n" +
                                "  0|-\n" +
                                "   |0\n";
        String actualResult = division.getDivisionResult(dividend,divisor);
        assertEquals(expectedResult, actualResult, "Method returns a string representation of a long division of integer numbers");
    }

    @Test
    void getDivisionResult_dividendAndDivisorAreTheSame_oneIterationResultIsExpected() {
        int dividend = 77;
        int divisor = 77;

        String expectedResult = "_77|77\n" +
                                " 77|-\n" +
                                " --|1\n" +
                                "  0\n";
        String actualResult = division.getDivisionResult(dividend,divisor);
        assertEquals(expectedResult, actualResult, "Method returns a string representation of a long division of integer numbers");
    }

    @Test
    void getDivisionResult_divisorIsLessThanDividend_longDivisionIsExpected() {
        int dividend = 78986;
        int divisor = 4;

        String expectedResult = "_78986|4\n" +
                                " 4    |-----\n" +
                                " -    |19746\n" +
                                "_38\n" +
                                " 36\n" +
                                " --\n" +
                                " _29\n" +
                                "  28\n" +
                                "  --\n" +
                                "  _18\n" +
                                "   16\n" +
                                "   --\n" +
                                "   _26\n" +
                                "    24\n" +
                                "    --\n" +
                                "     2\n";
        String actualResult = division.getDivisionResult(dividend,divisor);
        assertEquals(expectedResult, actualResult, "Method returns a string representation of a long division of integer numbers");
    }

    @Test
    void getDivisionResult_divisionOfBigNumbers_normalResultExpexted() {
        int dividend = 617892;
        int divisor = 78940;

        String expectedResult = "_617892|78940\n" +
                                " 552580|-\n" +
                                " ------|7\n" +
                                "  65312\n";
        String actualResult = division.getDivisionResult(dividend,divisor);
        assertEquals(expectedResult,actualResult,"Method returns a string representation of a long division of integer numbers");
    }
}

