package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test void letterGradeA() { assertEquals("A", calc.letterGrade(95)); }
    @Test void gpaTwoScores() { assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9); }
    @Test void scholarshipFull() { assertEquals(100, calc.scholarship(3.9, 16, false)); }
    @Test void letterGradeB() { assertEquals("B", calc.letterGrade(85)); }
    @Test void scholarshipSeventy() { assertEquals(70, calc.scholarship(3.5, 13, false)); }

    // add 1-2 more happy-path tests of your own here (Part A asks for 4-5)
}