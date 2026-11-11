package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test void letterGradeA() { assertEquals("A", calc.letterGrade(95)); }
    @Test void gpaTwoScores() { assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9); }
    @Test void scholarshipFull() { assertEquals(100, calc.scholarship(3.9, 16, false)); }
    @Test void letterGradeB() { assertEquals("B", calc.letterGrade(85)); }
    @Test void scholarshipSeventy() { assertEquals(70, calc.scholarship(3.5, 13, false)); }
    @Test void letterGradeC() { assertEquals("C", calc.letterGrade(75)); }
    @Test void letterGradeD() { assertEquals("D", calc.letterGrade(65)); }
    @Test void letterGradeF() { assertEquals("F", calc.letterGrade(50)); }
    @Test void letterGradeNegativeThrows() { assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1)); }
    @Test void letterGradeOver100Throws() { assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101)); }
    @Test void gpaAllGrades() { assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 50}), 1e-9); }
    @Test void gpaNullThrows() { assertThrows(IllegalArgumentException.class, () -> calc.gpa(null)); }
    @Test void gpaEmptyThrows() { assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{})); }
    @Test void scholarshipNegativeGpaThrows() { assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 15, false)); }
    @Test void scholarshipGpaOver4Throws() { assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 15, false)); }
    @Test void scholarshipNegativeCreditsThrows() { assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.0, -1, false)); }
    @Test void scholarshipViolation() { assertEquals(0, calc.scholarship(3.9, 16, true)); }
    @Test void scholarshipHighGpaLowCredits() { assertEquals(50, calc.scholarship(3.9, 10, false)); }
    @Test void scholarshipFifty() { assertEquals(50, calc.scholarship(3.2, 20, false)); }
    @Test void scholarshipNone() { assertEquals(0, calc.scholarship(2.0, 20, false)); }
}