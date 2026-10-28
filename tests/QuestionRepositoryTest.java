package tests;
import source.QuestionRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionRepositoryTest {

    @Test
    public void testGetQuestionByIndex() {
        QuestionRepository repo = new QuestionRepository();
        Question q = repo.getQuestionByIndex(0);
        assertNotNull(q);
        assertEquals("Столица Франции?", q.getText());
    }

    @Test
    public void testGetQuestionOutOfBounds() {
        QuestionRepository repo = new QuestionRepository();
        assertNull(repo.getQuestionByIndex(999));
    }

    @Test
    public void testNegativeIndex() {
        QuestionRepository repo = new QuestionRepository();
        assertNull(repo.getQuestionByIndex(-1));
    }

    @Test
    public void testTotalCount() {
        QuestionRepository repo = new QuestionRepository();
        assertEquals(3, repo.getTotalCount());
    }
}
