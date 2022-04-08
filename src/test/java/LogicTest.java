import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @Test
    void logicTest1() throws Exception {
        String str = "([]){}";
        char[] strArr = str.toCharArray();
        assertTrue(Logic.checkIfStructureIsCorrectSimpleStack(strArr));
    }

    @Test
    void logicTest2() throws Exception {
        String str = "([]){}";
        char[] strArr = str.toCharArray();
        assertTrue(Logic.checkIfStructureIsCorrectRecursion(strArr));
    }

    @Test
    void logicTest3() throws Exception {
        String str = "()";
        char[] strArr = str.toCharArray();
        assertTrue(Logic.checkIfStructureIsCorrectSimpleStack(strArr));
    }

    @Test
    void logicTest4() throws Exception {
        String str = "()";
        char[] strArr = str.toCharArray();
        assertTrue(Logic.checkIfStructureIsCorrectRecursion(strArr));
    }

    @Test
    void logicTest5() throws Exception {
        String str = "[]{}";
        char[] strArr = str.toCharArray();
        assertTrue(Logic.checkIfStructureIsCorrectSimpleStack(strArr));
    }

    @Test
    void logicTest6() throws Exception {
        String str = "[]{}";
        char[] strArr = str.toCharArray();
        assertTrue(Logic.checkIfStructureIsCorrectRecursion(strArr));
    }

    @Test
    void logicTest7() throws Exception {
        String str = "(";
        char[] strArr = str.toCharArray();
        assertFalse(Logic.checkIfStructureIsCorrectSimpleStack(strArr));
    }

    @Test
    void logicTest8() throws Exception {
        String str = "(";
        char[] strArr = str.toCharArray();
        assertFalse(Logic.checkIfStructureIsCorrectRecursion(strArr));
    }

    @Test
    void logicTest9() throws Exception {
        String str = "())({}";
        char[] strArr = str.toCharArray();
        assertFalse(Logic.checkIfStructureIsCorrectSimpleStack(strArr));
    }

    @Test
    void logicTest10() throws Exception {
        String str = "())({}";
        char[] strArr = str.toCharArray();
        assertFalse(Logic.checkIfStructureIsCorrectRecursion(strArr));
    }
}