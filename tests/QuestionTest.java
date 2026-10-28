package tests;
import sourse.Question;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    @Test
    public void testCorrectAnswer() {
        Question q = new Question("Столица Франции?", "Париж");
        assertTrue(q.checkAnswer("Париж"));
    }

    @Test
    public void testWrongAnswer() {
        Question q = new Question("Столица Франции?", "Париж");
        assertFalse(q.checkAnswer("Лондон"));
    }

    @Test
    public void testAnswerIgnoringCase() {
        Question q = new Question("Столица Франции?", "Париж");
        assertTrue(q.checkAnswer("париж"));
        assertTrue(q.checkAnswer("ПАРИЖ"));
    }

    @Test
    public void testAnswerWithSpaces() {
        Question q = new Question("Столица Франции?", "Париж");
        assertTrue(q.checkAnswer("  Париж  "));
    }
}