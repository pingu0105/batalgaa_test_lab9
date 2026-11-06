@Test void letterGradeA() { assertEquals("A", calc.letterGrade(95)); }
@Test void gpaTwoScores() { assertEquals(3.5, calc.gpa(new double[]{95, 85}), 1e-9); }
@Test void scholarshipFull() { assertEquals(100, calc.scholarship(3.9, 16, false)); }